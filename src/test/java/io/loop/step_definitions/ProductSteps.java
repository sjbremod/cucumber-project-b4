package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.loop.pages.POM;
import io.loop.pages.ProductPage;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProductSteps {
    public static String getProductPrice(String product) {


        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualPrice = Driver.getDriver().findElement(By.xpath("//a[normalize-space(.)='" + product + "']/../../h5")).getText();

        return actualPrice.substring(1);
    }

    POM pages = new POM();
    ProductPage productPage = new ProductPage();
    private static final Logger LOG = LogManager.getLogger();

    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("product.url"));
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LOG.info("User is on Homepage");


    }
    @Then("User should be able to see expected prices in the following products")
    public void user_should_be_able_to_see_expected_prices_in_the_following_products(List<Map<String, String>> productDetails) {
        for (Map<String, String> productDetail : productDetails) {
//            System.out.println("======Product Details=========");
//            System.out.println("productDetail.get(\"Category\") = " + productDetail.get("Category"));
//            System.out.println("productDetail.get(\"Product\") = " + productDetail.get("Product"));
//            System.out.println("productDetail.get(\"expectedPrice\") = " + productDetail.get("expectedPrice"));


            // click the category
            pages.getProductPage().clickCategory(productDetail.get("Category"));

            // get actual price
            String actualPrice = pages.getProductPage().getProductPrice(productDetail.get("Product"));

            // get product price from my data table
            String expectedPrice = productDetail.get("expectedPrice");

            // do assertion
            assertEquals("Expected does not match the actual", expectedPrice, actualPrice);
            LOG.info("Validation of the price for: " + productDetail.get("Category")+ ", for Product: " + productDetail.get("Product") + " expected: " + expectedPrice +" - actual: " +actualPrice);
        }
    }

    @Then("user should be able toi see expected price in teh following products with listOfLists")
    public void user_should_be_able_toi_see_expected_price_in_teh_following_products_with_list_of_lists(List<List<String>>productDetails) {


        for (List<String> productDetail : productDetails) {
            // category
            productPage.clickCategory(productDetail.get(0));
            // get actual price for each product
            String actualPrice = productPage.getProductPrice(productDetail.get(1));
            //get expectedPrice from feature file
            String expectedPrice = productDetail.get(2);

            // assertion
            assertEquals("Expected does not match the actual", expectedPrice, actualPrice);
            LOG.info("validation of the price for: "+productDetail.get(0)+", for Product: " + productDetail.get(1) + " expected: " + expectedPrice+" - actual: " +actualPrice);

        }



    }

    @Then("user should be able to see the following names in their groups")
    public void user_should_be_able_to_see_the_following_names_in_their_groups(Map<String,List<String>> students) {
        List<String> group2 = students.get("Group 2");
        System.out.println("group2 = " + group2);

        List<String> group1 = students.get("Group 1");
        System.out.println("group1 = " + group1);

    }

}
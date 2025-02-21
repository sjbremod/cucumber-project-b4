package io.loop.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.loop.pages.GoogleSearchPage;
import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;


import static junit.framework.TestCase.assertEquals;

public class GoogleSearchStepDefs {
    GoogleSearchPage googleSearchpage = new GoogleSearchPage();

    @Given("user is on Google search page")
    public void user_in_on_google_search_page() {
        Driver.getDriver().get(ConfigurationReader.getProperties("google.url"));
//    public void user_is_on_google_search_page() {
//        Driver.getDriver().get(ConfigurationReader.getProperties("google.url"));
//        BrowserUtils.takeScreenShot();
//        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
//        js.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
    }
    @When("user types Loop Academy in the google search box and clicks enter")
    public void user_types_loop_academy_in_the_google_search_box_and_clicks_enter() throws InterruptedException {

        googleSearchpage.searchBox.sendKeys("Loop Academy"+ Keys.ENTER);

        WebElement element = Driver.getDriver().findElement(By.xpath("//iframe[@title='reCAPTCHA']"));

        Driver.getDriver().switchTo().frame(element);

        if(googleSearchpage.captcha.isDisplayed()){
            googleSearchpage.captcha.click();
        }
        Driver.getDriver().switchTo().defaultContent();
       // Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(10000);
    }
    @Then("user should see Loop Academy - Google search in the google title")
    public void user_should_see_loop_academy_google_search_in_the_google_title() {
        String actualTitle = Driver.getDriver().getTitle();

        assertEquals("Expected result does not match actual","Loop Academy - Google Search",actualTitle);
    }
    @When("user types {string} in the google search box and clicks enter")
    public void user_types_in_the_google_search_box_and_clicks_enter(String input) throws InterruptedException {
        googleSearchpage.searchBox.sendKeys(input + Keys.ENTER);
        WebElement element = Driver.getDriver().findElement(By.xpath("//iframe[@title='reCAPTCHA']"));

        Driver.getDriver().switchTo().frame(element);

        if(googleSearchpage.captcha.isDisplayed()){
            googleSearchpage.captcha.click();
        }
        Driver.getDriver().switchTo().defaultContent();
        // Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Thread.sleep(10000);
    }
    @Then("user should see {string} in the google title")
    public void user_should_see_in_the_google_title(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        String actualTitle = Driver.getDriver().getTitle();
        assertEquals("Expected result does not match actual",expectedTitle,actualTitle);
    }
    @Then("user searches the following items")
    public void user_searches_the_following_items(List<String> items) throws InterruptedException {
//        for (String item : items) {
//            googleSearchpage.searchBox.clear();
//            googleSearchpage.searchBox.sendKeys(item + Keys.ENTER);
//            googleSearchpage.handleCaptcha(Driver.getDriver(), googleSearchpage.captcha);
//            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
//            wait.until(ExpectedConditions.titleContains(item + " - Google Search"));
//            assertEquals("Expected result doesn't match actual result", item + " - Google Search", Driver.getDriver().getTitle());
//        }
        items.forEach(p->{
            googleSearchpage.searchBox.clear();
            googleSearchpage.searchBox.sendKeys(p + Keys.ENTER);
            googleSearchpage.handleCaptcha(Driver.getDriver(), googleSearchpage.captcha);
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.titleContains(p + " - Google Search"));
            assertEquals("Expected result doesn't match actual result", p + " - Google Search", Driver.getDriver().getTitle());
        });
    }
    @Then("we love Loop Academy")
    public void we_love_loop_academy() {
        System.out.println("We Love Loop Academy");
    }

    @When("user search for {string}")
    public void user_search_for(String country) {
        googleSearchpage.searchBox.sendKeys("What is the capital of " + country +Keys.ENTER);
    }
    @Then("user should see the {string} in the results")
    public void user_should_see_the_in_the_results(String capital) {
        googleSearchpage.handleCaptcha(Driver.getDriver(), googleSearchpage.captcha);
        assertEquals("Expected capital city: " + capital + " does not match with actual one: " + googleSearchpage.capital.getText(), capital, googleSearchpage.capital.getText());
    }
}
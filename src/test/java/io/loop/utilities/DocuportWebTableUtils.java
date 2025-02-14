package io.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocuportWebTableUtils {

    /**
     * returns any fields from table by given email address
     * @param driver
     * @param emailAddress
     * @param field
     * @return
     */

    public static String returnAnyField(WebDriver driver, String emailAddress, String field) throws InterruptedException {
        WebElement element = null;
        String xpath = "";

        switch (field.toLowerCase()){
            case "full name":
                xpath = "//td[2][text()='" + emailAddress + "']/preceding-sibling::td//span[2]";
                element = driver.findElement(By.xpath(xpath));
                break;

            case "username":
                xpath = "//td[2][text()='" + emailAddress + "']/following-sibling::td[1]";
                element = driver.findElement(By.xpath(xpath));
                break;

            case "inviter":
                xpath = "//td[2][text()='" + emailAddress + "']/following-sibling::td[2]";
                element = driver.findElement(By.xpath(xpath));
                break;

            case "phone number":
                xpath = "//td[2][text()='" + emailAddress + "']/following-sibling::td[3]/span";
                element = driver.findElement(By.xpath(xpath));
                break;

            case "role":
                xpath = "//td[2][text()='" + emailAddress + "']/following-sibling::td[4]/span/span";
                element = driver.findElement(By.xpath(xpath));
                break;

            case "advisor":
                xpath = "//td[2][text()='" + emailAddress + "']/following-sibling::td[5]";
                element = driver.findElement(By.xpath(xpath));
                break;

            default: throw new InterruptedException("There is not suc a field: " + field);
        }
        return element.getText().trim();
    }
}
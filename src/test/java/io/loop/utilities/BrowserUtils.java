package io.loop.utilities;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.Set;

public class BrowserUtils {

    public static Scenario myScenario;

    /**
     * takes screenshot
     * @author sjb
     */
    public static void takeScreenShot() {
        try{
            myScenario.log("current url is: " + Driver.getDriver().getCurrentUrl());
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot,"image/png",myScenario.getName());
        }catch(WebDriverException wbd){
            wbd.getMessage();
           }catch(ClassCastException cce){
            cce.getMessage();

        }
    }

    /**
     * validate if driver switched to expected url or title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author sjb
     * implements assertion
     */

    public static void switchWindowAndValidate(WebDriver driver,String expectedUrl,String expectedTitle) {
        // to lower case the params in order to avoid miss type
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        //get all window handles, switch one by one and each time check if the url matches expected to stop

        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }

        Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));

    }

    /**
     * @param driver
     * @param targetTitle
     * @author sjb
     */
    public static void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for(String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().contains(targetTitle)){
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    /**
     * click any link from loop practice
     * @param nameOfPage
     * @author nsh
     */
    public static void loopLinkClick(String nameOfPage){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='"+nameOfPage+"']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * waits for provided element to be clickable
     * @param element
     * @param timeout
     * @return
     * @author sjb
     */

    public static WebElement waitForClickable(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * waits for the provided element to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @author sjb
     */
        public static void waitForInvisibility(WebElement element, int timeToWaitInSec){
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
            wait.until(ExpectedConditions.invisibilityOf(element));
        }
    /**
     *  waits for the provided elements to be visible
     * @param element
     * @param timeToWaitSec
     * @return
     * @author sjb
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}























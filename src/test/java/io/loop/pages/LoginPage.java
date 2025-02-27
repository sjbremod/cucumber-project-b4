package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.ConfigurationReader;
import io.loop.utilities.DocuportConstants;
import io.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//input[@type='text']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[@class='v-btn__content' and normalize-space()='Continue']")
    public WebElement continueButton;

    /**
     * login to docuport application
     * @param driver, which is initiallized in the TestBase
     * @param role , comes from docuport constants
     *  author sjb
     */

    public  void login (WebDriver driver, String role) throws InterruptedException {

        switch(role.toLowerCase()) {
            case "client":
                usernameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
                passwordInput.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "supervisor":
                usernameInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                passwordInput.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "advisor":
                usernameInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                passwordInput.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "employee":
                usernameInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                passwordInput.sendKeys(DocuportConstants.PASSWORD);
                break;
            default:throw new InterruptedException("There is not such a role: "+role);


        }

        loginButton.click();
        if(role.toLowerCase().equals("client")) {
            Thread.sleep(3000);
            WebElement cont = driver.findElement(By.xpath("//button[@type='submit']"));
            cont.click();
            Thread.sleep(3000);
        }
    }
    /**
     * logs out docuport application
     * @param driver
     * @author sjb
     */
    public static void logOut(WebDriver driver)  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();
        WebElement logOut = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();
    }
    public void login2(String username, String password) {
        BrowserUtils.waitForClickable(loginButton,10);
        usernameInput.clear();
        usernameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();

           if(BrowserUtils.waitForVisibility(continueButton,10).isDisplayed()){
            loginButton.click();
        continueButton.click();
       }



    }
}

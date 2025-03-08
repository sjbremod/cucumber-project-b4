package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNavigatePage {
public LeftNavigatePage() {
    PageFactory.initElements(Driver.getDriver(), this);
}

    @FindBy(xpath = "//span[contains(text(),'Upload')]")
    public WebElement uploadButton;

    @FindBy(xpath = "//span[contains(text(),'Home')]")
    public WebElement homeButton;

    @FindBy(xpath = "//span[contains(text(),'Received')]")
    public WebElement receivedDocsButton;

    @FindBy(xpath = "//span[contains(text(),'My uploads')]")
    public WebElement myUploads;

    @FindBy(xpath = "//span[contains(text(),'Invitations')]")
    public WebElement invitationsButton;

    @FindBy(xpath = "//a[contains(text(),'Terms')]")
    public WebElement termsAndConditionsButton;

    public void clickButton(String button){
        switch(button.toLowerCase().trim()){
            case "received doc":
                BrowserUtils.waitForVisibility(receivedDocsButton,10).click();
                break;
            case "home":
                BrowserUtils.waitForVisibility(homeButton,10).click();
                break;
            case "upload":
                BrowserUtils.waitForVisibility(uploadButton,10).click();
                break;
            case "invitations":
                BrowserUtils.waitForVisibility(invitationsButton,10).click();
                break;
            case "terms and conditions":
                BrowserUtils.waitForVisibility(termsAndConditionsButton,10).click();
                break;
            default: throw new IllegalArgumentException("no such button: " + button);
        }
    }
}

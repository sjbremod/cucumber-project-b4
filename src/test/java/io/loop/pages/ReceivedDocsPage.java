package io.loop.pages;

import io.loop.utilities.BrowserUtils;
import io.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReceivedDocsPage {


    public ReceivedDocsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//span[contains(text(),'Search')]")
    public WebElement searchButton;

    @FindBy(xpath = "//label[contains(text(),'Document name')]/following-sibling::input")
    public WebElement documentName;

    @FindBy(xpath = "//div[@class='v-select__selections']")
    public WebElement tags;

    @FindBy(xpath = "//label[contains(text(),'Upload date')]/..")
    public WebElement uploadDate;

    @FindBy(xpath = "//label[contains(text(),'Uploaded by')]/../..")
    public WebElement uploadedBy;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement receivedDocsSearch;

    @FindBy(xpath = "//p[contains(text(),'Your search returned no results. Make sure you search properly')]")
    public WebElement yourSearchResultMessage;







    public void clickButton(String button){
        switch (button.toLowerCase().trim()){
            case "search":
                BrowserUtils.waitForClickable(searchButton, 10).click();
                break;
            case "tags":
                BrowserUtils.waitForVisibility(tags, 10).click();
                break;
            case "upload date":
                BrowserUtils.waitForVisibility(uploadDate, 10).click();
                break;
            case "uploaded by":
                BrowserUtils.waitForVisibility(uploadedBy, 10).click();
//                BrowserUtils.clickWithJS(uploadedBy);
                break;
            case "search2":
                BrowserUtils.waitForVisibility(receivedDocsSearch, 10).click();
                break;
            default: throw new IllegalArgumentException("Not such a button: " + button);
        }
    }

    public void insertField(String field, String input) throws InterruptedException {
        switch (field.toLowerCase().trim()){
            case "document name":
                BrowserUtils.waitForVisibility(documentName, 10).sendKeys(input);
                break;
            case "tags":
                BrowserUtils.waitForClickable(tags, 10).findElement(By.xpath("//span[contains(text(),'"+ input +"')]")).click();
                break;
            case "upload date":
                Thread.sleep(3000);
                BrowserUtils.waitForClickable(uploadDate, 10).findElement(By.xpath("//div[.='"+ input +"')]")).click();
                break;
            case "uploaded by":
                BrowserUtils.waitForClickable(uploadedBy, 10).findElement(By.xpath("//div[contains(text(),'"+ input +"')]")).click();
                break;

            default: throw new IllegalArgumentException("No such a field: " + field );
        }
    }
}

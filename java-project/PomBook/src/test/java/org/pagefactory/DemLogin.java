package org.pagefactory;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemLogin {
    //this class describes the page https://demoqa.com/login

    WebDriver driver;
    JavascriptExecutor executor;

    //provide the correct element locator, example @FindBy(xpath="//*[@id='my_id']")
    @FindBy(xpath="")
    WebElement userNameElement;
    //provide the correct element locator, example @FindBy(id="my_id")
    @FindBy(id="")
    WebElement passwordElement;

    //provide the correct element locator
    @FindBy(xpath="")
    WebElement loginElement;

    //provide the correct element locator
    @FindBy(xpath="")
    WebElement titleElement;

    //provide the correct element locator
    @FindBy(xpath="")
    WebElement bookLinkElement;

    public DemLogin(WebDriver driver) {
        this.driver = driver;
        executor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    //implement the method
    public DemBooks clickBookLink() {
        closeAdvertisement();
        bookLinkElement.click();

        DemBooks books = new DemBooks(driver);
        return books;
    }

    //implement the method
    public void setUserName(String userNameString) {


    }

    //implement the method
    public void setPassword(String passwordString) {


    }

    //implement the method
    public void clickLogin() {

    }

    //implement the method
    public String getPageTitle() {

    }

    //implement the method
    public  void closeAdvertisement() {
        
    }
}

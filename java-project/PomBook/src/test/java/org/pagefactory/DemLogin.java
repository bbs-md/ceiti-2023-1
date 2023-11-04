package org.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.utils.Utils;

public class DemLogin {

    WebDriver driver;
    JavascriptExecutor executor;

    @FindBy(xpath="")
    WebElement userNameElement;

    @FindBy(id="")
    WebElement passwordElement;

    @FindBy(xpath="")
    WebElement loginElement;

    @FindBy(xpath="")
    WebElement titleElement;

    @FindBy(xpath="")
    WebElement bookLinkElement;

    public DemLogin(WebDriver driver) {
        this.driver = driver;
        executor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public DemBooks clickBookLink() {
        closeAdvertisement();
        bookLinkElement.click();

        DemBooks books = new DemBooks(driver);
        return books;
    }

    public void setUserName(String userNameString) {


    }

    public void setPassword(String passwordString) {


    }

    public void clickLogin() {

    }

    public String getPageTitle() {

    }

    public  void closeAdvertisement() {
        
    }
}

package org.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Book;

import java.util.ArrayList;
import java.util.List;

public class DemBooks {

    WebDriver driver;

    @FindBy(id="")
    WebElement searchBoxElement;

    @FindBy(xpath="")
    List<WebElement> booksElements;

    public DemBooks(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setSearch(String searchString) {
        
    }

    public List<WebElement> getBookElements() {
        
        return booksElements;
    }

    public List<Book> getBookList() {
        List<WebElement> bookList = getBookElements();
        List<Book> booksList = new ArrayList<>();

        return booksList;
    }
}

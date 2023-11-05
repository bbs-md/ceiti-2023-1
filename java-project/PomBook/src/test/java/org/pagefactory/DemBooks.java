package org.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.Book;

import java.util.ArrayList;
import java.util.List;

public class DemBooks {
    //this class describes the page https://demoqa.com/books
    WebDriver driver;

    //provide the correct element locator, example @FindBy(id="my_id")
    @FindBy(id="")
    WebElement searchBoxElement;

    //provide the correct element locator, example @FindBy(xpath="//*[@id='my_id']")
    @FindBy(xpath="")
    List<WebElement> booksElements;

    public DemBooks(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //implement the method
    public void setSearch(String searchString) {
        
    }

    //implement the method
    public List<WebElement> getBookElements() {
        
        return booksElements;
    }

    //implement the method, use utils.Book class for storing Title, Author and Publisher info
    public List<Book> getBookList() {
        List<WebElement> bookList = getBookElements();
        List<Book> booksList = new ArrayList<>();

        return booksList;
    }
}

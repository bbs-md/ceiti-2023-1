package org.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pagefactory.DemLogin;
import org.pagefactory.DemBooks;
import org.testng.annotations.BeforeTest;
import org.utils.Book;

import java.util.List;


public class PageFactory {

    static WebDriver driver;
    //fill in the field, example USER_NAME = "userName";
    public static final String USER_NAME = "";

    //fill in the field
    public static final String USER_PASSWORD = "";
    
    public static final String URL_LOGIN = "https://demoqa.com/login";


    @BeforeTest
    static public void beforeClass() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Tolik\\WebDriver\\chromedriver-win64\\chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get(URL_LOGIN);
    }

    @Test
    public void loginTest() {
        System.out.println("Start login");
        driver.get(URL_LOGIN);
        DemLogin login = new DemLogin(driver);
        login.setUserName(USER_NAME);
        login.setPassword(USER_PASSWORD);
        login.clickLogin();
        String actualTitle = login.getPageTitle();
        String expectedTitle = "Profile";
        Assert.assertEquals(expectedTitle, actualTitle);
        System.out.println("Finish login");
    }

    @Test
    public void bookTest() {
        System.out.println("Start bookTest");
        driver.get(URL_LOGIN);
        DemLogin login = new DemLogin(driver);
        login.setUserName(USER_NAME);
        login.setPassword(USER_PASSWORD);
        login.clickLogin();
        String actualTitle = login.getPageTitle();
        String expectedTitle = "Profile";
        Assert.assertEquals(expectedTitle, actualTitle);
        DemBooks books = login.clickBookLink();

        List<WebElement> bookListElement = books.getBookElements();
        System.out.println("books size " + bookListElement.size());
        int actualCountBooks = bookListElement.size();
        int expectedCountBooks = 8;
        Assert.assertEquals(expectedCountBooks, actualCountBooks);

        List<Book> bookList = books.getBookList();
        for (Book book : bookList) {
            System.out.println("book " + book);
        }

        books.setSearch("Java");
        bookListElement = books.getBookElements();
        int actualSearchCountBooks = bookListElement.size();
        int expectedSearchCountBooks = 4;
        Assert.assertEquals(expectedSearchCountBooks, actualSearchCountBooks);

        System.out.println("Finish bookTest");
    }

    @AfterClass
    static public void quit() {
        driver.quit();
    }

}

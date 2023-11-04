package org.tests.waitexample;

import com.google.common.base.Function;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.utils.Utils;

import java.time.Duration;


public class FluentWaitTest {
    private WebDriver driver;
    private String baseUrl;
    private WebElement element;

    @Before
    public void setUpProperty() {
        System.out.println("setUpProperty");
        //System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.gmail.com");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void explicitWaitTest() {
        System.out.println("Start explicitWaitTest");
        element = driver.findElement(By.id("identifierId"));
        element.sendKeys("asnegur@gmail.com");
        element.sendKeys(Keys.RETURN);
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        //WebElement tryAgainElement = (WebElement) wait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath("//*[text() ='Try again']/../a")));

        //WebElement tryAgainElement = driver.findElement(By.xpath("//*[text() ='Try again']/../a"));
        WebElement tryAgainElement = Utils.fluentWait(driver, By.xpath("//*[text() ='Try again']/../a"));
        tryAgainElement.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl " + currentUrl);

        System.out.println("Stop loginTest");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
        driver.quit();
    }
}

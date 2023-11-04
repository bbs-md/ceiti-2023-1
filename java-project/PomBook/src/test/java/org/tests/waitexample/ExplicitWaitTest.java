package org.tests.waitexample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utils.Utils;

import java.time.Duration;

public class ExplicitWaitTest {

    WebDriver driver;
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
        element.sendKeys("ansnegur@gmail.com");
        element.sendKeys(Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        //driver.findElement(By.xpath("//*[text() ='Try again']/../a"));// FAIL
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() ='Try again']/../a")));
        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text() ='Try again']/../a")));
        Utils.explicitWait(driver, ExpectedConditions.elementToBeClickable(By.xpath("//*[text() ='Try again']/../a")), 20);
        //Utils.explicitWait(driver, ExpectedConditions.elementToBeClickable(By.xpath("//*[text() ='Try again']/../a")), 20);
        driver.findElement(By.xpath("//*[text() ='Try again']/../a")).click();


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

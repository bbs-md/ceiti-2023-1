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

import java.time.Duration;
import java.util.List;

public class ImplicitWaitTest {
    private WebDriver driver;
    private String baseUrl;
    private WebElement element;

    @Before
    public void setUpProperty() {
        System.out.println("setUpProperty");
        //System.setProperty("webdriver.chrome.driver", "D:\\WebDriver\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver = WebDriverManager.chromedriver().create();
        baseUrl = "https://www.google.com";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void waitTest() {
        System.out.println("Start loginTest");
        driver.get(baseUrl);
        element = driver.findElement(By.id("lst-ib"));
        element.sendKeys("Selenium WebDriver Interview question");
        element.sendKeys(Keys.RETURN);
        List<WebElement> list = driver.findElements(By.className("_Rm"));
        System.out.println("size " + list.size());
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

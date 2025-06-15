package com.selenium.testing;
import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class IamDaveUITest {

	WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Automatically handles driver download
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.iamdave.ai/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testHomePageTitle() {
        String expectedTitle = "DaveAI - The Experience Management Platform";
        String actualTitle = driver.getTitle();
        assert actualTitle.contains("DaveAI") : "Title mismatch!";
    }
    @Test
    public void testNavigationMenu() {
        try {
            // Step 1: Hover over "Solutions" menu
            WebElement solutionsMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[.//span[contains(text(),'Solutions')]]")));

            Actions actions = new Actions(driver);
            actions.moveToElement(solutionsMenu).perform();

          
        } catch (Exception e) {
            e.printStackTrace();
            assert false : "Exception during navigation test: " + e.getMessage();
        }
    }

    @Test
    public void testLogoPresence() {
        WebElement logo = driver.findElement(By.cssSelector("img[alt*='DaveAI']"));
        assert logo.isDisplayed();
    }
   

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

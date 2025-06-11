package com.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.*;

public class IamDaveUITest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup(); // Automatically handles driver download
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.iamdave.ai/");
    }

    @Test
    public void testHomePageTitle() {
        String expectedTitle = "DaveAI - The Experience Management Platform";
        String actualTitle = driver.getTitle();
        assert actualTitle.contains("DaveAI") : "Title mismatch!";
    }
    @Test
    public void testNavigationMenu() {
        WebElement menuButton = driver.findElement(By.xpath("//a[text()='Solutions']"));
        menuButton.click();
        // Wait and assert that a solution-related section or URL is displayed
        assert driver.getCurrentUrl().contains("solutions");
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

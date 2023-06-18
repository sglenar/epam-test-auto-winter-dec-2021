package com.epam.tc.lesson02;

import static java.util.Objects.requireNonNull;
import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikipediaTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //String path = requireNonNull(getClass().getClassLoader().getResource("chromedriver.exe")).getPath();
        System.setProperty("webdriver.chrome.driver", "C:/data/SlaveForATCourse/workspace/Task 3/src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        // implicitly waits
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));      // default 0 sec
        // driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));     // default 300 sec
        // driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));       // default 30 sec
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();      // close all tabs and processes
        // driver.close();  // close active tab
    }

    @Test
    public void testWikipediaTitle() {
        // open wikipedia homepage
        driver.get("https://wikipedia.org");

        // assertion
        assertEquals(driver.getTitle(), "Wikipedia");
    }

    @Test
    public void testSearchWikipedia() {
        // open wikipedia homepage
        driver.get("https://wikipedia.org");

        // type 'EPAM' in search input
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("EPAM");

        // (1st option) click on search button
        WebElement searchBtn = driver.findElement(By.className("pure-button-primary-progressive"));
        searchBtn.click();

        // (2nd option) submit searchInput
        // searchInput.submit();

        // assertion
        assertEquals(driver.getTitle(), "EPAM - Wikipedia");
    }

    // Before you run this test uncomment implicitlyWaits first
    @Test
    public void testWikipediaSuggestImplicitlyWait() {
        // open wikipedia homepage
        driver.get("https://wikipedia.org");

        // type 'EPAM' in search input
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("EPAM");

        // click on first suggest
        List<WebElement> suggestions = driver.findElements(By.cssSelector(".suggestion-link"));
        suggestions.get(0).click();

        // assertion
        assertEquals(driver.getTitle(), "EPAM - Wikipedia");
    }

    @Test
    public void testPrintDefaultTimeouts() {
        long implicitlyWaitTimeout = driver.manage().timeouts().getImplicitWaitTimeout().getSeconds();
        long pageLoadTimeout = driver.manage().timeouts().getPageLoadTimeout().getSeconds();
        long scriptTimeout = driver.manage().timeouts().getScriptTimeout().getSeconds();

        System.out.println("Default implicitWaitTimeout: " + implicitlyWaitTimeout);
        System.out.println("Default pageLoadTimeout: " + pageLoadTimeout);
        System.out.println("Default scriptTimeout: " + scriptTimeout);
    }

    @Test
    public void testWikipediaSuggestExplicitlyWait() {
        // open wikipedia homepage
        driver.get("https://wikipedia.org");

        // type 'EPAM' in search input
        WebElement searchInput = driver.findElement(By.id("searchInput"));
        searchInput.sendKeys("EPAM");

        // wain for suggests elements to appear (with ExpectedConditions)
        // WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // List<WebElement> suggests = driverWait.until(
        //     ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".suggestion-link"), 1)
        // );

        // wain for suggests elements to appear (without ExpectedConditions)
        WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> suggests = driverWait.until(d -> {
            List<WebElement> elements = d.findElements(By.cssSelector(".suggestion-link"));
            return !elements.isEmpty() ? elements : null;
        });

        // click on first suggest
        suggests.get(0).click();

        // assertion
        assertEquals(driver.getTitle(), "EPAM - Wikipedia");
    }
}

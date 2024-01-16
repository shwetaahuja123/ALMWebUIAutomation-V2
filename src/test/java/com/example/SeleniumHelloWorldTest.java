package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.example.objects.LoginPage;
import com.aventstack.extentreports.Status;


public class SeleniumHelloWorldTest {
    private WebDriver driver;
    private ExtentHtmlReporter htmlReporter;
    private ExtentReports extent;
    private ExtentTest test;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        // Initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter("extentReports.html");

        // Initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "/Users/shwetaa/chromedriver");

        // Initialize a ChromeDriver instance
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLogin() throws InterruptedException {
        // Create a test instance in the report
        test = extent.createTest("testLogin", "Test to login into ALM");

        // Navigate to Google
        driver.get("https://learningmanagerstage1.adobe.com/acapindex.html");
        //test.pass("Navigated to Google");

        // Perform your test logic here, e.g., check the title
        //String title = driver.getTitle();
        /*
        try {
            Assert.assertEquals(title, "Google");
            test.log(Status.PASS, "Title is correct");
        } catch (AssertionError e) {
            test.log(Status.FAIL, "Assertion failed: " + e.getMessage());
            throw e; // Re-throw the AssertionError to fail the test
        }
        */
        loginPage.enterEmail("shwetaa+56@adobetest.com");
        loginPage.clickSubmitButton();
        Thread.sleep(10000);
        loginPage.enterPassword("Learner#12");
        loginPage.clickContinueButton();
        Thread.sleep(10000);

    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();

        // Write test information from the started reporters to their output view
        extent.flush();
    }
}
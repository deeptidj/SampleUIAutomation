package com.deepti.sele;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by deepti on 2/28/18.
 */
public class VerifyActionsClassMethods {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeTest
    public void setupTest() {
        System.out.println("*** SetUp Test ***");

        System.setProperty("webdriver.chrome.driver", "/Users/deepti/Downloads/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);

        //Set the base URL.
        //driver.get("http://jsbin.com/usidix/1");
        driver.get("http://demo.guru99.com/test/newtours/");

    }
    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }

    }

    @Test(groups = { "sample2" })
    public void verifyActionsDriverMethods() {
        System.out.println("Verify Actions class methods");

        new Actions(driver).contextClick().perform();

        try {
            Thread.sleep(5000);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Done");

    }


}

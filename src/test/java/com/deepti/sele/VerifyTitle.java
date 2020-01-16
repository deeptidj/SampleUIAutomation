package com.deepti.sele;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

import org.testng.Assert;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by deepti on 2/28/18.
 */
public class VerifyTitle {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeSuite
    public void createWebDriver() {
        System.out.println("** Before Suite ** ");
        //ChromeDriverManager.getInstance().setup();

    }
    @BeforeTest
    public void setupTest() {
        System.out.println("*** SetUp Test : Bravo 1 Carabiner 1 Case 1 ***");

        System.setProperty("webdriver.chrome.driver", "/Users/deepti/Downloads/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);

        //Set the base URL.
        driver.get("https://google.com");

    }
    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }

    }

    @Test(groups = { "sample1" })
    public void verifyGoogleTitleFlow() {
        System.out.println("World, welcome to selenium!");
        System.out.println("sample test case 1");
        driver.findElement(By.name("q")).sendKeys("" +
                "selenium");
        System.out.println(driver.getTitle());
        try {
            Thread.sleep(5000);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Assert.assertEquals("Google", driver.getTitle());

    }
    @Test(groups = { "sample2" })
    public void verifySomethingFlow() {
        System.out.println("sample test case 2; same as sample 1");
        driver.findElement(By.name("q")).sendKeys("" +
                "selenium");
        Assert.assertEquals("Google", driver.getTitle());

    }


}

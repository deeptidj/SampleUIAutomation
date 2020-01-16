package com.deepti.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by deepti on 1/16/20.
 */
public class SearchFormIT {
    private WebDriver driver;
    @BeforeTest
    public void setupTest() {

        System.out.println("*** SetUp Test ***");

        System.setProperty("webdriver.chrome.driver", "/Users/deepti/Downloads/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Set the base URL.
        driver.get("https://www.google.com/");
        SearchPage searchPg = PageFactory.initElements(driver,SearchPage.class);


    }
    @AfterTest
    public void teardown() {
        if (driver != null) {
             driver.quit();
        }

    }
    @Test
    public void verifyTitle() {

        System.out.println(driver.getCurrentUrl());


        try {
            Thread.sleep(5000);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Google");
    }


}

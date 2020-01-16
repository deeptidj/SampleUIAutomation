package com.deepti.sele;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


/**
 * Created by deepti on 2/28/18.
 */
public class VerifyLocatorsMethods {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeTest
    public void setupTest() {
        System.out.println("*** SetUp Test ***");

        System.setProperty("webdriver.chrome.driver", "/Users/deepti/Downloads/chromedriver");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.manage().window().maximize();
      //  wait = new WebDriverWait(driver, 30);

        //Set the base URL.
        driver.get("http://demo.guru99.com/test/newtours/");

    }
    @AfterTest
    public void teardown() {
        if (driver != null) {
           // driver.quit();
        }

    }
    @Test(groups = {"sample4"})
    public void verifyCSS() {
        System.out.println("CSS ");
        driver.get("http://demo.guru99.com/test/newtours/reservation.php");
        driver.findElement(By.linkText("ITINERARY")).click();
        //Radio One Way
        driver.findElement(By.cssSelector("input[name='tripType'][value='oneway']")).click();

        //drop down passengers
        Select drpPassengers = new Select(driver.findElement(By.name("passCount")));
        drpPassengers.selectByVisibleText("2");


        //drop down passengers
        Select drpPort = new Select(driver.findElement(By.name("fromPort")));
        drpPort.selectByValue("London");



      driver.findElements(By.cssSelector("input[name='findFlights']")).get(0).click();

    }


    @Test(groups = { "sample3" })
    public void verifyLocatorMethods() {
        System.out.println("Verify Locator methods");

        WebElement ele = driver.findElement(By.linkText("SIGN-ON"));
        ele.click();

        System.out.println(driver.getCurrentUrl());

        WebElement userName = driver.findElement(By.name("userName"));

        userName.sendKeys("deeptidj@gmail.com   ");

        WebElement pwd = driver.findElement(By.name("password"));

        pwd.sendKeys("DestiNAtion   ");
        driver.findElement(By.name("submit")).click();

        System.out.println(driver.getCurrentUrl());


        try {
            Thread.sleep(5000);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }


}

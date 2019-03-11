package com.travelers.tests;

import com.travelers.helpers.DriverFactory;
import com.travelers.helpers.DriverType;
import com.travelers.helpers.NoSuchDriverException;
import com.travelers.helpers.SeleniumHelper;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseSeleniumPHPTravelersTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUp() throws NoSuchDriverException {
        System.out.println("Before test");
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @AfterTest
    public void tearDown(){
        System.out.println("After test");
        driver.quit();
    }
}

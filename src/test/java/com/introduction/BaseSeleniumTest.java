package com.introduction;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseSeleniumTest {
    protected WebDriver driver;

    @BeforeTest
    public void setUp(){
        System.out.println("Before test");
        String driverpath = "C:\\Users\\Michal\\Desktop\\Selenium\\TetowanieAutomatyczne\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverpath);
        Dimension dimension  = new Dimension(500, 500);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        System.out.println("After test");
        driver.quit();
    }
}

package com.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitsTest extends BaseSeleniumTest {

    @Test
    public  void waitTest(){
        //driver.manage().timeouts().implicitlyWait(10,  TimeUnit.SECONDS);
        driver.get("file:///C:/Users/Michal/Desktop/Selenium/pobranePlikiSelenium/Waits2.html");
        driver.findElement(By.tagName("button")).click();
        //Thread.sleep(6000);
        waitforWebElement1(By.tagName("p"));
        WebElement paragraph = driver.findElement(By.tagName("p"));
        System.out.println(paragraph.getText());
        Assert.assertEquals(paragraph.getText(), ("Dopiero się pojawiłem!"));
    }

    private void waitforWebElement(By locator){
        Wait<WebDriver> wait = new WebDriverWait(driver, 10L);
        ((WebDriverWait) wait).pollingEvery(Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    private void waitforWebElement1(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10L);
        wait.until(driver1 -> {
                System.out.println("Sprawdzam czy element jest wyświetlony...");
                if (driver1.findElement(locator).isDisplayed()){
                    System.out.println("Element jest wyświetlony");
                    return true;
                }else{
                    System.out.println("Element nie jest wyświetlony");
                    return false;
                }
        });
    }
}

package com.introduction;

import org.openqa.selenium.*;
import org.testng.annotations.Test;

import java.util.List;

public class HandlingFramesTest extends BaseSeleniumTest {


    @Test
    public void handlingFreamsTest() {
        driver.get("C:\\Users\\Michal\\Desktop\\Selenium\\pobranePlikiSelenium\\iFrameTest.html");
        driver.switchTo().frame(0);
        WebElement clikOnMeButton = driver.findElement(By.id("clickOnMe"));
        clikOnMeButton.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
        List<WebElement> headers = driver.findElements(By.tagName("h1"));
        System.out.println(headers.size());
        headers.forEach(webElement ->
                System.out.println(webElement.getText()));

    }
}

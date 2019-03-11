package com.introduction;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;

public class FileUploadTest extends BaseSeleniumTest {

    @Test
    public void uploadFileTest(){
        SeleniumHelper helper = new SeleniumHelper(driver);
        driver.get("file:///C:/Users/Michal/Desktop/Selenium/pobranePlikiSelenium/FileUpload.html");
        String path = new File("src/main/resources/test388639700.png").getAbsolutePath();
        driver.findElement(By.id("myFile")).sendKeys(path);
        helper.takeScreenShot();
    }
}

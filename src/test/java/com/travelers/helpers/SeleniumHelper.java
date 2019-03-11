package com.travelers.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;


public class SeleniumHelper {

    private WebDriver driver;

    public SeleniumHelper(WebDriver driver){
        this.driver = driver;
    }
    public void waitForelemet(By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForelemet(WebElement element){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForList(List<WebElement> list){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
        wait.until(driver1 -> list.size() > 0);
    }
    public static void takeAScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot takesScreenShot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("src/main/resources/" + LocalTime.now().getNano() + ".png");
        Files.copy(screenShotFile.toPath(), destinationFile.toPath());
    }
}

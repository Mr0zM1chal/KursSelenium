package com.introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DeagAndDropTest extends BaseSeleniumTest {

    @Test
    public  void dragNDropTest(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        WebElement elementToDrag = driver.findElement(By.id("draggable"));
        WebElement dropZone = driver.findElement(By.id("droptarget"));

        Actions action = new Actions(driver);
        action.dragAndDrop(elementToDrag, dropZone).build().perform();

    }
}

package com.introduction;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


public class GoogleTest extends BaseSeleniumTest{

    @FindBy(name = "q")
    private List<WebElement> serachInput;

    @Test
    public void googleSearchTest(){
        SeleniumHelper helper = new SeleniumHelper(driver);
        PageFactory.initElements(driver, this);
        driver.get("https://www.google.com");
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement okButton = driver.findElement(By.name("btnK"));
        WebElement kButton = driver.findElement(By.xpath("/html/body/div/div[3]/form/div[2]/div/div[3]/center/input[1]"));
        serachInput.get(0).sendKeys("Selenium");
        helper.takeScreenShot();
        serachInput.get(0).sendKeys(Keys.ESCAPE);

        kButton.click();
        helper.takeScreenShot();
        WebElement seleniumpageLink = driver.findElement(By.partialLinkText("Selenium - Web Browser Automation"));
        seleniumpageLink.click();
        helper.takeScreenShot();
        String expectedTitle = "Selenium - Web Browser Automation";
        driver.findElement(By.xpath("//*[@id=\"close\"]")).click();
        Assert.assertEquals(driver.getTitle(), expectedTitle );
  }
}       /*
         private void swichRoNewWindow(WebDriver driver, String currentWindowName) {
        System.out.println("Wartość obecnego ogna to: " + currentWindowName);
        Set<String> windows = driver.getWindowHandles();
        System.out.println("ilość okien przeglądarki to: " + windows.size());

        for(String window: windows){
            if(!window.equals(currentWindowName)){
                driver.switchTo().window(window);
            }
        }
    }
        WebElement newPageButton = driver.findElement(By.id("newPage"));
        String currentWindowName = driver.getWindowHandle();
        newPageButton.click();
        swichRoNewWindow(driver, currentWindowName);
        System.out.println("Tytuł to: " + driver.getTitle());
        System.out.println("Obecny URL to: " + driver.getCurrentUrl());

        driver.switchTo().window(currentWindowName);

        driver.findElement(By.name("username")).sendKeys("Mouse");


         WebElement topSecretElement = driver.findElement(By.className("topSecret"));

        checkIfElementExist(By.tagName("a"), driver);
        checkIfElementExist(By.tagName("z"), driver);

        checkIfElementExist(driver, By.tagName("a"));
        checkIfElementExist(driver, By.tagName("ASssA"));

 public boolean checkIfElementExist(By locator, WebDriver driver){
            if(driver.findElements(locator).size()>0){
                System.out.println("Element istnieje");
                return true;
            }
            System.out.println("Element nie istnieje na stronie");
            return false;
    }
    public void checkIfElementExist(WebDriver driver, By locator){
        try{
            driver.findElement(locator);
            System.out.println("Element istnieje");
        }catch (NoSuchElementException exc) {
            System.out.println("Element nie istnieje");
        }
    }
        if(topSecretElement.isDisplayed()){
            System.out.println("element jest widoczny");
            System.out.println(topSecretElement.getText());
        }else{
            System.out.println("element jest ukryty");
            System.out.println(topSecretElement.getAttribute("textContent"));
        }
          WebElement checkboxChecked = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (checkboxChecked.isSelected()){
            System.out.println("checkbox jest zaznaczony");
        }else{
            System.out.println("checkbox jest odznaczony");
        }

        WebElement textFirstInput = driver.findElement(By.id("fname"));
        if(textFirstInput.isEnabled()){
           textFirstInput.sendKeys("Tomek");
       }else{
           System.out.println("element jest zablokowany");
       }

         WebElement imageSmile = driver.findElement(By.id("smileImage"));
        System.out.println(imageSmile.getAttribute("naturalHeight") + " " + imageSmile.getSize().getHeight());


        WebElement paraqraph = driver.findElement(By.className("topSecret"));
        System.out.println("Ukryty tekst: " + paraqraph.getAttribute("textContent"));


        WebElement chceckBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        chceckBox.click();

        WebElement radiobutton = driver.findElement(By.xpath("//input[@value='male']"));
        radiobutton.click();
        Select carSelect = new Select(driver.findElement(By.tagName("select")));
        carSelect.selectByVisibleText("Mercedes");
        carSelect.selectByValue("audi");
        WebElement firstNameInput = driver.findElement(By.id("fname"));
        firstNameInput.sendKeys("Wojciech");
        System.out.println("Wartosc to: " + firstNameInput.getText());
        System.out.println("Wartosc to: " + firstNameInput.getAttribute("value"));
        WebElement label = driver.findElement(By.tagName("label"));
        System.out.println("Wartosc dla labelu to: " + label.getText());WebElement clickOnMyButton = driver.findElement(By.id("clickOnMe"));
        clickOnMyButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement firstNameInput = driver.findElement(By.id("fname"));
        firstNameInput.sendKeys("Michał");
        firstNameInput.clear();
        firstNameInput.sendKeys("Cyprian");
        */

      /*
        WebElement firstnameInput = driver.findElement(By.name("fname"));
        WebElement firstnameInput2 = ((ChromeDriver) driver).findElementById("fname");
        WebElement w33SchoolLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
        WebElement w33SchoolLink2 = driver.findElement(By.partialLinkText("Weird"));
        WebElement topSecretparagraph = driver.findElement(By.className("topSecret"));
        WebElement firstInput = driver.findElement(By.tagName("input"));

        WebElement clickOnMeButton = driver.findElement(By.cssSelector("#clickOnMe"));
        WebElement links = driver.findElement(By.cssSelector("a"));
        WebElement topSecretCss = driver.findElement(By.cssSelector(".topSecret"));
        WebElement tdFirstCgild = driver.findElement(By.cssSelector("td:first-child"));

        WebElement clickOnMeXPathButton = driver.findElement(By.xpath("html/body/button"));
        WebElement clickOnMeXPathButton2 = driver.findElement(By.xpath("//button"));
        WebElement linksXPath = driver.findElement(By.xpath("//a"));
        WebElement topSecretXPath = driver.findElement(By.xpath("//p[@class='topSecret']"));
        WebElement topSecretXPath2 = driver.findElement(By.xpath("//*[@class='topSecret']"));
        WebElement linkstext = driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));

      List<WebElement> links = driver.findElements(By.tagName("a"));
      if(links.size() > 0)
      System.out.println("Lista istnieje");
      else{
          System.out.println("Linki nie istnieją");
      }
      WebElement clickOnMeCss = driver.findElement(By.cssSelector("#clickOnMe"));
        WebElement clickOnMeXPath = driver.findElement(By.xpath("//*[@id=\"clickOnMe\"]"));
        */

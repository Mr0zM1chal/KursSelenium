package com.introduction;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class AnnotationTest extends BaseSeleniumTest{
    @FindBys({
            @FindBy(tagName = "table"),
            @FindBy(className = "tableHeader")
    })
    private List<WebElement> elements;

    @FindBy(xpath = "//input")
    private  List<WebElement> inputs;

    @FindBy(xpath = "//button")
    private  List<WebElement> buttons;

    @FindAll({
            @FindBy(xpath = "//input"),
            @FindBy(xpath = "//button")
    })
    private List<WebElement> inputsAndButtons;

    @Test
    public void googleSearchTest(){
        SeleniumHelper helper = new SeleniumHelper(driver);
        PageFactory.initElements(driver, this);
        driver.get("C:\\Users\\Michal\\Desktop\\Selenium\\pobranePlikiSelenium\\Test.html");
        System.out.println("elements size is: " + elements.size());
        System.out.println("inputs size is: " + inputs.size());
        System.out.println("buttons size is: " + buttons.size());
        System.out.println("inputs and buttons size is: " + inputsAndButtons.size());
    }
}

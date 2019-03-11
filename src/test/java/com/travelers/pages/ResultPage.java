package com.travelers.pages;

import com.travelers.helpers.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPage {

    @FindBy(xpath = "//table[@class='bgwhite table table-striped']")
    private WebElement resultTable;

    private SeleniumHelper helper;
    private WebDriver driver;

    public ResultPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        helper = new SeleniumHelper(driver);
        this.driver = driver;
    }

    public List<String> getHotelsName(){
        List<String> hotelNames = new ArrayList<>();
        helper.waitForList(resultTable.findElements(By.xpath(".//h4//b")));
        List<WebElement> hotelNamesWebElements = resultTable.findElements(By.xpath(".//h4//b"));
        for(WebElement hotelNameElement : hotelNamesWebElements){
            System.out.println(hotelNameElement.getText());
            hotelNames.add(hotelNameElement.getText());
        }
        return hotelNames;
    }
    public List<String> getHotelPrices(){
        helper.waitForelemet(resultTable);
        List<WebElement> hotelPrices = resultTable.findElements(By.xpath("//div[contains(@class, 'price_tab')]//b"));
        List<String> prices = hotelPrices.stream().map(element -> element.getText()).collect(Collectors.toList());
        for(String price : prices){
            System.out.println(price);
        }
        return prices;
    }
}

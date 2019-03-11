package com.travelers.pages;

import com.travelers.helpers.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomePages {

    @FindBy(xpath = "//*[@id=\"citiesInput\"]")
    private WebElement searchCityInput;

    @FindBy(name = "checkin")
    private WebElement checkIn;

    @FindBy(name = "checkout")
    private WebElement checkOut;

    @FindBy(id = "totalGuestsInput")
    private WebElement totalTravelersInput;

    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[1]/form/div[5]/button")
    private WebElement searchButton;

    private SeleniumHelper helper;

    private WebDriver driver;

    public HomePages(WebDriver driver) {
        PageFactory.initElements(driver, this);
        helper = new SeleniumHelper(driver);
        this.driver = driver;
    }
    public HomePages setCityHotel(String city){
        searchCityInput.sendKeys(city);
        //By locator = By.xpath("//*[@id=\"citiesInput\"]");
        helper.waitForelemet(searchCityInput);
        searchCityInput.sendKeys(Keys.ARROW_DOWN);
        By locator1 = By.xpath("/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[1]/form/div[1]/div/div[2]/div/ul/li[1]/div/b");
        helper.waitForelemet(locator1);
        searchCityInput.sendKeys(Keys.ENTER);
        return this;
    }
    public HomePages setDateRange(String checkin, String checkout){
        checkIn.sendKeys(checkin);
        checkOut.sendKeys(checkout);
        checkOut.click();
        return this;
    }
    public HomePages setTravelersInput(int adultQuantity, int childQuantity){
        totalTravelersInput.click();
        for (int i = 0; i < adultQuantity; i++){
            adultPlusBtn.click();
        }
        for (int j = 0; j < childQuantity; j++){
            childPlusBtn.click();
        }
        return this;
    }
    public ResultPage clickSearchButton(){
        searchButton.click();
        return new ResultPage(driver);
    }
}

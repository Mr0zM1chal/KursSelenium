package com.travelers.tests;

import com.travelers.helpers.SeleniumHelper;
import com.travelers.helpers.TestListener;
import com.travelers.pages.HomePages;
import com.travelers.pages.ResultPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class SearchHotelPHPTravelersTest extends BaseSeleniumPHPTravelersTest {

    @Test
    public void searchInputTest() throws IOException {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.phptravels.net/public/expedia/");
        HomePages homePages = new HomePages(driver);
        ResultPage resultPage = homePages.setCityHotel("London")
                .setDateRange("04/10/2019", "04/12/2019")
                .setTravelersInput(1, 0)
                .clickSearchButton();

        List<String> hotelsNames = resultPage.getHotelsName();
        //Assert.assertEquals(hotelsNames.get(1), "Hanover Hotel Victoria");
        resultPage.getHotelPrices();
        List<String> prices = resultPage.getHotelPrices();
       // Assert.assertEquals( prices.get(1), "8599.34");
    }
}

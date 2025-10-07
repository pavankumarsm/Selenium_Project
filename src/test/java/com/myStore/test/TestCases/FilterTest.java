package com.myStore.test.TestCases;

import com.myStore.test.listener.ExtentTestListener;
import com.myStore.test.listener.TestListener;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.Filter;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.Search;
import org.junit.After;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class, ExtentTestListener.class})
public class FilterTest extends BaseClass {

    HomePage homePage;
    Search search;
    Filter filter;

    @BeforeMethod
    public void setUp(){
        loadConfig();
        launchApp();
        homePage = new HomePage();
        search = new Search();
        filter = new Filter();
    }

    @AfterMethod
    public void setDown(){
        driver.quit();
    }


    @Test
    public void samsungFilter(){
        homePage.searchBar("smartphones");
        filter.brandFilter("samsung");
        Assert.assertTrue(search.productDisplayed("samsung"));
    }

    @Test
    public void appleFilter(){
        homePage.searchBar("smartphones");
        filter.brandFilter("apple");
        Assert.assertTrue(search.productDisplayed("apple"));
    }
    @Test
    public void amoledDisplay(){
        homePage.searchBar("smartphones");
        filter.displayFilter("amoled");
        Assert.assertTrue(search.productDisplayed("amoled"));
    }

    @Test
    public void oledDisplay(){
        homePage.searchBar("smartphones");
        filter.displayFilter("oled");
        Assert.assertTrue(search.productDisplayed("oled"));
    }

    @Test
    public void storage256GB(){
        homePage.searchBar("smartphones");
        filter.storageFilter("256");
        Assert.assertTrue(search.productDisplayed("256"));
    }

    @Test
    public void storage128GB(){
        homePage.searchBar("smartphones");
        filter.storageFilter("128");
        Assert.assertTrue(search.productDisplayed("128"));
    }

    @Test
    public void priceBar(){
        homePage.searchBar("smartwatch");
        filter.priceFilter("100","1000");
        Assert.assertTrue(search.productDisplayed("smartwatch"));
    }

   @Test
    public void rateFilter(){
        homePage.searchBar("phones");
        filter.applyRatingFilter();
        Assert.assertTrue(search.productDisplayed("phones"));
    }


}

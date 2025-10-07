package com.myStore.test.TestCases;

import com.myStore.test.listener.ExtentTestListener;
import com.myStore.test.listener.TestListener;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.Search;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class, ExtentTestListener.class})
public class SearchTest extends BaseClass {

    HomePage homePage;
    Search searchPage;

    @BeforeMethod
    public void setUp(){
        loadConfig();
        launchApp();
        homePage = new HomePage();
    }
    @AfterMethod
    public void setDown(){
        driver.quit();
    }

    @Test
    public void validSearch(){
        homePage.searchBar("iphone");
        searchPage = new Search();
        Assert.assertTrue(searchPage.productDisplayed("iphone"));
    }

    @Test
    public void invalidSearch(){
        homePage.searchBar("adsdhbsfxyzInvalidProduct");
        searchPage = new Search();
        Assert.assertFalse(searchPage.productDisplayed("adsdhbsfxyzInvalidProduct"),
                "Verify invalid product search shows no results");
    }

    @Test
    public void emptySearch(){
        homePage.searchBar(" ");
        searchPage = new Search();
        Assert.assertFalse(searchPage.productDisplayed(" "), "Verify empty search shows error/no results");
    }

    @Test
    public void electronicsSearch(){
        homePage.searchBar("mixer");
        searchPage = new Search();
        Assert.assertTrue(searchPage.productDisplayed("mixer"),
                "Verify valid search for mixer works");
    }

    @Test
    public void searchForGoggles(){
        homePage.searchBar("cooling goggles");
        searchPage = new Search();
        Assert.assertTrue(searchPage.productDisplayed("goggle"),"there is no valid product");
    }

    @Test
    public void instrumentSearch(){
        homePage.searchBar("violin");
        searchPage = new Search();
        Assert.assertTrue(searchPage.productDisplayed("violin"),"verify search for violin works");
    }
    @Test
    public void searchCookies(){
        homePage.searchBar("cookies");
        searchPage= new Search();
        Assert.assertTrue(searchPage.productDisplayed("cookies"),"there is no valid products");
    }
}

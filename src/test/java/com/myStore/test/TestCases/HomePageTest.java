package com.myStore.test.TestCases;

import com.myStore.test.listener.ExtentTestListener;
import com.myStore.test.listener.TestListener;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class, ExtentTestListener.class})
public class HomePageTest extends BaseClass {
    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        loadConfig();
        launchApp();
    }
    @AfterMethod
    public void setDown(){
        driver.quit();
    }

    @Test
    public  void validateLogo(){
        homePage = new HomePage();
        boolean res = homePage.validateLogo();
        Assert.assertTrue(res);
    }

    @Test
    public void searchText(){
        homePage = new HomePage();
        homePage.searchBar("laptop");
    }

    @Test
    public void searchMobile(){
        homePage = new HomePage();
        homePage.searchBar("vivo");
        String currUrl = homePage.getCurrUrl();
        Assert.assertTrue(currUrl.contains("vivo"));
    }

    @Test
    public void testProduct(){
        homePage = new HomePage();
        homePage.searchBar("laptop");
        String currUrl = homePage.getCurrUrl();
        Assert.assertTrue(currUrl.contains("laptop"));
    }

    @Test
    public void testSignInButton(){
        homePage = new HomePage();
        homePage.clickOnSignIn();
        String currUrl = homePage.getCurrUrl();
        Assert.assertTrue(currUrl.contains("signin")|| currUrl.contains("account"));
    }

    @Test
    public void sellPage(){
        homePage = new HomePage();
        homePage.sellPage();
        String currUrl = homePage.getCurrUrl();
        Assert.assertTrue(currUrl.contains("sell"));
    }

    @Test
    public void lang(){
        homePage = new HomePage();
        homePage.lang();
        String curUrl = homePage.getCurrUrl();
        Assert.assertTrue(curUrl.contains("lang"));
    }

}

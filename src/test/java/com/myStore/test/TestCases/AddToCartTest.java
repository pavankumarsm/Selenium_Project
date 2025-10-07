package com.myStore.test.TestCases;

import com.myStore.test.listener.ExtentTestListener;
import com.myStore.test.listener.TestListener;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCart;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.Search;
import com.mystore.pageobjects.loginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class, ExtentTestListener.class})
public class AddToCartTest  extends BaseClass {
    HomePage homePage;
    AddToCart addToCart;
    Search search;

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
    public void AddCartButton(){
        addToCart = new AddToCart();
        boolean isAdded = addToCart.AddToCartDisplayed();
        Assert.assertTrue(isAdded);
    }

    @Test
    public void goToCart(){
        addToCart = new AddToCart();
        addToCart.goToCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("nav_cart"), "err");
    }

    @Test
    public void testQuality(){
        homePage.dismiss();
        loginPage log1 = homePage.clickOnSignIn();
        log1.login(prop.getProperty("username"),prop.getProperty("password") );
        homePage.searchBar("iphone");
        search  = new Search();

        addToCart = search.clickAddToCart();

        int count =0;
        try{
            count = Integer.parseInt(addToCart.getItemCount());
        }catch (NumberFormatException e){
            count =0;
        }
        addToCart.addQuantity();

        int finalCount = Integer.parseInt(addToCart.getItemCount());
        Assert.assertTrue(finalCount >= count+1);
    }
}

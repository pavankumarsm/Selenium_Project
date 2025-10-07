package com.myStore.test.TestCases;

import com.myStore.test.listener.ExtentTestListener;
import com.myStore.test.listener.TestListener;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.loginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({TestListener.class, ExtentTestListener.class})
public class loginPageTest extends BaseClass {

    HomePage homePage;
    loginPage loginPage;

    @BeforeMethod
    public void setup(){
        loadConfig();
        launchApp();
        homePage = new HomePage();
        loginPage = new loginPage();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void validLogin(){
        loginPage = homePage.clickOnSignIn();
       HomePage newpage =  loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//        Assert.assertTrue(newpage.getCurrUrl().contains("ref_=nav_ya_signin"),"login failed");
    }


    @Test
    public void invalidUsername(){
        loginPage = homePage.clickOnSignIn();
        loginPage.userName("pavamn@gmail.com");
        Assert.assertTrue(loginPage.getUrl().contains("intent?arb"),"invalid username");
    }

    @Test
    public void invalidPassword(){
        loginPage = homePage.clickOnSignIn();
        loginPage.login(prop.getProperty("username"), "invalidPassword");
        Assert.assertTrue(loginPage.getUrl().contains("signin"),"invalid password");
    }

    @Test
    public void emptyCredentials(){
        loginPage = homePage.clickOnSignIn();
        loginPage.userName(" ");
        Assert.assertTrue(loginPage.getUrl().contains("signin"), "invalid password");
    }

    @Test
    public void userNameOnly(){
        loginPage = homePage.clickOnSignIn();
        loginPage.login(prop.getProperty("username"),"");
        Assert.assertTrue(loginPage.getUrl().contains("signin"), "Only username test failed");
    }
}

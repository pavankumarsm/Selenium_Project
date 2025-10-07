package com.mystore.pageobjects;


import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class loginPage extends BaseClass {

    private static final Logger log = LoggerFactory.getLogger(loginPage.class);



    @FindBy(id="ap_email_login")
    WebElement username;

    @FindBy(xpath = "//*[@id=\"continue\"]")
    WebElement continueButton;

    @FindBy(id = "ap_password")
    WebElement password;

    @FindBy(id = "signInSubmit")
    WebElement LoginButton;

    @FindBy(xpath = "//span[@class='a-list-item']")
    WebElement loginErrorMessage;


    public loginPage() {
        PageFactory.initElements(driver, this);
        log.debug("IndexPage elements are initialized");
    }

    public HomePage login(String uname , String pswd){
        log.info("log in with the username: {}",uname);
        Action.typing(username,uname);
        Action.click(driver,continueButton);
        log.debug("enter the username and click on the continue");
        Action.typing(password,pswd);
        Action.click(driver,LoginButton);
        log.info("password entered and clickd the login");
        return new HomePage();

    }
    public void userName(String name){
        log.info("enter the username: {}",name);
        Action.typing(username,name);
        Action.click(driver,continueButton);

    }

    public  String getUrl(){
        String loginUrl = driver.getCurrentUrl();
        log.debug("curr url on the login page: {}",loginUrl);
        return loginUrl;
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }

}

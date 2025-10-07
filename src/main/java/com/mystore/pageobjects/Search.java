package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Search extends BaseClass {
    public static final Logger logger = LoggerFactory.getLogger(Search.class);

    @FindBy(xpath = "//div[@data-component-type='s-search-result']//h2")
    List<WebElement> productsResult;

    public Search(){
        PageFactory.initElements(driver,this);
        logger.info("searching is initialized");
    }

    public boolean productDisplayed(String name){
        logger.info("checking the product: {}",name);
        for(WebElement product : productsResult){
            String nameOfProduct = product.getText();
            logger.debug("product titles are found: {}",name);
            if(nameOfProduct.toLowerCase().contains(name)){
                return true;
            }
        }
        logger.warn("product: {} is not found", name);
        return false;
    }

    public AddToCart clickAddToCart(){
        if(!productsResult.isEmpty()){
            logger.info("click on the first product ");
            Action.click(driver,productsResult.get(0));
        }else{
            logger.warn("no product avaliabale");
        }

        return new AddToCart();
    }

}

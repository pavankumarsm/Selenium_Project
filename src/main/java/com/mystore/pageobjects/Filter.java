package com.mystore.pageobjects;

import com.mystore.actiondriver.Action;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.mystore.base.BaseClass.driver;


public class Filter {
    private static final Logger logger = LoggerFactory.getLogger(Filter.class);

    @FindBy(xpath = "//span[text()='Samsung']")
    WebElement SamsungBox;

    @FindBy(xpath = "//span[text()='Apple']")
    WebElement appleBox;

    @FindBy(xpath = "//input[@id='low-price']")
    WebElement minRange;

    @FindBy(xpath = "//input[@id='high-price']")
    WebElement maxRange;

    @FindBy(xpath = "//input[@aria-labelledby='a-autoid-1-announce']")
    WebElement goBut;

    @FindBy(xpath = "//a[@aria-label='Apply 4 Stars & Up filter to narrow results']")
    WebElement fourStars;

    @FindBy(xpath = "//span[text()='AMOLED']")
    WebElement amoledBox;

    @FindBy(xpath = "//span[text()='OLED']")
    WebElement oledBox;

    @FindBy(xpath = "//span[normalize-space()='256 GB']")
    WebElement mostStorage;

    @FindBy(xpath = "//span[normalize-space()='128 GB']")
    WebElement moreStorage;

    public Filter(){
        PageFactory.initElements(driver,this);{
            logger.info("filter page initialized");
        }
    }

    public void brandFilter(String brand){
        logger.info("applying a brand to be filter: {}",brand);
        if(brand.equalsIgnoreCase("samsung")){
            Action.click(driver,SamsungBox);
            logger.info("samsung brand filter is applied");
        }else if(brand.equalsIgnoreCase("apple")){
            Action.click(driver,appleBox);
            logger.info("apple brand applied as a filter");
        }else{
            logger.warn("no filter is applied");
        }
    }

    public void displayFilter(String display){
        logger.info("applying a brand to be filter: {}", display);
        if(display.equalsIgnoreCase("amoled")) {
            Action.click(driver, amoledBox);
            logger.info("samsung brand filter is applied");
        } else if(display.equalsIgnoreCase("oled")){
            Action.click(driver, oledBox);
            logger.info("poco brand applied as a filter");
        }else{
            logger.warn("no filter is applied");
        }
    }

    public void storageFilter(String storage){
        logger.info("applying a brand to be filter: {}",storage);
        if(storage.equalsIgnoreCase("256")) {
            Action.click(driver, mostStorage);
            logger.info("samsung brand filter is applied");
        } else if(storage.equalsIgnoreCase("128")){
            Action.click(driver, moreStorage);
            logger.info("poco brand applied as a filter");
        }else{
            logger.warn("no filter is applied");
        }
    }

    public void priceFilter(String min, String max){

        minRange.clear();
        minRange.sendKeys(min);
        logger.info("sending the min value");

        maxRange.clear();
        maxRange.sendKeys(max);
        logger.info("applying the max range to the filter");

        Action.click(driver,goBut);
        logger.info("price filter applied");
    }

    public void applyRatingFilter() {
        logger.info("Applying 4 Stars & Up rating filter.");
        Action.click(driver, fourStars);
        logger.info("Rating filter applied.");
    }


}

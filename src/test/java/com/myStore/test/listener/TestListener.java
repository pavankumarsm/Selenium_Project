package com.myStore.test.listener;


import com.mystore.base.BaseClass;
import com.mystore.utility.ScreenshotUtil;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseClass implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getName();
        ScreenshotUtil.captureScreenshot(driver, testName);
    }

//    @Override
//    public void onTestSuccess(ITestResult result) {
//      String testName = result.getName();
//      ScreenshotUtil.captureScreenshot(driver,testName);
//    }


}

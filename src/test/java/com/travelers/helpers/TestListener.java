package com.travelers.helpers;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("On Test Start");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("On Test Success");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            System.out.println("On Test Failure");
            SeleniumHelper.takeAScreenShot(DriverFactory.getDriver(DriverType.CHROME));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchDriverException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("On Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("on Test Failed But Within Success Percentage");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("on Test Failed With Timeout");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("on Start");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("on Finish");
    }
}

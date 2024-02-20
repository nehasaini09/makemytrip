package com.base;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.utilites.ExtentReporterNG;

public class Listeners extends BaseClass implements ITestListener {
    ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReporterObject();
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Test Failed");
		try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File src = screenshot.getScreenshotAs(OutputType.FILE);
                
      FileUtils.copyFile(src, new File("./Screenshots/" + result.getName() + System.currentTimeMillis() + ".png"));
               System.out.println("Successfully captured a screenshot");
           } catch (Exception e) {
               System.out.println("Exception while taking screenshot " + e.getMessage());
      }
   }

	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
	
	
	
	
	

}

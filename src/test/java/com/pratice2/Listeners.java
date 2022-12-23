package com.pratice2;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("test is started "+result.getName());
	}
 
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("test is success "+result.getName());
			}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result,WebDriver driver) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 
		FileUtils.copyDirectory(src, new File(".//src//test//resource//photo.png"));
		
		System.out.println("test failed with timeout "+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("intiated screen shot "+result.getName());
	}

	
	
}

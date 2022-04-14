package com.crm.comcast.SDET32.genericUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.google.common.io.Files;

public class ListnerImplmentationClass implements ITestListener
{

	
	public void onTestFailure(ITestResult result) 
	{
		JavaUtility jutils = new JavaUtility();
		String dateTime = jutils.getSystemDateAndTime().replace(" ", "_").replace(":", "_");
		String testCaseName = result.getMethod().getMethodName()+dateTime;
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorShots/"+testCaseName+".png");
		try {
			Files.copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

}

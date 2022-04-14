package com.crm.comcast.SDET32.genericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class contains WebDriver specific methods
 * @author nikki
 *
 */
public class WebDriverUtility 
{
	/**
	 * this method will wait untill webpage to load
	 */
	private long pollingPeriod;
	public void waitForElement(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(IPathConstant.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
	}
	/**
	 * this method is wait for element to be clicklable
	 * @param driver
	 * @param element
	 */
	public void WaitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,IPathConstant.EXPLICIT_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * this method contains custom wait for specific element
	 * @param driver
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitForElementToBeClickableForSpecificTime(WebDriver driver,WebElement element) throws InterruptedException
	{
		FluentWait wait = new FluentWait(driver);
		wait.pollingEvery(IPathConstant.FLUENT_WAIT_TIME,TimeUnit.SECONDS);
		wait.wait(IPathConstant.FLUENT_WAIT_TIME);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElement(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<20)
		{
			try
			{
				element.click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(10000);
				count++;
			}
		}
	}
	/**
	 * This method includes switchToWindow using Iterator
	 * @param driver
	 * @param parentWindowTitle
	 */
	public void switchToWindow(WebDriver driver,String parentWindowTitle)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String winID = it.next();
			driver.switchTo().window(winID);
			String currentWindowTitle = driver.getTitle();
			if(!currentWindowTitle.equals(parentWindowTitle))
			{
				break;
			}
		}
	}
	/**
	 * this method used to handle alert popup
	 * @param driver
	 */
	public void accepetAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	public void dismissAlertPopup(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method to handle DropDown
	 * @param element
	 * @param VisibleText
	 */
	public void handleDropDown(WebElement element,String VisibleText)
	{
		Select select = new Select(element);
		select.selectByVisibleText(VisibleText);
	}
	public void handleDropDown(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void handleDropDown(String Value,WebElement element)
	{
		Select select = new Select(element);
		select.selectByValue(Value);
	}
	/**
	 * This method to handle moveToElement using Actions class
	 * @param driver
	 * @param element
	 */
	public void moveToElement(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * This method to handle right click using Actions class
	 * @param driver
	 */
	
	public void rightClickAction(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	public void handleAsyncScript(WebDriver driver,String JavaScriptCode)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
	}
	/**
	 * this method is take Screenshot
	 * @param driver
	 * @param FileName
	 * @throws IOException
	 */
	public void takeScreenShot(WebDriver driver,String FileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./errorShots/"+FileName+".png");
		Files.copy(src, dest);
	}
	public void switchToFrame(WebDriver driver,String Value)
	{
		driver.switchTo().frame(Value);
	}
	public void switchToFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame( element);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

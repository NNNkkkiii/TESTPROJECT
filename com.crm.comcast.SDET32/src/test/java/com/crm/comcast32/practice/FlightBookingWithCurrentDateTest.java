package com.crm.comcast32.practice;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.SDET32.genericUtility.BaseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.comcast.SDET32.genericUtility.ListnerImplmentationClass.class)
public class FlightBookingWithCurrentDateTest extends BaseClass
{
	@Test
	public void demoTest()
	{
		String fromDest = "Bengaluru";
		String toDest = "Goa";
		LocalDateTime date = LocalDateTime.now().plusDays(3);
		String month = date.getMonth().toString().charAt(0)+date.getMonth().toString().substring(1).toLowerCase();
		int year = date.getYear();
		int day = date.getDayOfMonth();
		String monthYear = month +" " + year;
		
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver=new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		
		     Actions a=new Actions(driver);
		     a.moveByOffset(1299,86).click().perform();
		     
		     driver.findElement(By.className("langCardClose")).click();
		     
		     driver.findElement(By.xpath("//span[text()='From']")).click();
		     driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(fromDest);
		     driver.findElement(By.xpath("//p[contains(.,'Bengaluru')]")).click();
		     
		     
		     driver.findElement(By.xpath("//span[text()='To']")).click();
		     driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(toDest);
		     driver.findElement(By.xpath("//p[contains(.,'Goa')]")).click();
		     driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		     driver.findElement(By.xpath("//div[text()='"+monthYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+day+"']")).click();
		     
	}

}

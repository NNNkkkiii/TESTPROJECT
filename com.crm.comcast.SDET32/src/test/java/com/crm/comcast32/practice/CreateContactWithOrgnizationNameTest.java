package com.crm.comcast32.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/**
 * 
 * @author Nikki
 *
 */

public class CreateContactWithOrgnizationNameTest {


	public static void main(String[] args) throws IOException 
	{
		WebDriver driver=null;
		//Generating the Random number
		Random random=new Random();
		int randomNumber=random.nextInt(10000);
		//Getting the data from Property file
		FileInputStream fisForProp=new FileInputStream("./src/test/resources/propertyFile1.properties");
		Properties property=new Properties();
		property.load(fisForProp);
		String browser= property.getProperty("browser"); 
		String URL = property.getProperty("url");
		String username= property.getProperty("username");
		String password= property.getProperty("password");
		//Getting the data from Excel sheet
		FileInputStream fisForExcel =new FileInputStream("./src/test/resources/Book2.xlsx");
		Workbook workbook = WorkbookFactory.create(fisForExcel);
		Sheet sheet = workbook.getSheet("Sheet2");
		String orgnizationName=sheet.getRow(2).getCell(2).getStringCellValue()+randomNumber;
		String firstName=sheet.getRow(2).getCell(4).getStringCellValue()+randomNumber;
		String lastName=sheet.getRow(2).getCell(5).getStringCellValue()+randomNumber;
		//Lunching the Browser
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else System.out.println("browser is not there");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("url");
		//Login Action
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		//Creating Organization to remove data dependency
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgnizationName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		//Verification
		String actualOrgnizationName = driver.findElement(By.className("dvHeaderText")).getText();
		if(actualOrgnizationName.contains(orgnizationName))
		{
			System.out.println("Pass:orgnization has been created");
		}
		else System.out.println("Fail:orgnization has not been created");
		//Creating Contacts
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		Select select = new Select(driver.findElement(By.name("salutationtype")));
		select.selectByVisibleText("Mr.");
		driver.findElement(By.name("firstname")).sendKeys(firstName);
		driver.findElement(By.name("lastname")).sendKeys(lastName);
		driver.findElement(By.xpath("//td[text()='Organization Name 			']/parent::tr/descendant::img[@src='themes/softed/images/select.gif']")).click();
		String parenWindow = driver.getWindowHandle();
		Set<String> childWindow = driver.getWindowHandles();
		for(String window :childWindow)
		{
			driver.switchTo().window(window);
		
		if(!parenWindow.equals(window))
		{
		driver.findElement(By.id("search_txt")).sendKeys(orgnizationName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText(""+orgnizationName+"")).click();
		break;
		}
		
	}
		driver.switchTo().window(parenWindow);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String actualContactName = driver.findElement(By.className("dvHeaderText")).getText();
		//Verification
		if(actualContactName.contains(lastName))
		{
			System.out.println("Pass:contact has been created");
		}
		else System.out.println("Fail:contact has not been created");
		//Logout Action
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		//closing the workbook
		workbook.close();
		//closing the browser and the server
		driver.quit();
	}

}

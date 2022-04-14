package assignment;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
/**
 * This class contains create new lead by giving vaild input to no of employee
 * @author nikki
 *
 */

public class CreatNewLeadByGivingValidInputToNoOfEmployee {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		WebDriver driver=null;
		//Generating randomNumber
		 Random random = new Random();
       int ramdomValue = random.nextInt(10000);
		FileInputStream fis =new FileInputStream("./src/test/resources/propertyFile1.properties");
		
		Properties property=new Properties();
		property.load(fis);
		 String BROWSER= property.getProperty("browser");
	       String URL= property.getProperty("url");
	       String USERNAME= property.getProperty("username");
	       String PASSWORD= property.getProperty("password");
	       if(BROWSER.equals("chrome"))
	       {
	    	   driver=new ChromeDriver();
	       }else if(BROWSER.equals("firefox"))
	       {
	    	   driver=new FirefoxDriver();
	       }else
	       {
	    	   System.out.println("driver is not present");
	       }
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	       driver.get(URL);
	       //login
	       driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	       driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	       driver.findElement(By.id("submitButton")).click();
	       //NAVIGATING TO LEAD MODULE
	       driver.findElement(By.linkText("Leads")).click();
	       driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
	       //getting data from excel Sheet
	       FileInputStream fisExcel=new FileInputStream("./src/test/resources/LeadData.xlsx");
	       Workbook workbook = WorkbookFactory.create(fisExcel);
	       Sheet sheet = workbook.getSheet("Sheet1");
	       String lastname = sheet.getRow(2).getCell(1).getStringCellValue()+ramdomValue;
	       String company = sheet.getRow(2).getCell(2).getStringCellValue()+ramdomValue;
	       driver.findElement(By.name("lastname")).sendKeys(lastname);
	       driver.findElement(By.name("company")).sendKeys(company);
	       driver.findElement(By.id("noofemployees")).sendKeys("8");
	       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	       String leadname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(leadname.contains(lastname))
	    	   System.out.println("Pass:unique lead no is created successfully");
	       else
	    	   System.out.println("Fail:unique lead no is not created successfully");
	       //logout Actions
	       Actions a=new Actions(driver);
	       a.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
	       driver.findElement(By.linkText("Sign Out")).click();
	       
		

	}

}

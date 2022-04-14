package assignment;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.comcast.SDET32.genericUtility.ExcelUtility;
import com.crm.comcast.SDET32.genericUtility.FileUtility;
import com.crm.comcast.SDET32.genericUtility.JavaUtility;
import com.crm.comcast.SDET32.genericUtility.WebDriverUtility;
/**
 * This class contains create new lead by giving vaild input to revenue
 * @author nikki
 *
 */

public class CreatNewLeadByGivingValidInputToAnnualRevenue {

	public static void main(String[] args) throws IOException 
  {
		
		
		
		WebDriver driver=null;
		//Creating the object of all the Libraries
		JavaUtility jUtils = new JavaUtility();
		FileUtility fUtils = new FileUtility();
		ExcelUtility eUtils = new ExcelUtility();
		WebDriverUtility wUtils = new WebDriverUtility();
		//Generating RandomNumber
		int randomValue = jUtils.getRandomValue();
		
		
		//Getting data from ExcelSheet and Initializing The Orgnization name
		String companyName = eUtils.getStringDataFromExcelSheet("Sheet1",1,2)+randomValue;
		String lastName = eUtils.getStringDataFromExcelSheet("Sheet1",1,1)+randomValue;
        	
		//FileInputStream fis =new FileInputStream("./src/test/resources/propertyFile1.properties");
		
		//Properties property=new Properties();
		//property.load(fis);
		
		
		 String BROWSER= fUtils.getDataFromPropertyFile("browser");
	       String URL= fUtils.getDataFromPropertyFile("url");
	       String USERNAME= fUtils.getDataFromPropertyFile("username");
	       String PASSWORD= fUtils.getDataFromPropertyFile("password");
	       /**
	        * lunching the browser
	        */
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
	       
	       /**
	        * login to the application
	        */
	       driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	       driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	       driver.findElement(By.id("submitButton")).click();
	       /**
	        * NAVIGATING TO LEAD MODULE
	        */
	       driver.findElement(By.linkText("Leads")).click();
	       driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
	       /**
	        * getting data from excel Sheet
	        */
	      // FileInputStream fisExcel=new FileInputStream("./src/test/resources/LeadData.xlsx");
	     //  Workbook workbook = WorkbookFactory.create(fisExcel);
	     //  Sheet sheet = workbook.getSheet("Sheet1");
	      // String lastname = sheet.getRow(1).getCell(1).getStringCellValue()+ramdomValue;
	       //String company = sheet.getRow(1).getCell(2).getStringCellValue()+ramdomValue;
	       driver.findElement(By.name("lastname")).sendKeys(lastName);
	       driver.findElement(By.name("company")).sendKeys(companyName);
	       driver.findElement(By.name("annualrevenue")).clear();
	       driver.findElement(By.name("annualrevenue")).sendKeys("2");
	       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	       String leadname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	       if(leadname.contains(lastName))
	    	   System.out.println("Pass:unique lead no is created successfully");
	       else
	    	   System.out.println("Fail:unique lead no is not created successfully");
	       /**
	        * logout Actions
	        */
	      // Actions a=new Actions(driver);
	       wUtils.moveToElement(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
	       driver.findElement(By.linkText("Sign Out")).click();
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
	       
		
	}

}

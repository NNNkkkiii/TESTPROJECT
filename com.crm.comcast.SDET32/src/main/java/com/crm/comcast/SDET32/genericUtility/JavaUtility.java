package com.crm.comcast.SDET32.genericUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	public int getRandomValue()
	{
		Random random = new Random();
		return random.nextInt(10000);
	}
	public String getSystemDateAndTime()
	{
		Date date = new Date();
		return date.toString();
	}
	public String getSystemDateInYYYY_MM_DDFormate()
	{
		 Date date = new Date();
		String yyyy = date.toString().split(" ")[5];
		int month = date.getMonth()+1;
		int day = date.getDate();
		return yyyy+"-"+month+"-"+day;
	}
	public void pressEnterButton() throws AWTException
	{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

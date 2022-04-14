package com.crm.comcast32.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RunTheScriptUsingMultipleData 
{
	@DataProvider
	public Object[][] dataProviderForTicketBooking() 
	{
		Object[][] objArr = new Object[5][2];
		
		objArr[0][0]="Banglore";
		objArr[0][1]="Goa";
		
		objArr[1][0]="Banglore";
		objArr[1][1]="Andaman";
		
		objArr[2][0]="Banglore";
		objArr[2][1]="Ladakh";
		
		objArr[3][0]="Banglore";
		objArr[3][1]="Cheenai";
		
		objArr[4][0]="Banglore";
		objArr[4][1]="Kashmir";
		return objArr;
		
	}
	@Test(dataProvider="dataProviderForTicketBooking")
	public void ticketBookingTest(String from,String to)
	{
		System.out.println("Travelling from"+from+"to"+to);
	}

}

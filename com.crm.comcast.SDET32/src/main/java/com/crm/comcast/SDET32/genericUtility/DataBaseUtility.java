package com.crm.comcast.SDET32.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility 
{
	Connection connection=null;
	public void connectToDataBase() throws SQLException
	{
		Driver driverRef = new Driver();
		DriverManager.registerDriver(driverRef);
        connection = DriverManager.getConnection(IPathConstant.DATABASE_URL,IPathConstant.DATABASE_USERNAME,IPathConstant.DATABASE_PASSWORD );
	}
	public void closeBDConnection() throws SQLException
	{
		connection.close();
	}

}

package com.crm.comcast.SDET32.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * this class contains the method to fetch the data from property and json file
 * @author nikki
 *
 */

public class FileUtility 
{
	/**
	 * This method will fetch the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fisForPop=new FileInputStream(IPathConstant.PROPERTY_FILE_PATH);
		Properties property = new Properties();
		property.load(fisForPop);
		return property.getProperty(key);
	}
	public String getDataFromJsonFile(String filePath,String key) throws IOException, ParseException
	{
		/**
		 * This method will fetch the data from json file
		 */
		//create an object of JSONParser
				JSONParser parser=new JSONParser();
				//Convert Physical file using java object using fileReader 
				FileReader file=new FileReader(IPathConstant.JSON_FILE_PATH);
				//convert json file to java file
				  Object obj = parser.parse(file);
				  //down casting the object type of reference to JsonObject type to access the get method
				  //by the rule of java we can not access sub class member from super class reference
				  JSONObject jObj=(JSONObject)obj;
				  //printing the values into the console using json file keys using get method
				  //method
				  return jObj.get(key).toString();
	}

}

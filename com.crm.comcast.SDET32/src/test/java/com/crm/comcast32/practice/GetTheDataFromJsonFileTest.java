package com.crm.comcast32.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * 
 * @author nikki
 *
 */

public class GetTheDataFromJsonFileTest {

	public static void main(String[] args) throws IOException, ParseException
	{    
		//create an object of JSONParser
		JSONParser parser=new JSONParser();
		//Convert Physical file using java object using fileReader 
		FileReader file=new FileReader("./src/test/resources/JsonFile.json");
		//convert json file to java file
		  Object obj = parser.parse(file);
		  //down casting the object type of reference to JsonObject type to access the get method
		  //by the rule of java we can not access sub class member from super class reference
		  JSONObject jObj=(JSONObject)obj;
		  //printing the values into the console using json file keys using get method
		  System.out.println(jObj.get("browser"));
		  System.out.println(jObj.get("url"));
		  System.out.println(jObj.get("username"));
		  System.out.println(jObj.get("password"));
		
		

	}

}

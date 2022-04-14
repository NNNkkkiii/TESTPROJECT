package com.crm.comcast32.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteTheDataToExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	
	{
		//converting the physical Representation File into java object
		FileInputStream fis=new FileInputStream("./src/test/resources/Book2.xlsx");
		//converting the physical representation of workbook to java Representation
		                  Workbook workbook = WorkbookFactory.create(fis);
		                  //getting the control of the cell and creating the cell
		                  Cell cell = workbook.getSheet("Sheet2").getRow(1).createCell(4);
		                  //passing the value to the particular cell
		                  cell.setCellValue("Pass");
		                  //Converting the java Representation of the file into Physical Representation
		                  FileOutputStream fos=new FileOutputStream("./src/test/resources/Book2.xlsx");
		                 // Converting the java Representation of the Workbook into the Physical Representation of workbook
		                  workbook.write(fos);
		                  workbook.close();
		

	}

}

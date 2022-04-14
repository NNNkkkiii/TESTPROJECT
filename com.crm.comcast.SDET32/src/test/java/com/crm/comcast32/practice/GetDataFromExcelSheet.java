package com.crm.comcast32.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class GetDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Book2.xlsx");
		         Workbook workbook = WorkbookFactory.create(fis);
		              Sheet sheet = workbook.getSheet("Sheet1");
		                         Row row = sheet.getRow(1);
		                             Cell cell = row.getCell(0);
		                                        String data = cell.getStringCellValue();
		                                        System.out.println(data);

	}

}

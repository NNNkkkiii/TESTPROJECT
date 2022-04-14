package com.crm.comcast.SDET32.genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is used to fetch and write data from or to excel Sheet
 * @author nikki
 *
 */

public class ExcelUtility 
{
	/**
	 * This method fetches String data from Excel Sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getStringDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fisForExcel=new FileInputStream(IPathConstant.EXCEL_FILE_PATH);
        Workbook workbook = WorkbookFactory.create(fisForExcel);
        return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}
	public double getNumericDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fisForExcel=new FileInputStream(IPathConstant.EXCEL_FILE_PATH);
        Workbook workbook = WorkbookFactory.create(fisForExcel);
        return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}
	/**
	 * This method fetches the boolean data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public boolean getBooleanDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fisForExcel=new FileInputStream("./src/test/resources/Book2.xlsx");
        Workbook workbook = WorkbookFactory.create(fisForExcel);
        return workbook.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
	}
	/**
	 * this method write the value into the excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param Value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeValueToExcelSheet(String sheetName,int rowNo,int cellNo,String Value) throws EncryptedDocumentException, IOException
	{
		//converting the physical Representation File into java object
				FileInputStream fis=new FileInputStream("./src/test/resources/Book2.xlsx");
				//converting the physical representation of workbook to java Representation
				     Workbook workbook = WorkbookFactory.create(fis);
				 //getting the control of the cell and creating the cell
				     workbook.getSheet(sheetName).getRow(rowNo).createCell(cellNo).setCellValue(Value);
				     //Converting the java Representation of the file into Physical Representation
	                  FileOutputStream fos=new FileOutputStream("./src/test/resources/Book2.xlsx");
	                 // Converting the java Representation of the Workbook into the Physical Representation of workbook
	                  workbook.write(fos);
	                  System.out.println("Data is updated successfully");
	                  workbook.close();
				     
	}

}

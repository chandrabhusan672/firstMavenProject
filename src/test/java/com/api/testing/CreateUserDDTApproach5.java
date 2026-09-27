package com.api.testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class CreateUserDDTApproach5 {

	String sheetno = "Sheet1";
	String filepath = "D:\\IMPORTANT\\Notes\\Rest Assured API Testing\\TestData\\TestData.xlsx";
	@Test
	public void getrows () throws IOException {
		
		FileInputStream fi = new FileInputStream (filepath); // opens connection with specified file
		XSSFWorkbook ws =new XSSFWorkbook(fi);  // to read the file 
		XSSFSheet sheet = ws.getSheet(sheetno); // to point to which sheet to open
		int rowcount = sheet.getLastRowNum();
		System.out.print ("No of rows " +  rowcount);
		ws.close();    //Use the closing statement to save heap memory
		fi.close();
		

	}
	
	@Test
	public void getColumns () throws IOException {
		
		FileInputStream fi = new FileInputStream (filepath); // opens connection with specified file
		XSSFWorkbook ws =new XSSFWorkbook(fi);  // to read the file 
		XSSFSheet sheet = ws.getSheet(sheetno); // to point to which sheet to open
		XSSFRow row = sheet.getRow(1);
		int CoulumnCount = row.getLastCellNum() ;
		System.out.print ("No of columns " +  CoulumnCount);
		ws.close();    //Use the closing statement to save heap memory
		fi.close();
	}
	
	@Test
	public void getCellData () throws IOException {
		
		FileInputStream fi = new FileInputStream (filepath); // opens connection with specified file
		XSSFWorkbook ws =new XSSFWorkbook(fi);  // to read the file 
		XSSFSheet sheet = ws.getSheet(sheetno); // to point to which sheet to open
		XSSFRow row = sheet.getRow(2);
		XSSFCell cell = row.getCell(1);
		String celldata = cell.getStringCellValue();
		System.out.print ("Cell data =  " +  celldata);
		ws.close();    //Use the closing statement to save heap memory
		fi.close();
	
}
	
	@Test
	public void setCellData () throws IOException {
		
		FileInputStream fi = new FileInputStream (filepath); // opens connection with specified file
		XSSFWorkbook ws =new XSSFWorkbook(fi);  // to read the file 
		XSSFSheet sheet = ws.getSheet(sheetno); // to point to which sheet to open
		int rownum = 0;
		XSSFRow row = sheet.getRow(rownum);
		XSSFCell cell = row.createCell(4);
		cell.setCellValue("Automation");
		FileOutputStream fo = new FileOutputStream (filepath);
		ws.write(fo);
		ws.close();    //Use the closing statement to save heap memory
		fi.close();
	    fo.close();
}

}
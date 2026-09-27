package com.api.testing;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class CreateUserDDTApproach5_Main {

	//String sheetno = "Sheet1";
	//String filepath = "D:\\IMPORTANT\\Notes\\Rest Assured API Testing\\TestData\\TestData.xlsx";
	
	public static int  getrows (String filepath, String sheetno ) throws IOException {
		
		FileInputStream fi = new FileInputStream (filepath); 
		XSSFWorkbook ws =new XSSFWorkbook(fi);  
		XSSFSheet sheet = ws.getSheet(sheetno);
		int rowcount = sheet.getLastRowNum();
		ws.close();    
		fi.close();
		return rowcount;
		

	}
	
	
	public static int getColumns (String filepath, String sheetno, int ColumnCount) throws IOException {
		
		FileInputStream fi = new FileInputStream (filepath); 
		XSSFWorkbook ws =new XSSFWorkbook(fi);  
		XSSFSheet sheet = ws.getSheet(sheetno); 
		XSSFRow row = sheet.getRow(1);
		int CoulumnCount = row.getLastCellNum() ;
		ws.close();    
		fi.close();
		return CoulumnCount;
	}
	
	
	public static String  getCellData (String filepath,String sheetno,int RowNum,int ColumnNum) throws IOException {
		
		FileInputStream fi = new FileInputStream (filepath); 
		XSSFWorkbook ws =new XSSFWorkbook(fi); 
		XSSFSheet sheet = ws.getSheet(sheetno);
		XSSFRow row = sheet.getRow(RowNum);
		XSSFCell cell = row.getCell(ColumnNum);
		String celldata = cell.getStringCellValue();
		ws.close();    
		fi.close();
		//return celldata;
		return (celldata) ;
	
}
	
	
	/*public void setCellData () throws IOException {
		
		FileInputStream fi = new FileInputStream (filepath); 
		XSSFWorkbook ws =new XSSFWorkbook(fi);  
		XSSFSheet sheet = ws.getSheet(sheetno); 
		int rownum = 0;
		XSSFRow row = sheet.getRow(rownum);
		XSSFCell cell = row.createCell(5);
		cell.setCellValue("Automation");
		FileOutputStream fo = new FileOutputStream (filepath);
		ws.write(fo);
		ws.close();    
		fi.close();
	    fo.close();
}*/

}
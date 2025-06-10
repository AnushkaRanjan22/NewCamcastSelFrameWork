package com.camcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/ExcelSheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value=wb.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
	}
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testdata/ExcelSheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int totalRow = wb.getSheet(sheetName).getLastRowNum();
		return totalRow;
	}
	
	public void getdataIntoExcel(String sheetName,int rowNo,int celNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/ExcelSheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNo).createCell(celNo);
		
		FileOutputStream fos=new FileOutputStream("./testdata/ExcelSheet.xlsx");
		wb.write(fos);
		wb.close();
	}
}

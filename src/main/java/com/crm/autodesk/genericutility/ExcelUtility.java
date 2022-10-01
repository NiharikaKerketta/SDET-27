package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache POI libraries, which is used to handle MicrosoftExcel Sheet
 * @author Niharika
 *
 */
public class ExcelUtility {
		/**
		 * its used to read the data from excel by using below arguments
		 * @throws Throwable 
		 * 
		 * 
		 */
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws Throwable {
		FileInputStream file = new FileInputStream("./data/Book01.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		String orgName = row.getCell(cellNum).getStringCellValue();
		wb.close();
		return orgName;
	}
		
}

package com.actitime.generic;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String  getPropertyValue(String key) throws Exception {
		FileInputStream fis=new FileInputStream("./data/commondata.property");
		Properties p=new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	public String getExcelValue(String sheetName,int row,int cell) throws Exception {
		FileInputStream fis=new FileInputStream("./data/Testscript.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	public void setExcelValue(String sheetName,int row,int cell,String string) throws Exception {
		FileInputStream fis=new FileInputStream("./data/Testscript.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(string);
	}

}

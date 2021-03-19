package com.actitime.generics;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLib {
	public String getPropertyValue(String key) throws Exception {
	FileInputStream fis = new FileInputStream("./testdata/commondata.property");
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
			return value;
	}
	public String getExcelValue(String sheetname, int row, int cell) throws Exception {
		FileInputStream fis = new FileInputStream("./testdata/Testscript.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
}

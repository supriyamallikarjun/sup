package com.qsp.testscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleDataInExcel {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FileInputStream file1= new FileInputStream("./data/commondata.property");
		Properties p=new Properties();
		p.load(file1);
		String URL = p.getProperty("url");
		FileInputStream file2=new FileInputStream("./data/Testscript.xlsx");
		Workbook wb=WorkbookFactory.create(file2);
		int lrn=wb.getSheet("Testing DataUse").getLastRowNum();
		int lcn=wb.getSheet("Testing DataUse").getRow(0).getLastCellNum();
		driver.get(URL);
		driver.manage().window().maximize();
		for (int i = 1; i <=lrn ;i++) {
			int j = 0;
			//loop to put the values
			for (; j <lcn ; j++) {
				String data = wb.getSheet("Testing DataUse").getRow(i).getCell(j).getStringCellValue();
				Thread.sleep(2000);
				if(j==0)
					driver.findElement(By.name("username")).sendKeys(data);
				if(j==1)
					driver.findElement(By.name("pwd")).sendKeys(data);
			}
			if (j>lcn-1)
			{
				driver.findElement(By.xpath("//a[@id='loginButton']")).click();
				try {
					driver.findElement(By.linkText("Logout")).click();
				}
				catch(Exception e) {
					driver.navigate().refresh();
				}	
			}
			

		}
		driver.close();
	}

}

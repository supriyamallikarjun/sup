package com.qsp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.actitime.generic.FileLib;

public class CustomerInfo  {
	 static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	 }
	 public WebDriver driver;
	// @BeforeTest
	 //@Parameters("browser")
	 @BeforeMethod
	 public void login() throws Exception {
		 FileLib f=new FileLib();
		 //if(browser.equalsIgnoreCase("chrome"))
			 driver=new ChromeDriver();
		// else if(browser.equalsIgnoreCase("firefox"))
			 //driver=new FirefoxDriver();
			driver.get(f.getPropertyValue("url"));
			driver.findElement(By.id("username")).sendKeys(f.getPropertyValue("username"));
			driver.findElement(By.name("pwd")).sendKeys(f.getPropertyValue("password"));
			driver.findElement(By.xpath("//div[.='Login ']")).click();

	 }
	
	@Test(groups="SmokeTesting")
	public void createCustomer() {
		Reporter.log("createCustomer",true);
	}
	@AfterMethod
	public void logout() {
		driver.quit();
	}
}

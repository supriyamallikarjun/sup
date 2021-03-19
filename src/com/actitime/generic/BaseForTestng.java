package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class BaseForTestng {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	public static WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	@BeforeClass(groups="SmokeTesting")
	public void openBrowser(String browser) {
		Reporter.log("openBrowser",true);
		if(browser.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@BeforeMethod(groups="SmokeTesting")
	public void login() throws Exception {
		Reporter.log("login",true);
		FileLib f=new FileLib();
		driver.get(f.getPropertyValue("url"));
		driver.findElement(By.id("username")).sendKeys(f.getPropertyValue("username"));
		driver.findElement(By.name("pwd")).sendKeys(f.getPropertyValue("password"));
		driver.findElement(By.xpath("//div[.='Login ']")).click();

	}
	@AfterMethod(groups="SmokeTesting")
	public void logout() {
		Reporter.log("logout",true);
		driver.findElement(By.id("logoutLink")).click();
	}
	
	@AfterClass(groups="SmokeTesting")
	public void closeBrowser() {
		Reporter.log("closeBrowser",true);
		driver.close();
	}
	public void ifFailed() throws IOException {
		TakesScreenshot t=(TakesScreenshot)driver;
		File srcfile = t.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./ScreenShot/shots.png");
		FileUtils.copyFile(srcfile, destfile);
		driver.close();
	}

}

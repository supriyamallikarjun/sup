package com.actitime.generics;

import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.util.TaskLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.pom.LoginPage;
import com.actitime.pom.TaskListPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	}
	public static WebDriver driver;
	FileLib fl=new FileLib();
	@BeforeClass
	public void openBrowser() throws Exception {
		String Url = fl.getPropertyValue("url");
		driver=new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	@BeforeMethod
	public void login() throws Exception {
		String un = fl.getPropertyValue("username");
		String pw = fl.getPropertyValue("password");
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);
	}
	@AfterMethod
	public void logout() {
		TaskListPage t=new TaskListPage(driver);
		t.getLgoutbtn().click();
	}
}

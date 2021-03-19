package com.qsp.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.actitime.generic.MouseActionsLib;

public class MouseActionWithLib {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.vtiger.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MouseActionsLib ma=new MouseActionsLib();
		WebElement element = driver.findElement(By.xpath("//a[@id='navbarDocumentation']"));
		ma.getMouseMove(driver, element);
		driver.findElement(By.partialLinkText("Contact Us")).click();
		String phoneNo = driver.findElement(By.xpath("//p[@class='mb-1']/..//p[2]")).getText();
		System.out.println(phoneNo);
		driver.close();
	}

}

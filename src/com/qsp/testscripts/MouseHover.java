package com.qsp.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.vtiger.com/");
		WebElement adress = driver.findElement(By.id("navbarDocumentation"));
		Actions act=new Actions(driver);
		act.moveToElement(adress).perform();
		driver.findElement(By.partialLinkText("Contact Us")).click();
		String phoneNo = driver.findElement(By.xpath("//p[@class='mb-1']/..//p[2]")).getText();
		System.out.println(phoneNo);
		driver.close();
	}

}

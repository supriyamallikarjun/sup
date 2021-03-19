package com.qsp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CopyPastePgrm {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/91854/Desktop/input.html");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.CONTROL+"ac");
		WebElement pwdtbx = driver.findElement(By.xpath("//input[2][@type='text']"));
		pwdtbx.clear();
		pwdtbx.sendKeys(Keys.CONTROL+"v");
		driver.close();

	}

}

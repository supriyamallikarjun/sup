package com.qsp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckboxSelection {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.actitime.com/login.do");
	boolean rs=driver.findElement(By.id("keepLoggedInLabel")).isSelected();
		if(rs)
			System.out.println("Checked");
		else
			System.out.println("Unchecked");
		driver.close();
		
		
	}

}

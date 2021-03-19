package com.qsp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlignmentInFacebook {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://en-gb.facebook.com/login/");
		int emailx = driver.findElement(By.id("email")).getLocation().x;
		int pwdx = driver.findElement(By.id("pass")).getLocation().x;
		if(emailx==pwdx)
			System.out.println("Yes,aligned properly");
		else
			System.out.println("No, are not aligned properly");
		
		
		
	}

}

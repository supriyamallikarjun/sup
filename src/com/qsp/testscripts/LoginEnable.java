package com.qsp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginEnable {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://190.210.184.180/login.do");
		boolean result=driver.findElement(By.xpath("//input[@type='submit']")).isEnabled();
		if(result)
			System.out.println("Login button is enabled");
		else
			System.out.println("Login button is disabled");
		driver.close();
	}

}

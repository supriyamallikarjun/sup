package com.qsp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/webhp");
		driver.navigate().to("https://www.actitime.com/");
		driver.findElement(By.xpath("//a[text()='Start Using actiTIME']")).click();
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("manager");
		driver.findElement(By.xpath("//*[@value=\"Start Free Trial\"]")).click();
		driver.close();
		
		
	}

}

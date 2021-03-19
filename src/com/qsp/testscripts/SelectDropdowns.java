package com.qsp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdowns {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/webhp");
		driver.findElement(By.xpath("//*[@class=\"gLFyf gsfi\"]")).sendKeys("Facebook sign up");
		driver.navigate().to("https://www.facebook.com/r.php");
		WebElement drpdwn = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select sl=new Select(drpdwn);
		sl.selectByIndex(6);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		sl.selectByValue("8");
	
		
	}

}

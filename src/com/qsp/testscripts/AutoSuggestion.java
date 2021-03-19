package com.qsp.testscripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestion {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
		driver.findElement(By.name("q")).sendKeys("i phone");
		List<WebElement> allsuggestions = driver.findElements(By.xpath("//span[contains(text(),'i phone')]/.."));
		System.out.println(allsuggestions.size());
		for(int i=0;i<allsuggestions.size();i++) {
			String text=allsuggestions.get(i).getText();
			System.out.println(text);
		}
		driver.close();
		
	}

}

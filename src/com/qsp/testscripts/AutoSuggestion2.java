package com.qsp.testscripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class AutoSuggestion2 {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		driver.manage().deleteAllCookies();
		WebElement adrs = driver.findElement(By.xpath("(//input[@title='Any worldwide city or airport'])[1]"));
		adrs.sendKeys("Ban");
		List<WebElement> allsuggestions = driver.findElements(By.xpath("//li[@class='list']"));
		System.out.println(allsuggestions.size());
		for(int i=0;i<allsuggestions.size();i++) {
			String text=allsuggestions.get(i).getText();
			System.out.println(text);
		}
		driver.findElement(By.xpath("(//li[@class='list'])[1]")).click();
		driver.close();
		
	}

}

package com.qsp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlignmentInSpicejet {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		int  departy= driver.findElement(By.id("ctl00_mainContent_view_date1")).getLocation().y;
		int returny = driver.findElement(By.id("ctl00_mainContent_view_date2")).getLocation().y;
		if(departy==returny)
			System.out.println("Yes,aligned properly");
		else
			System.out.println("No, are not aligned properly");
		System.out.println(departy);
		System.out.println(returny);
		driver.close();
		
		
		
	}

}

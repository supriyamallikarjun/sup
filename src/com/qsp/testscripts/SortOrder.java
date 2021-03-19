package com.qsp.testscripts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SortOrder {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) {
		WebDriver driver =new ChromeDriver();
		ArrayList<String> al=new ArrayList<String>();
		driver.get("file:///C:/Users/91854/Desktop/Hotel.html");
		WebElement adress = driver.findElement(By.id("mtr"));
		Select sel=new Select(adress);
		List<WebElement> allOptions = sel.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			String text = allOptions.get(i).getText();
			al.add(text);
		}
		for (int i = 0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
	
	}

}

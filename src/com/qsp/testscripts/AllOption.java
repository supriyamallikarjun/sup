package com.qsp.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AllOption {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/91854/Desktop/Hotel.html");
		WebElement adr = driver.findElement(By.id("SLV"));
		Select sel = new Select(adr);
		List<WebElement> options = sel.getAllSelectedOptions();
		for (int i = 0; i < options.size(); i++) {
			String text = options.get(i).getText();
			System.out.println(text);
		}
		System.out.println(" ");
		System.out.println(sel.getWrappedElement().getText());
		System.out.println(" ");
		for (int i = options.size()-1; i >=0 ; i--) {
			String text = options.get(i).getText();
			System.out.println(text);
		}
		driver.close();
	}

}

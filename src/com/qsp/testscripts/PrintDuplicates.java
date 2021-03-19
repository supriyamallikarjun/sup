//WAS to print all the duplicates in mtr list box.  

package com.qsp.testscripts;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintDuplicates {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		HashSet<String> hs=new HashSet<String>();
		driver.get("file:///C:/Users/91854/Desktop/Hotel.html");
		WebElement adress = driver.findElement(By.id("mtr"));
		Select sel = new Select(adress);
		List<WebElement> allOptions = sel.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			String text = allOptions.get(i).getText();
			if(hs.add(text)==false)
			System.out.println(text);	
		}
		
		driver.close();
	}

}

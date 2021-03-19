package com.qsp.testscripts;


import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PresenceOfInput {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the value to search");
		String option=sc.nextLine();
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/91854/Desktop/Hotel.html");
		 WebElement mtrlistbox = driver.findElement(By.id("mtr"));
		 Select s=new Select(mtrlistbox);
		 List<WebElement> adrs = s.getOptions();
		 for(int i=0;i<adrs.size();i++) {
			 String text = adrs.get(i).getText();
				 if(option.equalsIgnoreCase(text)) 
				 {
					 System.out.println(option+" available in index "+(i+1));
					 
				 }
				
		 }
		
		 driver.close();
		 sc.close();
		
	}

}

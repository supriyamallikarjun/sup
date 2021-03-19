package com.qsp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyLogo {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args)
	{
		WebDriver wd=new ChromeDriver();
		wd.get("https://www.facebook.com/");
		String tagname = wd.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img")).getTagName();
		if(tagname.equals("img"))
			System.out.println("Tag name of the logo is - "+tagname);
		else
			System.out.println("tagname is not matching");
		wd.close();
			
	}

}

package com.qsp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatersDemo {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Synonyms of task");
		driver.findElement(By.xpath("//*[@class=\"FPdoLc tfB0Bf\"]/center/input[1]")).click();
		driver.navigate().to("https://www.collinsdictionary.com/dictionary/english-thesaurus/task");
		driver.navigate().back();
		driver.navigate().back();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("whatsapp web");
		driver.navigate().to("https://web.whatsapp.com/");
		driver.quit();
	}

}

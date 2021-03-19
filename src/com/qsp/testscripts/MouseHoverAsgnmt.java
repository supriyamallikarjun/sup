package com.qsp.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAsgnmt {

	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.vtiger.com/");
		WebElement adress = driver.findElement(By.id("navbarDocumentation"));
		Actions act=new Actions(driver);
		act.moveToElement(adress).perform();
		driver.findElement(By.partialLinkText("Customers")).click();
		WebElement doubleClick = driver.findElement(By.partialLinkText("READ FULL STORY"));
		act.doubleClick(doubleClick).perform();
		boolean res = driver.findElement(By.xpath("//img[@class='img-fluid']")).isDisplayed();
		if(res)
			System.out.println("Pgae displayed");
		else
			System.out.println("Pgae displayed");
		driver.close();
	}

}

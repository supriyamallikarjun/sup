package com.qsp.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CareInsurance2 {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.careinsurance.com/rhicl/proposalcp/renew/index-care");
		Thread.sleep(1000);
		driver.findElement(By.id("policynumber")).sendKeys("123");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='text' and@id='dob']")).sendKeys("03/08/1992");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//tbody/tr[2]/td[2]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("alternative_number")).sendKeys("8549820320");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='submit-login']")).click();
		boolean res = driver.findElement(By.id("policynumberError")).isDisplayed();
		if(res)
			System.out.println("Yes,Error is displayed");
		else
			System.out.println("No,Error is not displayed");
		driver.close();
		}

}

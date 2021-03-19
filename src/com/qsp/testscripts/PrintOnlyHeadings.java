package com.qsp.testscripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrintOnlyHeadings
{
	static 
	{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//*[@id=\"loginButton\"]/div")).click();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//div[@class='menu_icon'])[4]")).click();
		driver.findElement(By.linkText("About your actiTIME")).click();
		driver.findElement(By.xpath("//a[text()='Read Service Agreement']")).click();
		Set<String> allwnd = driver.getWindowHandles();
		Iterator<String> awds = allwnd.iterator();
		String pw = awds.next();
		String cw = awds.next();
		WebDriver childw = driver.switchTo().window(cw);
		List<WebElement> list=childw.findElements(By.xpath("//h2/u"));
		System.out.println("There are "+list.size()+" headings present in the page ");
				System.out.println();
				for (int i = 0; i < list.size(); i++) {
					String text = list.get(i).getText();
					System.out.println(text);
				}
				childw.close();
		WebDriver parentw = driver.switchTo().window(pw);
		parentw.close();	
	}
}



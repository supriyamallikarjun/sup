package com.qsp.testscripts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Snapdeal {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.snapdeal.com/");
		driver.findElement(By.xpath("//input[@placeholder='Search products & brands']")).sendKeys("watch");
		driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-search-under-catagory lfloat']")).click();
		driver.findElement(By.xpath("(//a[@href=\"https://www.snapdeal.com/product/ddicon-army-silicon-digital-mens/651513147577#bcrumbSearch:watch\"])[1]")).click();
		Set<String> w = driver.getWindowHandles();
		Iterator<String> it=w.iterator();
		String pw = it.next();
		String cw = it.next();
		WebDriver currentwindow = driver.switchTo().window(cw);
		currentwindow.findElement(By.xpath("//span[text()='add to cart']")).click();
}

}

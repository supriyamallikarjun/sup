package com.qsp.testscripts;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/mnjuser/profile?id=&orgn=homepage");
	Thread.sleep(2000);
		driver.findElement(By.id("usernameField")).sendKeys("managoolisupriya@gmail.com");
		driver.findElement(By.id("passwordField")).sendKeys("123456789");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		File file = new File("./data/Resume.docx");
		String absolutePath = file.getAbsolutePath();
		driver.findElement(By.xpath("//input[@type='file'and @id='attachCV']")).sendKeys(absolutePath);
		driver.close();

	}

}

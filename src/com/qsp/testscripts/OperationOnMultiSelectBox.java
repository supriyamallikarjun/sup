package com.qsp.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class OperationOnMultiSelectBox {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("file:///C:/Users/91854/Desktop/Hotel.html");
		WebElement box = driver.findElement(By.id("mtr"));
		Select sel=new Select(box);
		sel.selectByValue("D");
		List<WebElement> text = sel.getOptions();
		for (WebElement options : text) {
			System.out.println(options.getText());
		}
		Select sel2=new Select(driver.findElement(By.id("SLV")));
		sel2.deselectByVisibleText("ButterPaneer");
		System.out.println(sel2.getFirstSelectedOption().getText());
	}

}

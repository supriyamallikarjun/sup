package com.qsp.testscripts;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;

	public class LogoDisplay {
		static {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		}
		public static void main(String[] args)
		{
			WebDriver wd=new ChromeDriver();
			wd.get("https://www.facebook.com/");
			boolean logo = wd.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img")).isDisplayed();
			if(logo)
				System.out.println("Logo displayed");
			else
				System.out.println("Logo is not display");
			wd.close();
				
		}

	}



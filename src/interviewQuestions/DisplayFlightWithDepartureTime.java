package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisplayFlightWithDepartureTime {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		driver.manage().deleteAllCookies();
		driver.findElement(By.xpath("(//input[@title='Any worldwide city or airport'])[1]")).sendKeys("Ban");
		driver.findElement(By.id("ui-id-4")).click();
		driver.findElement(By.xpath("(//input[@title='Any worldwide city or airport'])[2]")).sendKeys("Goa");
		driver.findElement(By.id("ui-id-14")).click();
		driver.findElement(By.name("depart_date")).click();
		driver.findElement(By.xpath("//span[text()='June']")).click();
		driver.findElement(By.xpath("(//span[@class='ui-datepicker-year'])[2]")).click();
		driver.findElement(By.className("ui-state-default ui-state-active ")).click();
		driver.findElement(By.xpath("//input[@value='Search flights']")).click();
		
		
		
	}

}

package interviewQuestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductsWithPrice {
static {
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.name("q")).sendKeys("i phone 11");
		driver.findElement(By.name("q")).submit();
		List<WebElement> Mnames = driver.findElements(By.xpath("//div[@class=\"_4rR01T\"]"));
		List<WebElement> Mprice=driver.findElements(By.xpath("//div[@class='_4rR01T']/../../div[2]//div[@class='_30jeq3 _1_WHN1']"));
		for (int i = 0; i < Mnames.size(); i++) {
			String nametext = Mnames.get(i).getText();
			String pricetext= Mprice.get(i).getText();
			System.out.print(nametext+"----->"+pricetext);
			System.out.println();
		}
		driver.close();
	
		
		
		
		
	}

}

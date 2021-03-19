package interviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectLastAutosggestionOfQspiders {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.switchTo().activeElement().sendKeys("Qspiders");
		Thread.sleep(3000);
		List<WebElement> suggestions = driver.findElements(By.xpath("//ul/li/div[1]/div[2]/div[1]/span"));
		int count = suggestions.size();
		for (int i = 0; i < count; i++) {
			String text = suggestions.get(i).getText();
			System.out.println(text);
			WebElement sel = null;
			if(i==count-1) {
				sel=suggestions.get(i);
				sel.click();
			}
		}
	
	}

}

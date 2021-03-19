package interviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksPresentInWiprojobsSearchPage {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.navigate().to("https://www.google.com/search?q=wipro+jobs&rlz=1C1ZKTG_enIN929IN929&oq=wiprjobs&aqs=chrome.1.69i57j0i13l3j0i13i457j0i13l5.7436j0j7&sourceid=chrome&ie=UTF-8");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		int count=allLinks.size();
		System.out.println(count+" ");
		for (int i = 0; i < allLinks.size(); i++) {
			String texts = allLinks.get(i).getText();
			System.out.println(texts);
		}
	}

}

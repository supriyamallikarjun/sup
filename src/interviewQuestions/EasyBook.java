package interviewQuestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class EasyBook {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}

	
	public static void main(String[] args) throws Exception {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");		
		WebDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.easybook.com/bus");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtSearchOrigin_Bus")).sendKeys("cameron");
		driver.findElement(By.xpath("(//strong[@class='tt-highlight'])[1]")).click();
		driver.findElement(By.id("txtSearchDestination_Bus")).sendKeys("Kuala");
		driver.findElement(By.xpath("(//strong[@class='tt-highlight'])[4]")).click();
		driver.findElement(By.id("dpDepartureDate_Bus")).click();
		driver.findElement(By.xpath("(//thead/tr[2]/th[2])[1]")).click();
		driver.findElement(By.xpath("((//td[@colspan=\"7\"])//span[3])[1]")).click();
		driver.findElement(By.xpath("//table[@class=' table-condensed']//tbody/tr[3]//td[7]")).click();
		driver.findElement(By.xpath("//button[text()='Search for Bus']")).submit();
		List<WebElement> buses = driver.findElements(By.xpath("//div[@id='dep-trip-tbl']/div[not(@class='col-sm-12 no-record-after-filter hide')]/div[1]/div[5]/a"));
		WebElement small=null;
		for(int i=0;i<buses.size();i++) {
			WebElement list = buses.get(i);
			String firstele = buses.get(0).getAttribute("data-priceadult");
			int rs = firstele.compareTo(list.getAttribute("data-priceadult"));
				small = buses.get(0);
			if(rs>=0) {
				small=list;
			}
		}
		small.click();
		List<WebElement> seats = driver.findElements(By.xpath("//a[@class='seat  ']"));
		if(seats.size()>=6) {
			for (int i = 0; i < 6; i++) {
				Thread.sleep(200);
				WebElement seat = seats.get(i);
				seat.click();
			}
		}
		else {
			Thread.sleep(200);
			for (int i = 0; i < seats.size(); i++) {
				WebElement seat = seats.get(i);
				seat.click();
			}
		}
		driver.findElement(By.id("btnProceedToPassengerDetail")).click();
		driver.switchTo().alert().dismiss();
		WebElement adress = driver.findElement(By.xpath("//select[@data-val-required='Please select your salutation.']"));
		Select sel=new Select(adress);
		sel.selectByVisibleText("Ms");
		driver.findElement(By.id("TicketCollector_Name")).sendKeys("Supriya Managooli");
		driver.findElement(By.id("TicketCollector_Email")).sendKeys("managoolisupriya@gmail.com");
		driver.findElement(By.id("TicketCollector_RepeatedEmail")).sendKeys("managoolisupriya@gmail.com");
		driver.findElement(By.xpath("(//div[@class='iti-arrow'])[1]")).click();
		driver.findElement(By.xpath("(//span[@class='country-name' and text()='India (भारत)'])[1]")).click();
		driver.findElement(By.id("country-dialcode")).sendKeys("8549820320");
		WebElement adress2 = driver.findElement(By.id("TicketCollector_Nationality"));
		Select sel2=new Select(adress2);
		sel2.selectByValue("89");
		driver.findElement(By.id("cbInsuranceLonpacNo")).click();
		driver.findElement(By.id("payNowBtn")).click();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().dismiss();
		driver.close();
	}

}

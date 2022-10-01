package SpicjetDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SpicejetDemo_One {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions c = new ChromeOptions();
		c.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(c);
		driver.get("https://www.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//input[@autocomplete='on'])[1]")).sendKeys("DEL");
		driver.findElement(By.xpath("(//input[@autocomplete='on'])[2]")).sendKeys("CCU");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@data-testid,'undefined-month-February-2022')]/descendant::div[text()='20']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		
		//driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
		

	}
 
}

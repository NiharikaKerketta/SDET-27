package SpicjetDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Sd {

	public void demo() throws Throwable {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']/descendant::div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/input")).sendKeys("AMD");
		driver.findElement(By.xpath("//div[@data-testid='to-testID-destination']/descendant::div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']/input")).sendKeys("BLR");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(@data-testid,'undefined-month-February-2022')]/descendant::div[text()='20']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();
	}

}


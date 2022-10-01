package SpicjetDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bag {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.clinique.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//div[@class='header-gnav-cart__icon-wrapper']")).click();
		//driver.findElement(By.xpath("//a[@aria-label='bag icon']")).click();
		driver.findElement(By.xpath("//button[@aria-haspopup='true']//*[name()='svg' and @class='svgicon svgicon--arrow-8 hide_auth']")).click();
		Thread.sleep(2000);
		driver.close();

	}

}

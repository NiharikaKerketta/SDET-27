package practiceXpath;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Redmi {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.name("q")).sendKeys("redmi");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		//String title = driver.getTitle();
		//System.out.println(title);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebElement msg = driver.findElement(By.xpath("//span[@class='_10Ermr']"));
		
		System.out.println(msg);
		
		driver.close();

	}

}

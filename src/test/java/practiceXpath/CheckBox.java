package practiceXpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://in.search.yahoo.com/?fr2=inr");
		driver.findElement(By.xpath("//div[@title='Sign In']")).click();
		driver.findElement(By.xpath("//label[@for='persistent']")).click();
		boolean ans =driver.findElement(By.xpath("//label[@for='persistent']")).isSelected();
		System.out.println(ans);
		driver.close();
	}

}

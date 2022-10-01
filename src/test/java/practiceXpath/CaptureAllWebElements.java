package practiceXpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureAllWebElements {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		List<WebElement> ele = driver.findElements(By.xpath("//*"));
		int count = 0;
		for ( WebElement e : ele ) {
            System.out.println( e.getTagName()+"    "+e.getText());

            count++;

           }
         System.out.println(count );
	}

}

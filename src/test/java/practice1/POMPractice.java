package practice1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class POMPractice  {

	public static void main(String[] args) throws Throwable {
		
		FileUtility fLib = new FileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		
		String URL = fLib.getPropertyKeyValue("url");
		String USERNAME = fLib.getPropertyKeyValue("username");
		String PASSWORD = fLib.getPropertyKeyValue("password");
		String BROWSER = fLib.getPropertyKeyValue("browser");

		WebDriver driver;
		if(BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();	
		} else if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		wLib.waitForPageToLoad(driver);
		driver.get(URL);
		
		LoginPage log = new LoginPage(driver);
		log.login(USERNAME, PASSWORD);
		
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganisationLink();
		
	}

}

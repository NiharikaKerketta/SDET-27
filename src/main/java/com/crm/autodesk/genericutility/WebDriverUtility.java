package com.crm.autodesk.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author Niharika
 *
 */
public class WebDriverUtility {
		/**
		 * wait for page to load before synchronizing element in [HTML-Document]
		 * @param driver
		 */
		public void waitForPageToLoad(WebDriver driver) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
		/**
		 * maximize the window
		 * 
		 */
		public void maximizeWindow(WebDriver driver) {
			driver.manage().window().maximize();
		}
		
		/**
		 * wait for page to load before identifying any assychronized[java script actions] element element in DOM
		 * @param driver
		 */
		public void waitForPageToLoadForJSElement(WebDriver driver) {
			driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		}
		
		/**
		 * used to wait for the element to be clickable in GUI & check for specific element for every 500 miliseconds
		 * @param driver
		 * @param element
		 * 
		 */
		public void waitForTheElementToBeClickAble(WebDriver driver, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		/**
		 * use to switch to any window based on window title
		 * @param driver
		 * @param partialWindowTitle
		 */
		public void switchToWindow(WebDriver driver, String partialWindowTitle) {
			Set<String> set = driver.getWindowHandles();
			Iterator<String> it = set.iterator();
			
			while(it.hasNext()) {
				String wId = it.next();
				driver.switchTo().window(wId);
				String currentWindowTitle = driver.getTitle();
				if(currentWindowTitle.contains(partialWindowTitle)) {
					break;
				}
			}
		}
		/**
		 * used to switch to alert window & click on OK button
		 * @param driver
		 */
		public void switchToAlertWindowAndAccept(WebDriver driver) {
			driver.switchTo().alert().accept();
		}
		
		/**
		 * used to switch to alert window & click on Cancel button
		 * @param driver
		 */
		public void switchToAlertWindowAndCancel(WebDriver driver) {
			driver.switchTo().alert().dismiss();
		}
		
		/**
		 * used to switch to Frame Window based on index
		 * @param driver
		 * @param index
		 */
		public void switchToFrame(WebDriver driver, int index) {
			driver.switchTo().frame(index);
		}
		
		/**
		 * used to switch to Frame Window based on id or name attribute
		 * @param driver
		 * @param id_name_attribute
		 */
		public void switchToFrame(WebDriver driver, String id_name_attribute) {
			driver.switchTo().frame(id_name_attribute);
		}
		
		/**
		 * used to select the value from the dropdown based on index
		 * @param element
		 * @param value
		 */
		public void select(WebElement element, int index) {
			Select sel = new Select(element);
			sel.selectByIndex(index);
		}
		
		/**
		 * used to select the value from the dropdown based on the value/option available in GUI
		 * @param element
		 * @param text
		 */
		public void selectByVisibleText( WebElement element, String text) {
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
		}
		
		/**
		 * used to place the mouse cursor on specific element
		 * @param driver
		 * @param element
		 */
		public void mouseOverOnElement(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.moveToElement(element).perform();
		}
		
		/**
		 * used to right click on specific element
		 * @param driver
		 * @param element
		 */
		public void rightClickOnElement(WebDriver driver, WebElement element) {
			Actions act = new Actions(driver);
			act.contextClick(element).perform();
		}
		
		/**
		 * 
		 * @param driver
		 * @param javaScript
		 */
		public void executeJavaScript(WebDriver driver, String javaScript) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeAsyncScript(javaScript, null);
		}
		
		/**
		 * 
		 * @param element
		 * @throws InterruptedException
		 */
		 public void waitAndClick(WebElement element) throws InterruptedException {
			 int count = 0;
			 while(count<20) {
				 try {
					 element.click();
					 break;
				 } catch(Throwable e) {
					 Thread.sleep(1000); 
					 count++;
				 }
			 }
		 }
		
		public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshot/"+screenshotName+".PNG");
			Files.copy(src, dest);
		}
		
		/**
		 * pass enter key appeared in the browser
		 * @param driver
		 * 
		 */
		public void passEnterKey(WebDriver driver) {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).perform();
		}
}
		
		
		
		


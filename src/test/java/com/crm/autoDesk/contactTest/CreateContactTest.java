package com.crm.autoDesk.contactTest;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
public class CreateContactTest extends BaseClass{

	@Test(groups = "smokeSuite")
	public void CreateContactTest() throws Throwable {
		
				//get RanDom number
				int ranDomNo = jLib.getRanDomNumber();				
				
				//read Test data from excel sheet
				String lastName = eLib.getDataFromExcel("Sheet2", 1, 2) + ranDomNo;
			
				//navigate to contacts module
				HomePage hp = new HomePage(driver);
				hp.clickOnContactsLnk();
				
				//click on contact button
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactImg();
				
				//enter all the details and create a new contact
				CreateContactPage ccp = new CreateContactPage(driver);
				ccp.CreateContact(lastName);
				
				//verify the contact name in the header of the message
				ContactInfoPage cip = new ContactInfoPage(driver);
				String actMsg = cip.getContactInfo();
				boolean expResult = true;
				boolean actResult = actMsg.contains(lastName);
				Assert.assertEquals(expResult, actResult);
				Reporter.log("contact created succesfully",true);
			}

}

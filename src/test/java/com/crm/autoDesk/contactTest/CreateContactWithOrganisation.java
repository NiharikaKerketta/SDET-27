package com.crm.autoDesk.contactTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
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
public class CreateContactWithOrganisation extends BaseClass {

	@Test
	public void CreateContactWithOrganisationTest() throws Throwable {
		
		//get RanDom number
		int ranDomNo = jLib.getRanDomNumber();
					
		//read Test data from excel sheet
		String orgName = eLib.getDataFromExcel("Sheet1", 3, 2) + ranDomNo;
		String lastName = eLib.getDataFromExcel("Sheet2", 3, 2) + ranDomNo;
		
		//navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganisationLink();
				
		//click on create Organization" button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrg();
				
		//enter all the details and create new organization
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrgAndSave(orgName);
			
		//wait for element to be active
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actMsg = oip.getOrgInfo();
		
		Assert.assertTrue(actMsg.contains(orgName));
		Reporter.log("org created", true);
		
				//navigate to contacts module
				HomePage hp1 = new HomePage(driver);
				hp1.clickOnContactsLnk();
				
				//click on contact button
				ContactsPage cp = new ContactsPage(driver);
				cp.clickOnCreateContactImg();
				
				//switch the window
			CreateContactPage ccp1 = new CreateContactPage(driver);
			ccp1.CreateContactWithOrg(driver, lastName, orgName);
		
			//driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			
			//verify the contact name in the header of the message
			ContactInfoPage cip = new ContactInfoPage(driver);
			String actMsg1 = cip.getContactInfo();
			
			Assert.assertTrue(actMsg1.contains(lastName));
			Reporter.log("contact created", true);
			
		}			
	}

	
				

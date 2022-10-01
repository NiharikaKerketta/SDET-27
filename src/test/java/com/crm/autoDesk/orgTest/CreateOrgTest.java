package com.crm.autoDesk.orgTest;

import java.io.FileInputStream;
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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
public class CreateOrgTest extends BaseClass {

	@Test(groups = "smokeSuite")
	public void createOrgTest() throws Throwable
	{		
		//get RanDom number
		int ranDomNo = jLib.getRanDomNumber();
		
		//read Test data from excel sheet
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + ranDomNo;
		
		//navigate to organisation module
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganisationLink();
		
		//click on create Organisation" button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		
		//enter all the details and create new organisation
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrgAndSave(orgName);
		
		//verify organisation name in header of the msg
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actMsg = oip.getOrgInfo();
		
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(actMsg.contains(orgName));
		Reporter.log("organisation created", true);
		sa.assertAll();
		
	}
}



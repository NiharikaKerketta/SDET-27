package com.crm.autoDesk.orgTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.support.ui.Select;
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
public class CreateOrgWithIndustries_Type extends BaseClass {

	@Test
	public void CreateOrgWithIndustries_TypeTest() throws Throwable {
		
				//get RanDom number
				int ranDomNo = jLib.getRanDomNumber();
				
				//read Test data from excel sheet
				String orgName = eLib.getDataFromExcel("Sheet1", 3, 2) + ranDomNo;
				String industry = eLib.getDataFromExcel("Sheet1", 1, 3);
				String type= eLib.getDataFromExcel("Sheet1", 1, 4);
				
				//navigate to organisation module
				HomePage hp = new HomePage(driver);
				hp.clickOnOrganisationLink();
				
				//click on create Organisation" button
				OrganizationsPage op = new OrganizationsPage(driver);
				op.clickOnCreateOrg();
				
				//create organization with industry and type
				CreateOrganizationPage cop = new CreateOrganizationPage(driver);
				cop.createOrgWithIndustryAndType(orgName, industry, type);
				
				//verify industry 
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				String actMsg = oip.getIndustryInfo();
				SoftAssert sa = new SoftAssert();
				sa.assertTrue(actMsg.contains(industry));
				Reporter.log("industry created", true);
				
				//verify type
				OrganizationInfoPage oip1 = new OrganizationInfoPage(driver);
				String actMsg1 = oip1.getTypeInfo();
				
				sa.assertTrue(actMsg1.contains(type));
				Reporter.log("Type created", true);
				sa.assertAll();
	}
}

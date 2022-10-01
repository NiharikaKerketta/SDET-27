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
public class CreateOrgWithIndustry extends BaseClass {

	@Test
	public void CreateOrgWithIndustryTest() throws Throwable {
		
		//get RanDom number
		int ranDomNo = jLib.getRanDomNumber();
		
		//read data from excel
		
		String orgName = eLib.getDataFromExcel("Sheet1", 3, 2) + ranDomNo;
		String industry = eLib.getDataFromExcel("Sheet1", 1, 3);
		
		//navigate to organization
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganisationLink();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrg();
	
		//create organization with industry
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrgWithIndustry(orgName, industry);
		
		//verify industry 
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actMsg = oip.getIndustryInfo();
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(actMsg.contains(industry));
		Reporter.log("industry created", true);
		sa.assertAll();
	}

}

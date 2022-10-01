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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.CreateOrganizationPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverUtility;

public class CheckWhileCreatingNewOrgTypeDropDownIsWorkingOrNot extends BaseClass {

	@Test(groups = "RegressionSuite")
	public void checkWhileCreatingNewOrgTypeDropDownIsWorkingOrNotTest() throws Throwable {

		//get RanDom number
		int ranDomNo = jLib.getRanDomNumber();
		
		//read data from excel
		String orgName = eLib.getDataFromExcel("Sheet1", 1, 2) + ranDomNo;
		
		//navigate to organization
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganisationLink();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg(orgName);
				
		//checking the DropDown
		CreateOrganizationPage cop1 = new CreateOrganizationPage(driver);
		cop1.checkTypeDropDown();
			
	}

}

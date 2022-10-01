package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class HomePage extends WebDriverUtility { //Step1: create a seperate class for homepage
	
	//step2 : Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	//initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Step 4 Utilization

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	//Bussiness library to click on organization
	public void clickOnOrganisationLink() {
		organizationLnk.click();
	}
	//Bussiness library to click on organization
	public void clickOnContactsLnk() {
		contactsLnk.click();
	}
	
	//Bussiness library for logout
	public void logout(WebDriver driver) {
		mouseOverOnElement(driver, administratorImg);
		signOutLnk.click();
	}
	
	
	
}

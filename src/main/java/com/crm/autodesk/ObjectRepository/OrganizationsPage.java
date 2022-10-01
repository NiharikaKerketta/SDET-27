package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage { //Step1 create a seperate class for organization page
	
	//Step 2:identify all elements and declare them as private
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement createOrgLookupImg;
	
	@FindBy(name = "search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name = "submit")
	private WebElement searchNowBtn;
	
	//Step3 initialization
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateOrgLookupImg() {
		return createOrgLookupImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
	//Bussiness Library
	public void clickOnCreateOrg()
	{
		createOrgLookupImg.click();
	}
	
}

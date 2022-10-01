package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateOrganizationPage extends WebDriverUtility { //Step1 create a seperate class for organization page 
	
	//Step 2:identify all elements and declare them as private 
	@FindBy(name = "accountname")
	private WebElement organizationNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement acountDropDown;
	
	@FindBy(className = "small")
	private WebElement checkDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//step 3: intitialise the element using constructor
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//step 4 : Utilization provide getter methods
	
	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}

	public WebElement getCheckDropDown() {
		return checkDropDown;
	}

	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getAcountDropDown() {
		return acountDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Bussiness Library for checking the dropDown
	public String checkTypeDropDown() {
		checkDropDown.click();
		if(checkDropDown.isEnabled()) {
			System.out.println("DropDown is Working");
		} 
		else {
			System.out.println("DropDown is not Working");
		}
		return null;
	}
	
	//Bussiness Library for saving
	public void createOrg(String orgName) {
		organizationNameEdt.sendKeys(orgName);
	}
	
	//Bussiness Library for create organization and save
	public void createOrgAndSave(String orgName) {
		organizationNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	//Bussiness Library for create organization with industry dropdownand type dropdown
	public void createOrgWithIndustryAndType(String orgName, String industry, String type) {
		organizationNameEdt.sendKeys(orgName);
		selectByVisibleText( industryDropDown, industry);
		selectByVisibleText( acountDropDown, type);
		saveBtn.click();
	}
	
	//Bussiness Library for create organization with industry
	public void createOrgWithIndustry(String orgName, String industry) {
		organizationNameEdt.sendKeys(orgName);
		selectByVisibleText( industryDropDown, industry);
		saveBtn.click();
	}
	
	//Bussiness Library for create organization with type
	public void createOrgWithType(String orgName, String type) {
		organizationNameEdt.sendKeys(orgName);
		selectByVisibleText( acountDropDown, type);
		saveBtn.click();
	}
	
	
	
	
}

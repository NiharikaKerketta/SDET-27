package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility {

	//declaration
	@FindBy(name = "lastname")
	private WebElement contactLastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_id']/following-sibling::img")
	private WebElement orgNameLookupImg;
	
	@FindBy(id = "search_txt")
	private WebElement searchOrgTextEdt;
	
	@FindBy(name = "search")
	private WebElement searchNowOrgBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	
	public WebElement getContactLastNameEdt() {
		return contactLastNameEdt;
	}

	public WebElement getSearchOrgTextEdt() {
		return searchOrgTextEdt;
	}

	public WebElement getSearchNowOrgBtn() {
		return searchNowOrgBtn;
	}

	public WebElement getOrgNameLookupImg() {
		return orgNameLookupImg;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//bussiness libraries for last name
	public void CreateContact(String lastName)
	{
		contactLastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}
	//
	public void CreateContactWithoutSave(String lastName)
	{
		contactLastNameEdt.sendKeys(lastName);
	}
	
	public void CreateContactWithOrg(WebDriver driver, String lastName,String orgName)
	{
		contactLastNameEdt.sendKeys(lastName);
		orgNameLookupImg.click();
		switchToWindow(driver, "Accounts");
		searchOrgTextEdt.sendKeys(orgName);
		searchNowOrgBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		saveBtn.click();
	}
	//create contact with organisation
	/*public void CreateContactWithOrg(WebDriver driver, String lastName,String orgName)
	{
		contactLastNameEdt.sendKeys(lastName);
		orgNameLookupImg.click();
		switchToWindow(driver, "Accounts");
		searchOrgTextEdt.sendKeys(orgName);
		searchNowOrgBtn.click();
		
	}
	
	public void CreateContactWithOrg1(WebDriver driver, String lastName,String orgName)
	{
		
	switchToWindow(driver, "Contacts");
	saveBtn.click();*/

}

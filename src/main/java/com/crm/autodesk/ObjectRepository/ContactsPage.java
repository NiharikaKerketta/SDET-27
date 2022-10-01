package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement contactLookupImg;
	
	@FindBy(name = "search_text")
	private WebElement searchContTextEdit;
	
	@FindBy(name = "submit")
	private WebElement searchContNowButton;
	
	//Step3 initialization
		public ContactsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//utilization
		public WebElement getContactLookupImg() {
			return contactLookupImg;
		}

		public WebElement getSearchContTextEdit() {
			return searchContTextEdit;
		}

		public WebElement getSearchContNowButton() {
			return searchContNowButton;
		}
		
		//bussiness Libraray
		public void clickOnCreateContactImg()
		{
			contactLookupImg.click();
		}
		
		public void getSearchTextEdt()
		{
			searchContTextEdit.click();
		}
		
		public void getSearchNowBtn()
		{
			searchContNowButton.click();
		}
		
}

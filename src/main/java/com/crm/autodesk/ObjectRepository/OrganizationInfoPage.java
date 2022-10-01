package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
		
		@FindBy(xpath = "//span[@class='dvHeaderText']")
		private WebElement orgHeaderText;
		
		@FindBy(id = "dtlview_Industry")
		private WebElement industryText;
		
		@FindBy(id = "dtlview_Type")
		private WebElement typeText;
		
		public OrganizationInfoPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getTypeText() {
			return typeText;
		}


		public WebElement getIndustryText() {
			return industryText;
		}
		
		public WebElement getOrgHeaderText() {
			return orgHeaderText;
		}
			
		//bussiness library for org text
		public String getOrgInfo() {
			return (orgHeaderText.getText());
		}
		
		//bussiness library for industry text
		public String getIndustryInfo() {
			return (industryText.getText());
		}
		
		//bussiness library for type text
		public String getTypeInfo() {
			return (typeText.getText());
		}
}

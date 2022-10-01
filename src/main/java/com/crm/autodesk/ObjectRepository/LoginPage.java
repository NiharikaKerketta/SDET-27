package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {	//step 1:Create a seperate class for webpage
	
	//Step 2:identify all elements and declare them as private
	@FindBy(name = "user_name")
	private WebElement userNameEdt;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	
	//step 3: intitialise the element using constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//step 4 : Utilization provide getter methods
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
		
	//Bussiness Library
	public void login(String usename, String password) {
		userNameEdt.sendKeys(usename);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
}

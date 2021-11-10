package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class LogInPage extends TestBase {
	
	//add the locators here i.e WebElements
	@FindBy(id ="signin_button")
	WebElement signInButton;
	@FindBy(id ="user-login")
	WebElement userName;
	@FindBy(id ="user-password")
	WebElement userPassword;
	@FindBy(id ="user-login")
	WebElement username;
	@FindBy(linkText= "Forgot your Password")
	WebElement forgotpassword;
	@FindBy(name="submit")
	WebElement submitbutton;
	@FindBy(id="details-button")
	WebElement detailsbutton;
	@FindBy(linkText="Proceed to zero.webappsecurity.com (unsafe)")
	WebElement proceedtolink;
	@FindBy(linkText = "Zero Bank")
	WebElement brandLogo;
	


	
	// initialize the Page Objects:]
	public LogInPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	// verify the page title..all properties can be set in the config file.
	public void assertLogInPageTitle() {
		assertEquals(driver.getTitle(), prop.getProperty("loginPageTitle"));
	}

	
	
	public AccountSummaryPage logIn() {
		signInButton.click();
		userName.sendKeys(prop.getProperty("username"));
		userPassword.sendKeys(prop.getProperty("password"));
		submitbutton.click();
		//detailsbutton.click(); //this will allow the security feature bypass
		//proceedtolink.click();	
		return new AccountSummaryPage();
	}
	
	
	
	public Boolean validateBrandLogo() {
		return brandLogo.isDisplayed();
		
	};
	
	
}

package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class LandingPage extends TestBase{
	
	//add the locators here i.e WebElements

	@FindBy(id = "signin_button")
	WebElement signInButton;
	@FindBy(name="searchTerm")
	WebElement searchBox;
	@FindBy(linkText = "Zero Bank")
	WebElement brandLogo;
	@FindBy(id = "online-banking")
	WebElement moreServices;
	@FindBy(linkText = "Checking Account Activity")
	WebElement checkingAccountLink;
	@FindBy(linkText = "Transfer Funds")
	WebElement transferfunds;
	
	
	//initialize the page objects;
	public LandingPage() {
		PageFactory.initElements(driver, this);
	
	}
	
	//validate the Landing Page
	public void assertHomePageTitle() {
		assertEquals(driver.getTitle(), prop.getProperty("landingPageTitle"), "HomePage Title assertiton Failed");
	}
	
	
	//validate BrandLogo
	public boolean validateBrandLogo() {
		return brandLogo.isDisplayed();
	}
	
	
	// Directs the actions to the login page
	public LogInPage loadLogInPage() {
		signInButton.click();
		return new LogInPage();
	}
	
	
	
	
	//iterate across all the links and verify
	
	

}

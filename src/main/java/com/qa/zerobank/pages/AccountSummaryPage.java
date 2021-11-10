package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class AccountSummaryPage extends TestBase {
	
	//add the locators here i.e WebElements
	@FindBy(linkText = "Zero Bank")
	WebElement brandLogo;
	@FindBy(id = "logout_link")
	WebElement logout;

	
	// Initializing the Page Objects:
	public AccountSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	// Verify the page title
	public void assertAccountSummaryPageTitle(){
		assertEquals(driver.getTitle(), prop.getProperty("summaryPageTitle"));
		
	}
	
	//validate BrandLogo
		public boolean validateBrandLogo() {
			return brandLogo.isDisplayed();
		}
		
	//validate Logout Funtionality
		public void logOutfuntionality() {
			logout.click();
			
		}
				

}

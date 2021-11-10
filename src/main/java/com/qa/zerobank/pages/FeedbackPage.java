package com.qa.zerobank.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.zerobank.base.TestBase;

public class FeedbackPage extends TestBase {
	
	//add the locators here i.e webElements (this data can eventually be collected in a data file
	@FindBy()
	WebElement acctLink;  // locate all then links on the page// will be used to list them out
	
	//Initialize the page Objects
	public FeedbackPage() {
		PageFactory.initElements(driver, this);
	}
	
	//verify the Page Title and return True/False
	public void AssertPageTitle() {
		assertEquals(driver.getTitle(), prop.getProperty("feedbackpageTitle"));	
	}

}

package com.qa.zerobank.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.zerobank.base.TestBase;
import com.qa.zerobank.pages.AccountSummaryPage;
import com.qa.zerobank.pages.FeedbackPage;
import com.qa.zerobank.pages.LandingPage;
import com.qa.zerobank.pages.LogInPage;
import com.qa.zerobank.util.TestUtil;

public class LoginPageTestCase extends TestBase {
	
	// initialize the objects	
	LogInPage logInPage;
	LandingPage landingPage;
	FeedbackPage feedbackPage;
	AccountSummaryPage acctSummaryPage;
	TestUtil testUtil;
	

	//initialize the 
	public LoginPageTestCase() {
		super();
	}
	
	
	//Activities to be performed before the Test Method execution
	@BeforeMethod
	public void setup() {
		//initialize new object classes from the base Classes 
		initialization();
		testUtil = new TestUtil();
		landingPage = new LandingPage();
		logInPage = new LogInPage();
		feedbackPage = new FeedbackPage();
		acctSummaryPage = new AccountSummaryPage();	
		landingPage.loadLogInPage();
	}
	
	// Activities to be performed after the test methods have been executed
	@AfterMethod
	public void shutdown() throws IOException {	
		testUtil.takeScreenshot();	
		driver.close();
		driver.quit();	
	}
	
	//Test Activities to be performed
	@Test
	public void validateLogInPage() {
		logInPage.assertLogInPageTitle();  //validate Title
	}
	
	
	//Test Activities to be performed
	@Test
	public void validateBrandLogo() {
		logInPage.validateBrandLogo();   //validate Brandlogo
	}
		
		
		
	// Collect and Test All the Links in the Page
	@Test
	public void validatePageLinks() throws Exception {
		List<WebElement> webLinks = driver.findElements(By.tagName("a")); //store all the page links in an List
		String[] linkText = new String[webLinks.size()];

		int i=0;
		
		for(WebElement w : webLinks) {
			linkText[i] = w.getText(); //collect the value of the link Text
			System.out.println(linkText[i]); //print out all the page links
			i++;	
		}
		System.out.print("\n");
		
		
		//Iterate across the links and verify: possible to use the iteration class inn java
		for (String s : linkText) {
			if (s == "<" || s==">") {
				continue;
			}else {
				driver.findElement(By.linkText(s)).click();
				System.out.println("Link: " + driver.getTitle() + ".  Url: " + driver.getCurrentUrl() + " ." );
				driver.navigate().back(); //will click the navigate back button on the webpage to return
				Thread.sleep(2000);
				assertEquals(driver.getTitle(), prop.getProperty("logInPageTitle")); //used to verification of the location by veryfying the web page title.
			}
		}
			
	}
	
	//Test the Login functionality
	public void validateLogInfuntionality() {
		logInPage = landingPage.loadLogInPage();
		acctSummaryPage = logInPage.logIn();
	}


}
		

	
	

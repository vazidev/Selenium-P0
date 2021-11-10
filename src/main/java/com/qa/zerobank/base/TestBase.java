package com.qa.zerobank.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {
	
	// This is  where we initalize our config variables
	public static WebDriver driver;
	public static Properties prop;
		
		
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\\\main\\\\java\\\\com\\\\qa\\\\zerobank\\\\config\\\\config.properties");
			prop.load(ip); // will load the file a path as indicated in the FileInputStream
			
		} catch (FileNotFoundException e) { //catch file not found exception
			e.printStackTrace();	
		} catch (IOException e) {  //catch input output exceptions 
			e.printStackTrace();	
		}catch (NullPointerException e) {   //catch if the config file is empty
			e.printStackTrace();
		} catch(IllegalArgumentException e) { // catch illegal characters in the config file
			e.printStackTrace();
		}	
	}
	
	// initializing browser driver
		public static void initialization() {
			String browserName = prop.getProperty("browser");
			String bdPath = System.getProperty("user.dir") +"\\" + prop.getProperty("webDriverFilePath");
			if(browserName.equalsIgnoreCase("chrome")){
				System.setProperty("webdriver.chrome.driver", bdPath + "chromedriver.exe");  //sets the Browser Driver to Chrome
				driver = new ChromeDriver();
				
			}else if(browserName.equalsIgnoreCase("ff")){
				System.setProperty("webdriver.gecko.driver", bdPath + "geckodriver.exe");	//sets the browser driver to firefox
				driver = new FirefoxDriver(); 
				
			}else if(browserName.equalsIgnoreCase("ie")){
	        	System.setProperty("webdriver.ie.driver", bdPath + "IEDriverServer.exe");   //sets the browser driver to Internet Explorer
	        	driver = new InternetExplorerDriver();
	        	
	        }
			
			//set defaults for the window Browser Loading
			
			driver.manage().window().maximize(); //will maximize the browser window
			driver.manage().deleteAllCookies();  //will delete all the cookies
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));	 //get the url address
			
		}
	
	
	

}

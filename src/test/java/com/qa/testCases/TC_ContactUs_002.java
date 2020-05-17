package com.qa.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.Base.BaseClass;
import com.qa.PageObjects.ContactUs;


public class TC_ContactUs_002 extends BaseClass{

	WebDriver driver;
	
	@BeforeClass
	@Parameters("browser")	
	public void initializeBrowser(String brwsr) {
		driver = setup(brwsr);
	}
	
	@Test
	public void launchContactUsPage() {	
		long id = Thread.currentThread().getId();
        System.out.println("Contact us 001. Thread id is: " + id);
		driver.get(baseURL);
		System.out.println("Contact us 001. Thread id is: " + id);		
		
		ContactUs contactUs = new ContactUs(driver);
		contactUs.clickContactUs();		
		
		String pageTitle = driver.getTitle();		
		Assert.assertEquals(pageTitle, "Contact National MI, NMI Holdings Corporate Office | National MI");		
	}
	
	@AfterClass
	public void closeBrowser() {
		teardown();
	}

	
}

package com.qa.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.Base.BaseClass;
import com.qa.PageObjects.RateGPSGetQuote;

public class TC_RateGPS_001 extends BaseClass {

	WebDriver driver;
		
	@BeforeClass
	@Parameters("browser")	
	public void initializeBrowser(String brwsr) {
		driver = setup(brwsr);
	}
	
	@Test
	public void launchNMIPage() {	
		long id = Thread.currentThread().getId();
        System.out.println("Login test 001. Thread id is: " + id);
        driver.get(baseURL);
		System.out.println("Login test 001. Thread id is: " + id);
				
		RateGPSGetQuote rgps = new RateGPSGetQuote(driver);			
		
		rgps.clickRateGPSQuote();
		
		if (driver.getTitle().equals("Rate GPS")) {
			Assert.assertTrue(true);			
		}else {
			Assert.assertTrue(false);			
		}
		rgps.enterCompanyEmail(emailAddr);
		rgps.clickNext();
		//rgps.profileSetup();
		rgps.testWithOutAction(zipCode);		
	}
	
	@AfterClass
	public void closeBrowser() {
		teardown();
	}

}

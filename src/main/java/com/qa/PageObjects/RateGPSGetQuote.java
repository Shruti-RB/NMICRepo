package com.qa.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RateGPSGetQuote {

	WebDriver driver;	
	
	public RateGPSGetQuote(WebDriver rDriver){
		driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(linkText="Rate GPS Quote")
	WebElement linkRateGPSQuote;
	
	@FindBy(name="companyEmail")
	WebElement txtEmail;
	
	@FindBy(name="landing-next-button")
	WebElement btnNext;
	
	@FindBy(name="firstName")
	WebElement firstName;
	
	
	public void clickRateGPSQuote() {
		linkRateGPSQuote.click();
	}
	
	public void enterCompanyEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void clickNext() {
		btnNext.click();		
	}
	
	public void profileSetup() {
		System.out.println("Entered profile setup method");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		firstName.sendKeys("Test");		
		driver.findElement(By.id("lastName")).sendKeys("Test");
		driver.findElement(By.id("companyName")).sendKeys("TCS");
		driver.findElement(By.id("new-rate-request")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.name("confirm-profile")).click();
		driver.findElement(By.id("new-rate-request")).click();
	}
	
	public void testWithOutAction(String zipcode){		
		WebElement zipCode = driver.findElement(By.id("zipCode"));
		zipCode.sendKeys(zipcode);
				
		driver.findElement(By.xpath("//div[@id='propertyType']//i")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Manufactured Housing')]")).click();
		
		driver.findElement(By.xpath("//div[@id='occupancy']//i")).click();		
		driver.findElement(By.xpath("//a[contains(text(),'Investment')]")).click();
		
		driver.findElement(By.xpath("//div[@id='loanPurpose']//i")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Rate / Term Refinance')]")).click();
		
		driver.findElement(By.xpath("//div[@id='loanAmount']//input")).sendKeys("300000");
		
		driver.findElement(By.xpath("//div[@id='loanToValue']//i")).click();
		driver.findElement(By.xpath("//a[contains(text(),'85% and below')]")).click();
		
		driver.findElement(By.xpath("//div[@id='amortizationTerm']//i")).click();
		driver.findElement(By.xpath("//a[contains(text(),'300 months (25-year)')]")).click();
		
		driver.findElement(By.xpath("//div[@id='loanType']//i")).click();
		driver.findElement(By.xpath("//a[contains(text(),'10/1 ARM')]")).click();
		
		driver.findElement(By.xpath("//div[@id='duLpDecision']//i")).click();
		driver.findElement(By.xpath("//a[contains(text(),'DU Approve / Ineligible')]")).click();
		
		driver.findElement(By.xpath("//div[@id='loanProgram']//i")).click();
		driver.findElement(By.xpath("//a[contains(text(),'HFA Charter Coverage')]")).click();
		
		driver.findElement(By.xpath("//div[@id='debtToIncome']//input")).sendKeys("60");
		
		driver.findElement(By.xpath("//input[@id='wholesaleLoanNo']")).click();
		
		driver.findElement(By.xpath("//div[@id='coverage']//i")).click();
		driver.findElement(By.xpath("//a[contains(text(),'6')]")).click();
		
		driver.findElement(By.xpath("//div[@id='product']//i")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Lender Paid Single')]")).click();
		
		driver.findElement(By.id("borrowerCreditScore")).sendKeys("670");
		
	}
	
	
}

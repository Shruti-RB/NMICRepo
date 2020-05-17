package com.qa.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUs {
	WebDriver driver;
	
	public ContactUs(WebDriver rDriver) {
		driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(linkText = "Contact Us")
	WebElement contactUsLink;
	
	public void clickContactUs() {
		contactUsLink.click();
	}

}

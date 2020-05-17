package com.qa.Base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	WebDriver driver;
	
	public static String baseURL = "https://nationalmi.com";
	public static String emailAddr="testt@gmail.com";
	public static String zipCode="90001";
	
	public WebDriver setup(String brwser) {		
		if (brwser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");			
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("chrome window maximized");				
		}	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		long id = Thread.currentThread().getId();
        System.out.println("Base class - Before test-class. Thread id is: " + id);
        return driver;
	}
	
	
	public void teardown() {
		driver.quit();
		long id = Thread.currentThread().getId();
        System.out.println("Base class - After test-class. Thread id is: " + id);
	}
	
	public String getScreenShotPath(String methodName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile= System.getProperty("user.dir")+"\\Reports\\"+methodName+".jpg";		
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

}

package com.autouw.qa.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.autouw.qa.base.TestBase;
import com.autouw.qa.page.DealCreationpage;

public class DealCreation {
	WebDriver driver;
	DealCreationpage creation;//aggregation  
	
	@BeforeClass
	public void creation() {
		driver=TestBase.driver;
		creation=PageFactory.initElements(driver, DealCreationpage.class);
	}
	
	@Test(priority=28)
	public void next() {
		creation.next();
		
	}
	

}

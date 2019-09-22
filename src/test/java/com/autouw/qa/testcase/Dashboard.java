package com.autouw.qa.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autouw.qa.base.TestBase;
import com.autouw.qa.page.DashboardPage;


@Listeners(com.autouw.qa.util.Listener.class)
public class Dashboard {
	WebDriver driver;
	DashboardPage dashboard;

	@BeforeClass
	public void dashboard() {
		driver=TestBase.driver; 	
		dashboard=PageFactory.initElements(driver, DashboardPage.class); 	  
	}

	//Upload document button
	@Test(priority=15)
	public void TC04Dashboard() throws InterruptedException {
		Thread.sleep(3000);
		dashboard.upload_doc();
	}
}

package automation_testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import library.Dashboard_Page;
import setup_browser.Setup;

@Listeners(listener.Listener.class)
public class Dashboard {
	WebDriver driver;
	Dashboard_Page dashboard;

	@BeforeClass
	public void dashboard() {
		//driver=Setup.driver;5432
		dashboard=PageFactory.initElements(driver, Dashboard_Page.class); 	
		System.out.println("Git Test");  
		//232
	}

	//Upload document button
	@Test(priority=15)
	public void TC04Dashboard() throws InterruptedException {
		Thread.sleep(3000);
		dashboard.upload_doc();
	}
}

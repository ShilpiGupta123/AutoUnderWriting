package com.autouw.qa.base;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.autouw.qa.util.TimeOuts;


@Listeners(com.autouw.qa.util.Listener.class)
public class TestBase {
	public static WebDriver driver;
	FileInputStream input;
	Properties pro;

	@BeforeSuite
	public void Start() throws IOException {
		//Configuration with file.
		pro=new Properties();
		input=new FileInputStream("./src/main/java/com/autouw/qa/config/config.properties");
		pro.load(input);
	}

	@Test(priority=1)
	public void ConnectWithBrowser() throws InterruptedException{
		System.setProperty(pro.getProperty("Key"), pro.getProperty("Value"));
		driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		
		//Maximize the browser.
		driver.manage().window().maximize();
				
		driver.manage().timeouts().pageLoadTimeout(TimeOuts.Page_TimeOut,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOuts.Implicit_TimeOut, TimeUnit.SECONDS);
		
		//Sending URL to the browser.
		driver.get(pro.getProperty("URL"));
		
		//int a=driver.manage().window().getPosition().getX();
		//driver.manage().window().setPosition(new Point(80, 70));
		//int b=driver.manage().window().getSize().getHeight();
		//driver.manage().window().setSize(new Dimension(200, 400));

	}

	@AfterSuite()
	public void Exit() {
		//Close the browser.
		driver.quit();
	}

}
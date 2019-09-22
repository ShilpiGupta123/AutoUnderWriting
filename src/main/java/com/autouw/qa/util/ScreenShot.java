package com.autouw.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.autouw.qa.base.TestBase;


public class ScreenShot{
	WebDriver driver;
	
	public ScreenShot() {
		driver=TestBase.driver;
	}
	public void screenshort(String screenshort) {

		//Taking screenshot for fail test case.
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("./FailScreenShort/"+screenshort+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

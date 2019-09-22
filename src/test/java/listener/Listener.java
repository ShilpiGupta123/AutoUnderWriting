package listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.autouw.qa.base.TestBase;


public class Listener implements ISuiteListener, ITestListener{

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Start Suite:"+suite.getName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Start:"+result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success:"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Fail:"+result.getName());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipe:"+result.getName());

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failed But Within Success Percentage:"+result.getName());

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Context Start:"+context.getName());

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Start Suite:"+context.getName());
	}
	

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Finish Suite:"+suite.getName());

	}

	public static void CaptureShortScreenFail(String ShortScreen){
		WebDriver driver=TestBase.driver;
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("./ScreenShortsFail/"+ShortScreen+".png"));
		}

		catch (IOException e)
		{
			System.out.println(e.getMessage());

		}

	}

}

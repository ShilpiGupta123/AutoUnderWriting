package com.autouw.qa.util;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

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

		//Taking ScreenShort for Success Test Case
		ScreenShot s=new ScreenShot();
		s.screenshort(result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Fail:"+result.getName());
		
		//Taking a screenshot for Fail Test case
		ScreenShot s=new ScreenShot();
		s.screenshort(result.getName());
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

	}






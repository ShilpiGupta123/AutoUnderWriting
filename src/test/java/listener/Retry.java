package listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
	
	private int retrycount=1;
	private int maxcount=4;

	public boolean retry(ITestResult result) {
	if(result.getStatus()==ITestResult.FAILURE&&retrycount<=maxcount)
		try{
			System.out.println(String.format("Method Name : %s , Retry Count : %d", result.getName(),retrycount));
			retrycount++;
			return true;	
		}catch (Exception e) {
		}
		return false;
	}

	
}

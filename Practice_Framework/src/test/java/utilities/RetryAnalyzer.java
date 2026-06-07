package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{
	
int currentRetryCount=0;
int maxRetryCount=1;

	@Override
	public boolean retry(ITestResult result) {
	if(currentRetryCount<maxRetryCount) {
		currentRetryCount++;
		System.out.println("Tests retried: " + result.getName() + "|Attempts:" + currentRetryCount);
		return true;
	} 
	return false;
	} 
    // ✅ Add this reset method
    public void reset() {
        currentRetryCount = 0;
        System.out.println("Retry count reset");

    }
}
	

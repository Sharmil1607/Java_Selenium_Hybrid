package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer extends ReleventCodesReports implements IRetryAnalyzer{

	private int retryCount = 0;
    private static final int maxRetryCount = 1; // Set max retries

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; // Retry the test
        }
        return false; // No more retries
    }
	
}

package com.demoqa.webautomation.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.demoqa.webautomation.pagebase.TestBase;


public class Retry extends TestBase implements IRetryAnalyzer  {

    private int retryCount = 0;//number of retries     
    private static final int maxRetryCount = 2; // Retry failed test max 2 times

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
           // System.out.println("Retrying test: " + result.getName() + " | Attempt " + (retryCount + 1));
            logger.warn("Retrying test: {} | Attempt: {} of {}", 
                    result.getName(), retryCount + 1, maxRetryCount + 1);
            return true;  // Retry the test
        }
        return false;  // Stop retrying
    }
}

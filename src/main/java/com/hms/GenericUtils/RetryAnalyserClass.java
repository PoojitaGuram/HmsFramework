package com.hms.GenericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserClass implements IRetryAnalyzer {
	int count=0;
    int retrylimit=2;
	@Override
	public boolean retry(ITestResult result) {
      
      if(count<retrylimit) {
    	  count++;
    	  return true;
      }
		return false;
	}

}

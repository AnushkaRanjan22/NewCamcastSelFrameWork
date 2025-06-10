package com.camcast.crm.ListenerImp;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListenerImp implements IRetryAnalyzer {
	
	int count=0;
	int limitcount=5;

	@Override
	public boolean retry(ITestResult arg0) {
		
		if(count<limitcount)
		{
			count++;
			return true;
		}
		return false;
	}

}

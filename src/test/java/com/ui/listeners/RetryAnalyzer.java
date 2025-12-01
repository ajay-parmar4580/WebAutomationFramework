package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utilities.JSONUtility;
import com.utilities.PropertiesUtil;

public class RetryAnalyzer implements IRetryAnalyzer{
	//reading from property file
	//private static final int MAX_ATTEMPTS= Integer.parseInt(PropertiesUtil.readProperty(Env.DEV, "MAX_ATTEMPTS"));
	
	//reading from json file
	private static final int MAX_ATTEMPTS= JSONUtility.readEnvURL(Env.QA).getMAX_ATTEMPTS();
	private static int currentAttempt = 1;
	

	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt<=MAX_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		else
		{
			return false;
		}
	}

}

package com.rks.TestNGFramework_TDD.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testNGListener implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase failed is :"+Result.getName());
		
	}

	public void onTestSkipped(ITestResult Result) {
		// TODO Auto-generated method stub
		 System.out.println("The name of the testcase Skipped is :"+Result.getName());
	}

	public void onTestStart(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println(Result.getName()+" test case started");	
	}

	public void onTestSuccess(ITestResult Result) {
		// TODO Auto-generated method stub
		System.out.println("The name of the testcase passed is :"+Result.getName());
	}
	
	

}

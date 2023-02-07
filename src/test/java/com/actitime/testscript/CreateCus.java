package com.actitime.testscript;

import org.testng.annotations.Test;
import org.testng.Reporter;

public class CreateCus {
	@Test
	public void checkCus()
	{
		String browser = System.getProperty("browser");
		System.out.println("The browser name is: "+browser);
		Reporter.log(browser,true);
		Reporter.log("cus",true);	
		Reporter.log("hello world",true);
		System.out.println("good man");
		System.out.println("change done here");
	}
}

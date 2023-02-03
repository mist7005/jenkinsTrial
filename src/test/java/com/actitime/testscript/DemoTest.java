package com.actitime.testscript;

import org.testng.annotations.Test;
import org.testng.Reporter;

public class DemoTest {

	@Test
	public void demo1()
	{
		System.out.println("hello");
		Reporter.log("hello",true);	
	}

}


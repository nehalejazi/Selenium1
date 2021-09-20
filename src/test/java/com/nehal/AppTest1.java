package com.nehal;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest1 {
	
	@Test
	public void logintest1()
	{
		App1 app1 = new App1();
		Assert.assertEquals(0, app1.userLogin("abc", "abc123"));
		
	}
	
	@Test
	public void logintest2()
	{
		App1 app2 = new App1();
		Assert.assertEquals(1, app2.userLogin("abc", "abc@123"));
		
	}

}

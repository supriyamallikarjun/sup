package com.qsp.testscripts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.generic.BaseClass;

@Listeners(com.actitime.generic.MyListener.class)

public class ScreenShot extends BaseClass {
	@Test
	public void takeScreenshot() {
		Reporter.log("takeScreenshot",true);
		Assert.fail();
		
	}
}

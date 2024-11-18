package com.truboardpartners.testClasses;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.turbopartners.pom.pages.LoginPage;

public class Developer_ProjectSetUp extends BaseTest{

	@Test(description = "Developer raise NOC request")
	public void raiseNOCRequest() throws AWTException {
		
		LoginPage login = new LoginPage();
		login.loginDeveloper(TestConfig.getInstance().getDeveloperUserId(),TestConfig.getInstance().getDeveloperUserPWD());
}
}

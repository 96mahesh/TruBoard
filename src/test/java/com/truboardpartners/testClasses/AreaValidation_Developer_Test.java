package com.truboardpartners.testClasses;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.truboardpartners.pageClasses.Developer_Page;
import com.turbopartners.pom.pages.LoginPage;

public class AreaValidation_Developer_Test extends BaseTest {

	@Test
	public void method() throws AWTException {
		LoginPage login = new LoginPage();
		login.loginDeveloper(TestConfig.getInstance().getDeveloperUserId(),TestConfig.getInstance().getDeveloperUserPWD());
		
		Developer_Page developer_Page = new Developer_Page();
		developer_Page.clickOnSearchFieldEnterValue();
		developer_Page.clickOnSearchAndSendData();
		developer_Page.clickOnViewRequest();
		developer_Page.clickOnNocRequest();
		developer_Page.clickOnRequestNocBtn();
		developer_Page.enterUnitNo();
		developer_Page.getAreaValue();
		developer_Page.getTotalPurchaseConsiderationAmount();
		developer_Page.getRealisedPrice();		
		developer_Page.validation();
		
		
		
	}
}

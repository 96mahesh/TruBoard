package com.truboardpartners.testClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.LinkedHashMap;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.truboard.utils.CommonUtils;
import com.truboard.utils.DataLoaders;
import com.truboardpartners.pageClasses.Developer_Page;
import com.turbopartners.pom.pages.LoginPage;
import com.turbopartners.pom.pages.NOCApprovalPage;
import com.turbopartners.pom.pages.NOCRequestPage;
import com.turbopartners.pom.pages.Projects_NOC_Page;

public class CancelNoc_Test extends BaseTest
{
	
	@Test(priority = 0, description = "Cancel Noc by Developer")
	public void cancelNOCByDeveloper() throws AWTException, InterruptedException {
		LoginPage login = new LoginPage();
		Developer_Page developer_Page = new Developer_Page();

		login.loginDeveloper(TestConfig.getInstance().getDeveloperUserId(),
				TestConfig.getInstance().getDeveloperUserPWD());
		developer_Page.clickOnSearchFieldEnterValue();
		developer_Page.clickOnSearchAndSendData();
		developer_Page.clickOnViewRequest();
		developer_Page.clickOnNocRequest();
		developer_Page.selectValueFromeSelectFieldApprovedTable();
		developer_Page.enterValueInSearchApprovedTable();
		developer_Page.clickOnFirstRowCancelNocIcon();
		developer_Page.clickOnCancelNocBtn();
		developer_Page.clickOnYesBtn();
		developer_Page.verifySuccessMsg();
	}
	
}

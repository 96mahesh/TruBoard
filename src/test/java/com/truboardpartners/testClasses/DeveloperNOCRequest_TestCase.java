package com.truboardpartners.testClasses;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.truboard.setup.TestDataConfig;
import com.truboardpartners.pageClasses.Developer_Page;
import com.turbopartners.pom.pages.LoginPage;

public class DeveloperNOCRequest_TestCase extends BaseTest {
	
	@Test(description = "Developer raise NOC request")
	public void raiseNOCRequest() throws AWTException {
		
		LoginPage login = new LoginPage();
		login.loginDeveloper(TestConfig.getInstance().getDeveloperUserId(),TestConfig.getInstance().getDeveloperUserPWD());
		
		Developer_Page developer_Page = new Developer_Page();
		developer_Page.clickOnSearchFieldEnterValue();
		developer_Page.clickOnSearchAndSendData();
		developer_Page.clickOnViewRequest();
		developer_Page.clickOnNocRequest();
		developer_Page.clickOnRequestNocBtn();
		developer_Page.enterUnitNo();
		developer_Page.enterRemark();
		developer_Page.clickOnUploadBankStatementAndUploadPDFFile(); 
		developer_Page.clickOnUploadLedgerAndUploadXlsFile(); 
		developer_Page.clickOnVerifyPayment();
		developer_Page.clickOnDownload();
		developer_Page.clickOnUploadAndUploadDownloadedFile();
		developer_Page.validateUploadedFileName();
		developer_Page.clickOnsubmitBtn();
		developer_Page.clickOnYesButton();
		developer_Page.nocRequestSuccessMessage();
	}

}

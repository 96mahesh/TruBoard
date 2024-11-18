package com.truboardpartners.testClasses;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.truboardpartners.pageClasses.Debenture_Page;
import com.truboardpartners.pageClasses.Developer_Page;
import com.truboardpartners.pageClasses.Invester_Page;
import com.truboardpartners.pageClasses.PMC_Page;
import com.turbopartners.pom.pages.LoginPage;

public class HAR_Test extends BaseTest{
	@Test(priority = 2, description = "Developer raise NOC request")
	public void raiseNOCRequest() throws AWTException {

		LoginPage login = new LoginPage();
		login.loginDeveloper(TestConfig.getInstance().getDeveloperUserId(),
				TestConfig.getInstance().getDeveloperUserPWD());

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
	@Test(priority = 3, description = "Hold Noc Request by PMC")
	public void holdPMC_RFA() throws InterruptedException {
		LoginPage login = new LoginPage();
		PMC_Page pMC_Page = new PMC_Page();
		login.loginpmc(TestConfig.getInstance().getUserId(), TestConfig.getInstance().getUserPWD());
		pMC_Page.clickOnAssetProfile();
		pMC_Page.clickOnNOCLink();
		pMC_Page.selectProject();
		pMC_Page.clickOnManageRequest();
		pMC_Page.clickOnShowMyDeliverables_CheckBoxPendingTable();
		pMC_Page.selectValueFromeSelectFieldPendingTable();
		pMC_Page.enterValueInSearchPendingTable();
		pMC_Page.verificationOnPendingTable();
		pMC_Page.clickOnApproveAndAuthorizeOrCancelNocBtn();
		pMC_Page.selectValueFromFinalDecisionTable(TestConfig.getInstance().getFinalDecisionPMC());
		pMC_Page.enterRemarksFeild();
		pMC_Page.clickOnSubmitBtn();
	}
	@Test(priority = 4, description = "Approve Noc Request by Investor")
	public void approveInvester_RFA() throws InterruptedException {

		LoginPage login = new LoginPage();
		Invester_Page invester_Page = new Invester_Page();
		login.loginInvestor(TestConfig.getInstance().getLenderUserId(), TestConfig.getInstance().getLenderUserPWD());
		invester_Page.clickOnAssetProfile();
		invester_Page.clickOnNOCLink();
		invester_Page.selectProject();
		invester_Page.clickOnManageRequest();
		invester_Page.clickOnShowMyDeliverables_CheckBoxPendingTable();
		invester_Page.selectValueFromeSelectFieldPendingTable();
		invester_Page.enterValueInSearchPendingTable();
		invester_Page.verificationOnPendingTable();
		invester_Page.clickOnApproveAndAuthorizeOrCancelNocBtn();
		invester_Page.selectValueFromFinalDecisionTable(TestConfig.getInstance().getFinalDecisionInvestor());
		invester_Page.clickOnDownload_Btn();
		invester_Page.uploadDocument();
		invester_Page.clickOnSubmitBtn();
	}
	@Test(priority=5,description="Reject Noc Request by DT")
	public void rejectDT_RFA() throws InterruptedException, AWTException {

		LoginPage login = new LoginPage();
		Debenture_Page debenture_Page = new Debenture_Page();
		login.loginDebenture(TestConfig.getInstance().getDeveloperUserId2(),
				TestConfig.getInstance().getDeveloperUserPWD2());
		debenture_Page.clickOnSearchFieldEnterValue();
		debenture_Page.clickOnSearchAndSendData();
		debenture_Page.clickOnViewRequest();
		debenture_Page.clickOnNocRequest();
		debenture_Page.selectValueFromeSelectFieldPendingTable();
		debenture_Page.enterValueInSearchPendingTable();
		//debenture_Page.verificationOnPendingTable();
		debenture_Page.ClickOnAuthorize();
		debenture_Page.selectValueFromFinalDecisionTable(TestConfig.getInstance().getFinalDecisionDebenture());
		debenture_Page.enterRemarksFeild();
		debenture_Page.clickOnSubmitBtn();
	}

}

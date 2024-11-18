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

public class CCC_Test extends BaseTest {

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


	@Test(priority = 2, description = "Cancel Noc Request by PMC")
	public void cancelNocByPMC() {
		LoginPage login = new LoginPage();
		PMC_Page pMC_Page = new PMC_Page();
		login.loginpmc(TestConfig.getInstance().getUserId(), TestConfig.getInstance().getUserPWD());
		pMC_Page.clickOnAssetProfile();
		pMC_Page.clickOnNOCLink();
		pMC_Page.selectProject();
		pMC_Page.clickOnManageRequest();
		pMC_Page.clickOnShowMyDeliverables_CheckBoxPendingTable();
		pMC_Page.selectValueFromeSelectFieldPendingTable();
		pMC_Page.enterValueInSearchPendingTableForCancel();
		pMC_Page.clickOnApproveAndAuthorizeOrCancelNocBtn();
		pMC_Page.selectValueFromFinalDecisionTable(TestConfig.getInstance().getFinalDecisionPMC());
		pMC_Page.clickOnSubmitBtn();
	}

	@Test(priority = 3, description = "Cancel Noc Request by Invester")
	public void cancelNocByInvester() {
		LoginPage login = new LoginPage();
		Invester_Page invester_Page = new Invester_Page();
		login.loginInvestor(TestConfig.getInstance().getLenderUserId(), TestConfig.getInstance().getLenderUserPWD());
		invester_Page.clickOnAssetProfile();
		invester_Page.clickOnNOCLink();
		invester_Page.selectProject();
		invester_Page.clickOnManageRequest();
		invester_Page.clickOnShowMyDeliverables_CheckBoxPendingTable();
		invester_Page.selectValueFromeSelectFieldPendingTable();
		invester_Page.enterValueInSearchPendingTableForCancel();
		invester_Page.clickOnApproveAndAuthorizeOrCancelNocBtn();
		invester_Page.selectValueFromFinalDecisionTable(TestConfig.getInstance().getFinalDecisionInvestor());
		invester_Page.clickOnSubmitBtn();
	}

	@Test(priority = 4, description = "Cancel Noc Request in Debenture")
	public void cancelNocByDebenture() throws AWTException {
		LoginPage login = new LoginPage();
		Debenture_Page debenture_Page = new Debenture_Page();
		login.loginDebenture(TestConfig.getInstance().getDeveloperUserId2(),
				TestConfig.getInstance().getDeveloperUserPWD2());
		debenture_Page.clickOnSearchFieldEnterValue();
		debenture_Page.clickOnSearchAndSendData();
		debenture_Page.clickOnViewRequest();
		debenture_Page.clickOnNocRequest();
		debenture_Page.selectValueFromeSelectFieldPendingTable();
		debenture_Page.enterValueInSearchPendingTableForCancel(TestConfig.getInstance().getUnitNumber());
		debenture_Page.ClickOnAuthorize();
		debenture_Page.selectValueFromFinalDecisionTable(TestConfig.getInstance().getFinalDecisionDebenture());
		debenture_Page.clickOnSubmitBtn();
	}
	
	@Test(priority = 5, description = "Validation on Cancelled NOC at Developer Page(Cancelled NOC Table)")
	public void validationOnCancelledNOC() throws AWTException {
		LoginPage login = new LoginPage();
		Developer_Page developer_Page = new Developer_Page();

		login.loginDeveloper(TestConfig.getInstance().getDeveloperUserId(),
				TestConfig.getInstance().getDeveloperUserPWD());
		developer_Page.clickOnSearchFieldEnterValue();
		developer_Page.clickOnSearchAndSendData();
		developer_Page.clickOnViewRequest();
		developer_Page.clickOnNocRequest();
		developer_Page.selectValueFromeSelectFieldCancelledTable();
		developer_Page.enterValueInSearchCancelledTable();
		developer_Page.verificationOnCancelledTable();
		
	}
	

}

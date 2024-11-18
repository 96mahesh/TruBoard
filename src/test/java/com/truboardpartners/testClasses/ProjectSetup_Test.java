package com.truboardpartners.testClasses;

import org.testng.annotations.Test;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.truboardpartners.pageClasses.PMC_Page;
import com.turbopartners.pom.pages.LoginPage;

public class ProjectSetup_Test extends BaseTest {	
	
	@Test(priority = 1, description = "Setup Work Flow")
	public void workFlow_PMC() throws InterruptedException {

		LoginPage login = new LoginPage();
		PMC_Page pMC_Page = new PMC_Page();

		login.loginpmc(TestConfig.getInstance().getUserId(), TestConfig.getInstance().getUserPWD());
		pMC_Page.clickOnAssetProfile();
		pMC_Page.clickOnNOCLink();
		pMC_Page.selectProject();
		pMC_Page.clickOnManageProject();
		pMC_Page.deleteAndAddEntites();
		pMC_Page.deleteAndAddUsers();
		pMC_Page.addAccountDetails();
		pMC_Page.AddThresholdDetails();
	}

}

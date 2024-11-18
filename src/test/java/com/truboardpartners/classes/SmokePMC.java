package com.truboardpartners.classes;


import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.truboard.utils.DataLoaders;
import com.turbopartners.pom.pages.LoginPage;
import com.turbopartners.pom.pages.NOCRequestPage;
import com.turbopartners.pom.pages.Projects_NOC_Page;

public class SmokePMC extends BaseTest {

	private String assetprofile_1;
	private By asset_profile_1;
	private String noc_pro_1;
	private By noc_1;
	private String nxt_btn;
	private By nxtbtn;
	private String nxtbtn_1;
	private By nxtbtn1;
	private String nxtbtn_2;
	private By nxtbtn2;
	private String done_1;
	private By done;
	private String logout_1;
	private By logout;
	private String manageproject;
	private String nocproject;
	private By manage_project;
	private By noc_project;

	@Test(description = "")
	public void TestCase_PMC() {
		try {
			// Setting up test data
			String unitNo = null;
			String tower = null;
			String wing = null;
			String dateOfBooking = null;
			String saleableAreaSqft = null;
			String purchaserName = "";
			String purchaserProfile = "Employee";
			String purchaseConsideration = null;
			String realisedPrice = "5000";
			String financer = "HDFC";
			String bank = "HDFC";
			String paymentReceivedTillDate = "250000";
			String remark = "test";

			DataLoaders data = BaseTest.utilObj.get().getDataLoaders();
			LinkedHashMap<String, LinkedHashMap<String, String>> allData = allTestData.get();

			LoginPage login = new LoginPage();
			NOCRequestPage nocRequestPage = new NOCRequestPage();
			Projects_NOC_Page projNOCPage = new Projects_NOC_Page();
			SmokePMC smokePMC = new SmokePMC();

			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test:Successfully create NOC Request for developers in TRUBOARDPARTNERS ------><b>",
					false);
			login.loginpmc(TestConfig.getInstance().getUserId(),
					TestConfig.getInstance().getUserPWD());

			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b>Going to na vigate NOC Request page<b>",
					false);
			BaseTest.utilObj.get().getUIUtils().clickElement(smokePMC.assetprofile_1,smokePMC.asset_profile_1);
			BaseTest.utilObj.get().getUIUtils().clickElement(smokePMC.noc_pro_1, smokePMC.noc_1);
			BaseTest.utilObj.get().getUIUtils().clickElement(smokePMC.manageproject, smokePMC.manage_project);
			BaseTest.utilObj.get().getUIUtils().clickElement(smokePMC.nocproject, smokePMC.noc_project);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokePMC.nextbutton, smokePMC.next);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.newbutton, smokeInvestor.new_button);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.developer_role, smokeInvestor.new_button);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.entity_option, smokeInvestor.entity);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.submitbtn, smokeInvestor.Submit);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.clicknew, smokeInvestor.click_new);
			//BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.selectrole, smokeInvestor.select_role);
			//BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			BaseTest.utilObj.get().getUIUtils().clickElement(smokePMC.nxt_btn, smokePMC.nxtbtn);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);

			BaseTest.utilObj.get().getUIUtils().clickElement(smokePMC.nxtbtn_1, smokePMC.nxtbtn1);
			
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);

			BaseTest.utilObj.get().getUIUtils().clickElement(smokePMC.nxtbtn_2, smokePMC.nxtbtn2);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);

			BaseTest.utilObj.get().getUIUtils().clickElement(smokePMC.done_1, smokePMC.done);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			
			BaseTest.utilObj.get().getUIUtils().clickElement(smokePMC.logout_1, smokePMC.logout);

			
			
			
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Creating NOC Request. Exception:" + e.getMessage(), true);
		}

	}

}

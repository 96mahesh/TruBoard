package com.truboardpartners.classes;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.truboard.utils.DataLoaders;
import com.turbopartners.pom.pages.LoginPage;
import com.turbopartners.pom.pages.NOCRequestPage;
import com.turbopartners.pom.pages.Projects_NOC_Page;

public class SmokeInvestorTest extends BaseTest {

	@Test(description = "")
	public void TestCase_Investor() {
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
			SmokeInvestor smokeInvestor = new SmokeInvestor();

			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test:Successfully create NOC Request for developers in TRUBOARDPARTNERS ------><b>",
					false);
			login.loginInvestor(TestConfig.getInstance().getLenderUserId(),
					TestConfig.getInstance().getLenderUserPWD());

			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b>Going to na vigate NOC Request page<b>",
					false);
			BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.assetprofile,smokeInvestor.asset_profile);
			BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.noc_pro, smokeInvestor.noc);
			BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.manageproject, smokeInvestor.manage_project);
			BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.nocproject, smokeInvestor.noc_project);
			BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.nextbutton, smokeInvestor.next);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.newbutton, smokeInvestor.new_button);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.developer_role, smokeInvestor.new_button);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.entity_option, smokeInvestor.entity);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.submitbtn, smokeInvestor.Submit);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.clicknew, smokeInvestor.click_new);
			//BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			//BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.selectrole, smokeInvestor.select_role);
			//BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.nxt_btn, smokeInvestor.nxtbtn);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);

			BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.nxtbtn_1, smokeInvestor.nxtbtn1);
			
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);

			BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.nxtbtn_2, smokeInvestor.nxtbtn2);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);

			BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.done_1, smokeInvestor.done);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			
			BaseTest.utilObj.get().getUIUtils().clickElement(smokeInvestor.logout_1, smokeInvestor.logout);

			
			
			
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Creating NOC Request. Exception:" + e.getMessage(), true);
		}

	}
}

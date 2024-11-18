package com.truboardpartners.classes;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.LinkedHashMap;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.truboard.utils.DataLoaders;
import com.turbopartners.pom.pages.LoginPage;
import com.turbopartners.pom.pages.NOCRequestPage;
import com.turbopartners.pom.pages.Projects_NOC_Page;

public class SmokeDebentureTest extends BaseTest {
	@Test(description = "Debenture finally issues NOC request Successfully")
	public void TestCase_debenture() { 
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
			SmokeDebenture smokedebenture = new SmokeDebenture();
			
		

			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test:Successfully create NOC Request for developers in TRUBOARDPARTNERS ------><b>",
					false);
			login.loginDebenture(TestConfig.getInstance().getDeveloperUserId2(),
					TestConfig.getInstance().getDeveloperUserPWD2());
			
		
	

			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "<b>Going to navigate NOC Request page<b>",
					false);
			
			

			BaseTest.utilObj.get().getUIUtils().clickElement(projNOCPage.searchFiledBox_Name,
					projNOCPage.searchFiledBox);
			BaseTest.utilObj.get().getUIUtils().selectValue(projNOCPage.searchFiledBox_Name, projNOCPage.searchFiledBox,
					"Text", "Project Name");
			BaseTest.utilObj.get().getUIUtils().clickElement(projNOCPage.searchproj, projNOCPage.search_proj);

			BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(projNOCPage.searchproj, projNOCPage.search_proj,
					"Asset TestPerform", Keys.ENTER);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			
			BaseTest.utilObj.get().getUIUtils().clickElement(projNOCPage.viewrequest, projNOCPage.View_Req);

			BaseTest.utilObj.get().getUIUtils().validateObjectPresent(projNOCPage.Noc_Req, projNOCPage.nocrequest, true,
					true);
			
			
			
		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Creating NOC Request. Exception:" + e.getMessage(), true);
		}

	}
}

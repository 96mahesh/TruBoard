package com.truboardpartners.classes;

import java.util.LinkedHashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.truboard.utils.CommonUtils;
import com.truboard.utils.DataLoaders;
import com.turbopartners.pom.pages.NOCRequestPage;
import com.turbopartners.pom.pages.Projects_NOC_Page;
import com.turbopartners.pom.pages.NOCApprovalPage;
import com.turbopartners.pom.pages.LoginPage;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class SmokeDeveloper extends BaseTest {

	public static String UnitNo="Tower B-Wing A-710";
	@Test(description = "Developer raise NOC request Successfully")
	public void raiseNOCRequest() {
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
			NOCApprovalPage nocApprovalPage = new NOCApprovalPage();

			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"<b><----Test case execution started for Test:Successfully create NOC Request for developers in TRUBOARDPARTNERS ------><b>",
					false);
			login.loginDeveloper(TestConfig.getInstance().getDeveloperUserId(),
					TestConfig.getInstance().getDeveloperUserPWD());

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
			BaseTest.utilObj.get().getUIUtils().clickElementUsingAction(projNOCPage.nocrequest, projNOCPage.Noc_Req);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);

			BaseTest.utilObj.get().getUIUtils().clickElementUsingAction(projNOCPage.requestNOCBtn_Name,
					projNOCPage.requestNOCBtn);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);

			BaseTest.utilObj.get().getUIUtils().inputText(projNOCPage.unitNoTxt_Name, projNOCPage.unitNoTxt,
					UnitNo);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);

			robot.keyPress(KeyEvent.VK_DOWN);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			robot.keyPress(KeyEvent.VK_ENTER);

			BaseTest.utilObj.get().getUIUtils().inputText(projNOCPage.financer_Txt_Name, projNOCPage.financer_Txt,
					financer);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);

			BaseTest.utilObj.get().getUIUtils().inputText(projNOCPage.remark_Txt_Name, projNOCPage.remark_Txt, remark);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);

			BaseTest.utilObj.get().getUIUtils().clickElement(projNOCPage.uploadBank_StatementEle_Name,
					projNOCPage.uploadBank_StatementEle);

			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Going to upload bank statement", false);
			BaseTest.utilObj.get().getUIUtils().uploadFile("D:\\Truboard\\Apr_2022.pdf");

			BaseTest.utilObj.get().getUIUtils().moveToElement(projNOCPage.uploadLedgerEle_Name_1,
					projNOCPage.uploadLedgerEle_1);
			BaseTest.utilObj.get().getUIUtils().waitForSec(2);
			BaseTest.utilObj.get().getUIUtils().clickElementUsingAction(projNOCPage.uploadLedgerEle_Name_1,
					projNOCPage.uploadLedgerEle_1);
			BaseTest.utilObj.get().getUIUtils().waitForSec(4);
			BaseTest.utilObj.get().getUIUtils().uploadFile("D:\\Truboard\\Customer_ABC.xls");

			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"Going to verify Payment status by clicking Verify button", false);
			BaseTest.utilObj.get().getUIUtils().clickElement(projNOCPage.verifyBtn_Name_1, projNOCPage.verifyBtn_1);
			boolean paymentVerfied = projNOCPage.getPaymentVerfiedStatusAtLeastOneRow();

			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"Going to download Digital Signed letter followed by uploading", false);

			// BaseTest.utilObj.get().getUIUtils().clickElementUsingAction(
			// projNOCPage.downloadDigitallySignedLetterEle_Name,
			// projNOCPage.downloadDigitallySignedLetterEle_1);
			// BaseTest.utilObj.get().getUIUtils().waitForSec(4);
			// BaseTest.utilObj.get().getUIUtils().clickElementUsingJS2(projNOCPage.uploadSignatirePopupEle_Name_1,"//input[@name='financertext']",
			// true);
			// BaseTest.utilObj.get().getUIUtils().waitForSec(4);
			// BaseTest.utilObj.get().getUIUtils().uploadFile("C:\\TruBoard\\digitallySignedLetter.jpeg");
			BaseTest.utilObj.get().getUIUtils().clickElementUsingAction(projNOCPage.downloadws,
					projNOCPage.download_WS);

			BaseTest.utilObj.get().getUIUtils().waitForSec(8);
			String downloadedSignatureFile = CommonUtils.getLastModifiedFilePath("C:\\Users\\Indian\\Downloads");
			String expectedFileName = downloadedSignatureFile.replace("C:\\Users\\Indian\\Downloads\\", "");
			System.out.println("expectedFileName:" + expectedFileName);

			
			BaseTest.utilObj.get().getUIUtils().clickElementUsingAction(projNOCPage.uploadedSignedRequestFileNameLbl_Name, projNOCPage.uploadedSignedRequestFileNameLbl);
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			BaseTest.utilObj.get().getUIUtils().uploadFile(downloadedSignatureFile);
			BaseTest.utilObj.get().getUIUtils().waitForSec(2);

			String actualUploadedBankFileName = BaseTest.utilObj.get().getUIUtils().getText(
					nocApprovalPage.signedIssuanceUploadedLetterLbl_Name,
					nocApprovalPage.signedIssuanceUploadedLetterLbl, true);
			//BaseTest.utilObj.get().getAssertManager().sAssertEquals(actualUploadedBankFileName, expectedFileName,
				//	"Verification of Uploaded Authorizationa Request Letter file name displayed after uploading", true,
					//true);

			BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO",
					"Going to click Submit button and taking screenshot for test data entered reference", true);
			BaseTest.utilObj.get().getUIUtils().clickElement(projNOCPage.submitBtn_Name, projNOCPage.submitBtn);
			BaseTest.utilObj.get().getUIUtils().clickElement(projNOCPage.YesBtn_Name,
					projNOCPage.YesBtn);
			
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			
			//BaseTest.utilObj.get().getUIUtils().clickElementUsingAction(projNOCPage.logoffLnk_Name, projNOCPage.logoffLnk);
			//String toastMsg = BaseTest.utilObj.get().getUIUtils().getText(nocRequestPage.toastMsgEle_Name,
					//nocRequestPage.toastMsgEle, true);
			//BaseTest.LOGGER.get().logTestStep(extentTest.get(), "INFO", "Taking screenshot for reference", true);
			//System.out.println("toastMsg:" + toastMsg);
			//BaseTest.utilObj.get().getAssertManager().sAssertEquals(toastMsg, "NOC request sent successfully",
			//		"Validation of successful Toast Message as <b>NOC request sent successfully</b> ", false, true);

		} catch (Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException(
					"Something went wrong in doing Creating NOC Request. Exception:" + e.getMessage(), true);
		}
	}
}

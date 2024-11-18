package com.truboardpartners.pageClasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.truboard.utils.CommonUtils;



public class Developer_Page {
	public static String UNo = TestConfig.getInstance().getUnitNumber();
	public static String UnitNo = "";
	Robot robot;
	// Tower B-Wing A-707
	public By SearchField = By.xpath("//select[@name='wm-datatable']");
	public String SearchField_Name = "Search Bar Field";
	public By Search = By.xpath("//input[@class='form-control app-textbox']");
	public String Search_Name = "Sarch";
	public By ViewRequest = By.xpath("//button[@title='View Request']");
	public String ViewRequest_Name = "ViewRequest";
	public By NocRequest = By.xpath("//a[@name='anchor2']");
	public String NocRequest_Name = "NocRequest";
	public By RequestNocBtn = By.xpath("//span[text()='Request NOC']");
	public String RequestNocBtn_Name = "RequestNocBtn";
	public By SearchUnitNo = By.xpath("//input[@placeholder='Search Unit No']");
	public String SearchUnitNo_Name = "SearchUnitNo";
	public By paymentRecivedDateEnter = By.xpath("//input[@name='advancedpaymenttext']");
	public String paymentRecivedDateEnter_name ="Pament revice Enter";
	public By EnterRemark = By.xpath("//input[@placeholder='Enter remark']");
	public String EnterRemark_Name = "EnterRemark";
	public By UploadBankStatement = By.xpath("//button[@title='Upload Bank Statement']");
	public String UploadBankStatement_Name = "UploadBankStatement";
	public By UploadLedger = By.xpath("//*[@caption='Upload ledger']//*[contains(@class,'sl-cloud-upload')]");
	public String UploadLedger_Name = "UploadLedger";
	public By VerifyPayment = By.xpath("//button[@title='Verify Payment']");
	public String VerifyPayment_Name = "VerifyPayment";
	public By Download = By.xpath("//span[normalize-space()='Download']");
	public String Download_Name = "Download";
	public By UploadedSignedRequestFileName = By.xpath("//button//span[text()='Upload']");
	public String UploadedSignedRequestFileName_Name = "UploadedSignedRequestFileName";
	public By SignedIssuanceUploadedLetter = By.xpath("//label[@class='upload-title']");
	public String SignedIssuanceUploadedLetter_Name = "signedIssuanceUploadedLetter";
	public By submitBtn = By.xpath("//button[@caption='Submit']");
	public String submitBtn_Name = "submitBtn";
	public By YesButton = By.xpath("//span[normalize-space()='YES']");
	public String YesButton_Name = "YesButton";
	// Approved Nocs
	public By FirstRowCancelNocIcon = By.xpath("((//table[@class='table table-hover'])[4]/tbody/tr[1]/td[8]//i)[2]");
	public String FirstRowCancelNocIcon_Name = "FirstRowCancelNocIcon";
	public By CanceNocBtn = By.xpath("(//span[text()='Cancel NOC'])[2]");
	public String CanceNocBtn_Name = "CanceNocBtn";
	public By YesBtn = By.xpath("//span[text()='Yes']");
	public String YesBtn_Name = "YesBtn";
	public By SuccessMsg = By.xpath("//div[text()='Noc cancelled successfully']");
	public String SuccessMsg_Name = "SuccessMsg";
	public By UnitNoInFristRowApprovedTable = By.xpath("((//table)[4]/tbody/tr/td)[1]");
	public String UnitNoInFristRowApprovedTable_Name = "UnitNoInFristRowApprovedTable";

	public void clickOnSearchFieldEnterValue() {
		BaseTest.utilObj.get().getUIUtils().clickElement(SearchField_Name, SearchField);
		BaseTest.utilObj.get().getUIUtils().selectValue(SearchField_Name, SearchField, "Text",
				TestConfig.getInstance().getSelectField_DevHomePage());
	}

	public void clickOnSearchAndSendData() throws AWTException {
		BaseTest.utilObj.get().getUIUtils().clickElement(Search_Name, Search);
		BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(Search_Name, Search,
				TestConfig.getInstance().getSearch_DevHomePage(), Keys.ENTER);

		robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
	}

	public void clickOnViewRequest() {
		BaseTest.utilObj.get().getUIUtils().clickElement(ViewRequest_Name, ViewRequest);
	}

	public void clickOnNocRequest() {
		BaseTest.utilObj.get().getUIUtils().clickElement(NocRequest_Name, NocRequest);
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
	}

	public void clickOnRequestNocBtn() {
		BaseTest.utilObj.get().getUIUtils().clickElement(RequestNocBtn_Name, RequestNocBtn);
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
	}

	public void enterUnitNo() throws AWTException {
		robot = new Robot();
		BaseTest.utilObj.get().getUIUtils().inputText(SearchUnitNo_Name, SearchUnitNo, Developer_Page.UNo);

		// BaseTest.utilObj.get().getUIUtils().inputText(SearchUnitNo_Name,
		// SearchUnitNo,unitNumber);
		BaseTest.utilObj.get().getUIUtils().waitForSec(10);
		robot.keyPress(KeyEvent.VK_DOWN);
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void enterPaymentReciveDate() {
		BaseTest.utilObj.get().getUIUtils().inputText(paymentRecivedDateEnter_name, paymentRecivedDateEnter,"100000");
	}

	public void enterRemark() {
		BaseTest.utilObj.get().getUIUtils().inputText(EnterRemark_Name, EnterRemark, "Test");
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
	}

	public void clickOnUploadBankStatementAndUploadPDFFile() {
		BaseTest.utilObj.get().getUIUtils().clickElement(UploadBankStatement_Name, UploadBankStatement);
		BaseTest.utilObj.get().getUIUtils().uploadFile("C:\\Mahesh\\Truboard\\Apr_2022.pdf");
	}

	public void clickOnUploadLedgerAndUploadXlsFile() {
		BaseTest.utilObj.get().getUIUtils().moveToElement(UploadLedger_Name, UploadLedger);
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
		BaseTest.utilObj.get().getUIUtils().clickElementUsingAction(UploadLedger_Name, UploadLedger);
		BaseTest.utilObj.get().getUIUtils().waitForSec(4);
		BaseTest.utilObj.get().getUIUtils().uploadFile("C:\\Mahesh\\Truboard\\Customer_ABC.xls");
	}

	public static boolean getPaymentVerfiedStatusAtLeastOneRow() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clickOnVerifyPayment() {
		BaseTest.utilObj.get().getUIUtils().clickElement(VerifyPayment_Name, VerifyPayment);
		boolean paymentVerfied = Developer_Page.getPaymentVerfiedStatusAtLeastOneRow();
	}

	public void clickOnDownload() {
		BaseTest.utilObj.get().getUIUtils().clickElementUsingAction(Download_Name, Download);
		BaseTest.utilObj.get().getUIUtils().waitForSec(8);
	}

	public void clickOnUploadAndUploadDownloadedFile() {
		String downloadedSignatureFile = CommonUtils.getLastModifiedFilePath("C:\\Users\\Admin\\Downloads\\");
		String expectedFileName = downloadedSignatureFile.replace("C:\\Users\\Admin\\Downloads\\", "");
		System.out.println("expectedFileName:" + expectedFileName);
		BaseTest.utilObj.get().getUIUtils().clickElementUsingAction(UploadedSignedRequestFileName_Name,
				UploadedSignedRequestFileName);
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().uploadFile(downloadedSignatureFile);
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
	}

	public void validateUploadedFileName() {
		String actualUploadedBankFileName = BaseTest.utilObj.get().getUIUtils()
				.getText(SignedIssuanceUploadedLetter_Name, SignedIssuanceUploadedLetter, true);
	}

	public void clickOnsubmitBtn() {
		BaseTest.utilObj.get().getUIUtils().clickElement(submitBtn_Name, submitBtn);
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
	}

	public void clickOnYesButton() {
		BaseTest.utilObj.get().getUIUtils().clickElement(YesButton_Name, YesButton);
		//BaseTest.utilObj.get().getUIUtils().waitForSec(5);
	}

	// Approved Nocs
//	public void getUnitNo() throws InterruptedException {
//		Thread.sleep(10000);
//		UNo=BaseTest.utilObj.get().getUIUtils().getText(UnitNoInFristRowApprovedTable_Name, UnitNoInFristRowApprovedTable);
//		System.out.println("Unit No in Developer page is : "+UnitNo);
//	}
	public void clickOnFirstRowCancelNocIcon() {
		BaseTest.utilObj.get().getUIUtils().clickElement(FirstRowCancelNocIcon_Name, FirstRowCancelNocIcon);
	}

	public void clickOnCancelNocBtn() {
		BaseTest.utilObj.get().getUIUtils().clickElement(CanceNocBtn_Name, CanceNocBtn);
	}

	public void clickOnYesBtn() {
		BaseTest.utilObj.get().getUIUtils().clickElement(YesBtn_Name, YesBtn);
	}

	public void verifySuccessMsg() throws InterruptedException {
		String text = BaseTest.utilObj.get().getUIUtils().getText(SuccessMsg_Name, SuccessMsg);
		System.out.println("Success Message is: " + text);
		Thread.sleep(3000);
		if (text.equals("Noc cancelled successfully")) {
			Assert.assertTrue(true);
		}
	}

	// Pending table
	public By SelectFieldPendingTable = By.xpath("(//select[@name='wm-datatable'])[1]");
	public String SelectFieldPendingTable_Name = "SelectFieldPendingTable";

	public void selectValueFromeSelectFieldPendingTable() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().selectValue(SelectFieldPendingTable_Name, SelectFieldPendingTable, "Text",
				TestConfig.getInstance().getSelectField_PendingTable());
	}

	public By SearchPendingTable = By.xpath("(//input[@placeholder='Search'])[1]");
	public String SearchPendingTable_Name = "SearchPendingTable";

	public void enterValueInSearchPendingTable() {
		String no = Developer_Page.UNo;
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(SearchPendingTable_Name, SearchPendingTable, no,
				Keys.ENTER);
	}

	public void enterValueInSearchForWithdrawPendingTable() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(SearchPendingTable_Name, SearchPendingTable,
				TestConfig.getInstance().getSearch_PendingTable_UNo_Withdraw(), Keys.ENTER);
	}

	public By UnitNosPendingTable = By.xpath("(//table[@class='table table-hover'])[1]/tbody/tr/td[1]");
	public String UnitNosPendingTable_Name = "UnitNosPendingTable";

	public void verificationOnPendingTable() {
		String no = TestConfig.getInstance().getSearch_PendingTable_UNo_Withdraw();
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		List<WebElement> elements = BaseTest.utilObj.get().getUIUtils().findElements(UnitNosPendingTable_Name,
				UnitNosPendingTable, TestConfig.getInstance().getOBJWAITTIME());
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		for (WebElement element : elements) {
			String text = element.getText();
			if (text.equals(no)) {
				System.out.println("text=" + text);
				System.out.println("no=" + no);
				System.out.println("we got unit no in pending table");
				Assert.assertEquals(text, no);
			}else {
				Assert.fail();
			}
		}
	}

	public By WithdrawNocBtn = By.xpath("//button[@title='Withdrawn NOC']");
	public String WithdrawNocBtn_Name = "WithdrawNocBtn";

	public void clickOnWithdrawBtn() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().clickElement(WithdrawNocBtn_Name, WithdrawNocBtn);
	}

	By YesBtn_WithdrawPopup = By.xpath("//span[text()='Yes']");
	public String YesBtn_WithdrawPopup_Name = "YesBtn_WithdrawPopup";

	public void clickOnYseBtnWithdraw() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		BaseTest.utilObj.get().getUIUtils().clickElement(YesBtn_WithdrawPopup_Name, YesBtn_WithdrawPopup);
	}

	// Approved Noc's table
	public By SelectFieldApprovedTable = By.xpath("(//select[@name='wm-datatable'])[3]");
	public String SelectFieldApprovedTable_Name = "SelectFieldPendingTable";

	public void selectValueFromeSelectFieldApprovedTable() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().selectValue(SelectFieldApprovedTable_Name, SelectFieldApprovedTable, "Text",
				TestConfig.getInstance().getSearchFieldApprovedTable());
	}

	public By SearchApprovedTable = By.xpath("(//input[@placeholder='Search'])[3]");
	public String SearchApprovedTable_Name = "SearchPendingTable";

	public void enterValueInSearchApprovedTable() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(SearchApprovedTable_Name, SearchApprovedTable,
				TestConfig.getInstance().getUnitNumber(), Keys.ENTER);
	}
	
	public By UnitNosApprovedTable = By.xpath("(//table[@class='table table-hover table-condensed'])[3]//tbody//tr[1]");
	public String UnitNosApprovedTable_Name = "UnitNosApprovedTable";
	public void verificationOnApprovedTable() {
		String no = TestConfig.getInstance().getUnitNumber();
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		List<WebElement> elements = BaseTest.utilObj.get().getUIUtils().findElements(UnitNosApprovedTable_Name,
				UnitNosApprovedTable, TestConfig.getInstance().getOBJWAITTIME());
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		for (WebElement element : elements) {
			String text = element.getText();
			if (text.equals(no)) {
				System.out.println("text=" + text);
				System.out.println("no=" + no);
				System.out.println("we got unit no in Approved table");
				Assert.assertEquals(text, no);
			}else {
				Assert.fail();
			}
		}
	}


	// Cancelled Noc's table
	public By SelectFieldCancelledTable = By.xpath("(//select[@name='wm-datatable'])[5]");
	public String SelectFieldCancelledTable_Name = "SelectFieldCancelledTable";

	public void selectValueFromeSelectFieldCancelledTable() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().selectValue(SelectFieldCancelledTable_Name, SelectFieldCancelledTable, "Text",
				TestConfig.getInstance().getSearchFieldApprovedTable());
	}

	public By SearchCancelledTable = By.xpath("(//input[@placeholder='Search'])[5]");
	public String SearchCancelledTable_Name = "SearchCancelledTable";

	public void enterValueInSearchCancelledTable() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(SearchCancelledTable_Name, SearchCancelledTable,
				TestConfig.getInstance().getUnitNumber(), Keys.ENTER);
	}
	
	public By UnitNosCancelledTable = By.xpath("(//table[@class='table table-hover'])[5]/tbody/tr/td[1]");
	public String UnitNosCancelledTable_Name = "UnitNosCancelledTable";
	public void verificationOnCancelledTable() {
		String no = TestConfig.getInstance().getSearch_ApprovedTable();
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		List<WebElement> elements = BaseTest.utilObj.get().getUIUtils().findElements(UnitNosCancelledTable_Name,
				UnitNosCancelledTable, TestConfig.getInstance().getOBJWAITTIME());
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		for (WebElement element : elements) {
			String text = element.getText();
			if (text.equals(no)) {
				System.out.println("text=" + text);
				System.out.println("no=" + no);
				System.out.println("we got unit no in Cancelled table");
				Assert.assertEquals(text, no);
			}else {
				Assert.fail();
			}
		}
	}
	
	//Rejected NOC Table
	
	public By SelectFieldRejectedTable = By.xpath("(//select[@name='wm-datatable'])[6]");
	public String SelectFieldRejectedTable_Name = "SelectFieldRejectedTable";

	public void selectValueFromeSelectFieldRejectedTable() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().selectValue(SelectFieldRejectedTable_Name, SelectFieldRejectedTable, "Text",
				TestConfig.getInstance().getSearchFieldApprovedTable());
	}

	public By SearchRejectedTable = By.xpath("(//input[@placeholder='Search'])[6]");
	public String SearchRejectedTable_Name = "SearchRejectedTable";

	public void enterValueInSearchRejectedTable() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(SearchRejectedTable_Name, SearchRejectedTable,
				TestConfig.getInstance().getUnitNumber(), Keys.ENTER);
	}
	
	public By UnitNosRejectedTable = By.xpath("(//table[@class='table table-hover'])[6]/tbody/tr/td[1]");
	public String UnitNosRejectedTable_Name = "UnitNosRejectedTable";
	public void verificationOnRejectedTable() {
		String no = TestConfig.getInstance().getUnitNumber();
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		List<WebElement> elements = BaseTest.utilObj.get().getUIUtils().findElements(UnitNosRejectedTable_Name,
				UnitNosRejectedTable, TestConfig.getInstance().getOBJWAITTIME());
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		for (WebElement element : elements) {
			String text = element.getText();
			if (text.equals(no)) {
				System.out.println("text=" + text);
				System.out.println("no=" + no);
				System.out.println("we got unit no in Rejected table");
				Assert.assertEquals(text, no);
			}else {
				Assert.fail();
			}
		}
	}
	//success validations 
	public By withdrawSuccessMessage=By.xpath("//div[text()='Noc withdrawal successfully']");
	public String withdrawSuccessMessage_Name="withdrawSuccessMessage";
	public void withdrawSuccessMessage() {
		String expectedText=BaseTest.utilObj.get().getUIUtils().getText(withdrawSuccessMessage_Name, withdrawSuccessMessage);
		String actualText="Noc withdrawal successfully";
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		if(expectedText.equals(actualText)) {
			Assert.assertTrue(true);
			System.out.println("actualText= "+actualText);
			System.out.println("expectedText= "+expectedText);
		}else {
			Assert.fail();
		}
	}
	
	public By nocRequestSuccessMessage=By.xpath("//div[text()='NOC request sent successfully']");
	public String nocRequestSuccessMessage_Name="nocRequestSuccessMessage";
	public void nocRequestSuccessMessage() {
		String expectedText=BaseTest.utilObj.get().getUIUtils().getText(nocRequestSuccessMessage_Name, nocRequestSuccessMessage);
		String actualText="NOC request sent successfully";
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		if(expectedText.equals(actualText)) {
			Assert.assertTrue(true);
			System.out.println("actualText= "+actualText);
			System.out.println("expectedText= "+expectedText);
		}else {
			Assert.fail();
		}
	}
	
	//Caluclation validations
	public By Area=By.xpath("//input[@placeholder='Enter saleable area']");
	public String Area_Name="Area";
	public int getAreaValue() {
		int value = BaseTest.utilObj.get().getUIUtils().getValueFromTextBox(Area_Name, Area);
		//System.out.println("Area value is:"+ value);
		return value;
	}
	
	public By totalPurchaseConsiderationAmount=By.xpath("//label[@name='totalPurchaseConsiderationAmount']");	
	public String totalPurchaseConsiderationAmount_Name="totalPurchaseConsiderationAmount";
	public int getTotalPurchaseConsiderationAmount() {
		String text = BaseTest.utilObj.get().getUIUtils().getText(totalPurchaseConsiderationAmount_Name, totalPurchaseConsiderationAmount);
		System.out.println("total Purchase Consideration Amount:"+ text);
		String ss="";
		String text1 = text.substring(1, text.length());
		String[] s =text1.split(",");
		for(int i=0;i<s.length;i++) {
			//System.out.println(s[i]);
			ss=ss.concat(s[i]);
		}
	//System.out.println(ss);
	int intvalue=Integer.parseInt(ss);
	//System.out.println("Intvalue is:"+intvalue);
		return intvalue;
	}
	public By realisedPrice=By.xpath("//input[@name='realisedpricetext']");
	public String realisedPrice_Name="realisedPrice";
	public int getRealisedPrice() {
		int value=BaseTest.utilObj.get().getUIUtils().getValueFromTextBox1(realisedPrice_Name, realisedPrice);
		System.out.println("Actual RealisedPrice:"+ value);
		return value;
	}
	
	public void validation() {
	
		int totalAmount = getTotalPurchaseConsiderationAmount();
		System.out.println("totalAmount:"+totalAmount);
		int squareFeetValue = getAreaValue();
		System.out.println("squareFeetValue:"+squareFeetValue);
		int RealisedPrice = totalAmount/squareFeetValue;
		System.out.println("Expected RealisedPrice:"+RealisedPrice);
		if(RealisedPrice == getRealisedPrice()) {
			Assert.assertTrue(true);
		}else {
			System.err.println("wrong realised price");
			Assert.assertTrue(false);
		}
		
	}
	
	
	
	
	
	
	
}

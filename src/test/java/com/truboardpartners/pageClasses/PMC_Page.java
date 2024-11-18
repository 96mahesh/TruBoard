package com.truboardpartners.pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.truboardpartners.classes.SmokeDeveloper;

import junit.framework.Assert;

public class PMC_Page {

	public By AssertProfile_Menu = By.xpath("//span[text()='Asset Profile']");
	public By NOC_Link = By.xpath("//span[text()='NOC']");
	public By Project_Drpdwn = By.xpath("//select[@name='select1']");
	public By ManageProject_Link = By.xpath("//span[text()='Manage Project']");
	public By ManageRequest_Link = By.xpath("//span[text()='Manage Request']");
	// entites
	public By EntitesTableRows = By.xpath("(//table[@class='table table-hover table-condensed'])[1]/tbody/tr");
	public By DeleteIcon_Entites = By
			.xpath("(//table[@class='table table-hover table-condensed'])[1]/tbody/tr/td[3]//button");
	public By YesBtn = By.xpath("//span[text()='Yes']");
	public By NewBtn_Entites = By.xpath("(//span[text()='New'])[1]");
	public By NoData_Entites = By.xpath("(//span[text()='No data found.'])[1]");
	public By Role_Drpdwn_Entites = By.xpath("//select[@name='roleselect']");
	public By Entity_Drpdwn_Entites = By.xpath("//select[@name='entityselect']");
	public By SubmitBtn_AddEntity = By.xpath("//button[@name='addentitybutton']");
	// user
	public By UsersTableRows = By.xpath("(//table[@class='table table-hover table-condensed'])[2]/tbody/tr");
	public By Role_Drodwn_User = By.xpath("//select[@name='adduserroleselect']");
	public By Entity_Drpdwn_User = By.xpath("//select[@name='adduserentityselect']");
	public By User_Drpdwn_User = By.xpath("//select[@name='userselect']");
	public By Address_User = By.xpath("//input[@placeholder='Enter address']");
	public By DeleteIcon_Users = By
			.xpath("(//table[@class='table table-hover table-condensed'])[2]/tbody/tr/td[6]//button");
	public By NewBtn_Users = By.xpath("(//span[text()='New'])[2]");
	public By OK_btn = By.xpath("//span[text()='Ok']");
	public By NoData_User = By.xpath("(//span[text()='No data found.'])[1]");
	public By SubmitBtn_User = By.xpath("//span[text()='Submit']");
	public By NextBtn = By.xpath("//span[text()='Next']");
	public By NewBtn = By.xpath("(//span[text()='New'])[3]");
	// Add Entity Priority(Manage WorkFlow)
	public By NoData_ManageWorkFlow = By.xpath("(//span[text()='No data found.'])[1]");
	public By Entity_AddEntityPriority = By.xpath("//select[@name='entityPriority']");
	public By TypeOfStep_AddEntityPriority = By.xpath("//select[@name='entityTypeOfStep']");
	public By User_AddEntityPriority = By.xpath("//input[@placeholder='Select Users...']");
	public By Submit_AddEntityPriority = By.xpath("//span[text()='Submit']");
	public By NextBtn_ManageWorkFlow = By.xpath("//span[text()='Next']");
	// Account Details
	public By AccountDetailsTableRows = By.xpath("(//table[@class='table table-hover'])[2]/tbody/tr");
	public By DeleteIcon_AccountDetais = By
			.xpath("(//div[@class='table-container table-responsive'])[last()]//button[@type='button']");
	public By New_AccountDetails = By.xpath("(//span[text()='New'])[4]");
	public By YestBtn_AccountDetails = By.xpath("//span[text()='Yes']");
	public By NoData_AccountDetails = By.xpath("(//span[text()='No data found.'])[1]");
	// Add Account
	public By AccountTypeDrpdwn_AddAccount = By.xpath("//select[@name='accounttypeselect']");
	public By FromDate = By.xpath("//input[@name='fromDate']");
	public By AccountNumber = By.xpath("//input[@name='accountnumbertext']");
	public By BankName = By.xpath("//input[@name='banknametext']");
	public By Address = By.xpath("//input[@placeholder='Enter branch address']");
	public By TowerDrpdwn = By.xpath("(//input[@id='select-state-selectized'])[2]");
	public By SubmitBtn_AddAccount = By.xpath("//span[text()='Submit']/..");
	// Threshold Details
	public By MSP_Margin_of_Tolerance = By.xpath("//input[@name='sptolrancetext']");
	public By Minimum_Advanced_Payment = By.xpath("//input[@name='advancedpaymenttext']");
	public By Margin_of_Tolerance = By.xpath("//input[@name='advancedtolerancetext']");
	public By Threshold_Date = By.xpath("//input[@name='thresholddate']");
	public By Threshold_Type = By.xpath("//select[@name='thresholdtypeselect']");
	public By PriceHeaders = By.xpath("//div[@class='selectize-control select-checkbox multi']");
	public By Average_Price_Calculated_for = By.xpath("//select[@name='averagePriceCalculated']");
	public By Period = By.xpath("//select[@name='period']");
	public By Next = By.xpath("//span[text()='Next']");
	public By Done = By.xpath("//span[text()='Done']");
	//
	public By ShowMyDeliverablesPendingTable = By.xpath("(//span[@class='caption'])[1]");
	public String ShowMyDeliverablesPendingTable_Name = "ShowMyDeliverables";

	public By ApproveAndAuthorizeORCancelNocFirstRowInPendingRequests = By
			.xpath("//span[text()='Approve and Authorize NoC']");
	public String ApproveAndAuthorizeORCancelNocFirstRowInPendingRequests_Name = "ApproveAndAuthorizeORCancelNocFirstRowInPendingRequests";

	public By FinalDecisionTablePendingTable = By.xpath("//select[@name='descisionselect']");
	public String FinalDecisionTablePendingTable_Name = "FinalDecisionTable";
	public By SubmitBtnPendingTable = By.xpath("//span[text()='Submit']");
	public String SubmitBtnPendingTable_Name = "SubmitBtn";

	public String AssertProfile_Menu_Name = "AssertProfile Menu";
	public String NOC_Link_Name = "NOC Link";
	public String Project_Drpdwn_Name = "Project_DrpdwnLink";
	public String ManageProject_Link_Name = "ManageProject Link";
	public String ManageRequest_Link_Name = "ManageRequest_Link";
	// entites
	public String EntitesTableRows_Name = "Entites Table Rows";
	public String DeleteIcon_Entites_Name = "Delete button";
	public String YesBtn_Name = "Yes Button";
	public String NewBtn_Entites_Name = "New Button in Entites";
	public String NoData_Entites_Name = "No Data found text";
	public String Role_Drpdwn_Entites_Name = "Role Dropdown";
	public String Entity_Drpdwn_Entites_Name = "Entity Dropdown";
	public String SubmitBtn_AddEntity_Name = "Submit button";
	// user
	public String UsersTableRows_Name = "Count of user rows";
	public String Role_Drodwn_User_Name = "Role dropdown in user";
	public String Entity_Drpdwn_User_Name = "Entity dropdown in user";
	public String User_Drpdwn_User_Name = "User dropdown in user";
	public String Address_User_Name = "Address in user";
	public String DeleteIcon_Users_Name = "Delete Icon in User";
	public String NewBtn_Users_Name = "New Button in Users";
	public String Ok_btn_Name = "Ok button";
	public String SubmitBtn_User_Name = "Submit Button";
	public String NextBtn_Name = "Next button";
	public String NewBtn_Name = "New Button";
	// add entity priority(Manage WorkFlow)
	public String NoData_ManageWorkFlow_Name = "NoData_ManageWorkFlow";
	public String Entity_AddEntityPriority_Name = "Entity_AddEntityPriority_Name";
	public String TypeOfStep_AddEntityPriority_Name = "TypeOfStep_AddEntityPriority_Name";
	public String User_AddEntityPriority_Name = "User_AddEntityPriority_Name";
	public String Submit_AddEntityPriority_Name = "Submit_AddEntityPriority";
	public String NextBtn_ManageWorkFlow_Name = "NextBtn_ManageWorkFlow";
	// Account Details
	public String AccountDetailsTableRows_Name = "AccountDetailsTableRows";
	public String DeleteIcon_AccountDetais_Name = "DeleteIcon_AccountDetais";
	public String YestBtn_AccountDetails_Name = "YestBtn_AccountDetails";
	public String New_AccountDetails_Name = "New_AccountDetails";
	public String NoData_AccountDetails_Name = "NoData_AccountDetails";
	public String AccountTypeDrpdwn_AddAccount_Name = "AccountTypeDrpdwn_AddAccount";
	public String FromDate_Name = "FromDate";
	public String AccountNumber_Name = "Account Number";
	public String BankName_Name = "Bank Name";
	public String Address_Name = "Address";
	public String TowerDrpdwn_Name = "TowerDrpdwn";
	public String SubmitBtn_AddAccount_Name = "SubmitBtn_AddAccount";
	//
	public String MSP_Margin_of_Tolerance_Name = "MSP_Margin_of_Tolerance";
	public String Minimum_Advanced_Payment_Name = "Minimum_Advanced_Payment";
	public String Margin_of_Tolerance_Name = "Margin_of_Tolerance";
	public String Threshold_Date_Name = "Threshold_Date";
	public String Threshold_Type_Name = "Threshold_Type";
	public String PriceHeaders_Name = "PriceHeaders";
	public String Average_Price_Calculated_for_Name = "Average_Price_Calculated_for";
	public String Period_Name = "Period";
	public String Next_Name = "Next";
	public String Done_Name = "Done";

	public void clickOnAssetProfile() {
		BaseTest.utilObj.get().getUIUtils().clickElement(AssertProfile_Menu_Name, AssertProfile_Menu);
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
	}

	public void clickOnNOCLink() {
		BaseTest.utilObj.get().getUIUtils().clickElement(NOC_Link_Name, NOC_Link);
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
	}

	public void selectProject() {
		BaseTest.utilObj.get().getUIUtils().selectValue(Project_Drpdwn_Name, Project_Drpdwn, "Text",
				"Asset TestPerform");
	}

	public void clickOnManageProject() {
		BaseTest.utilObj.get().getUIUtils().clickElement(ManageProject_Link_Name, ManageProject_Link);
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
	}

	// Entites Section
	public void deleteAndAddEntites() {
		try {
			int row_count = BaseTest.utilObj.get().getUIUtils().countOfRows(EntitesTableRows_Name, EntitesTableRows);
			System.out.println("entites row count is = " + row_count);
			if (row_count > 0) {
				for (int i = 0; i < row_count; i++) {
					BaseTest.utilObj.get().getUIUtils().clickElement(DeleteIcon_Entites_Name, DeleteIcon_Entites);
					// BaseTest.utilObj.get().getUIUtils().switchToAlertAndAccept();
					BaseTest.utilObj.get().getUIUtils().clickElement(YesBtn_Name, YesBtn);
				}
			} else {
				BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Entites_Name, NewBtn_Entites);
			}
		} catch (Exception e) {

		}
		try {
			if (BaseTest.utilObj.get().getUIUtils().isDisplayed(NoData_Entites)) {
				BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Entites_Name, NewBtn_Entites);
				addEntites("Developer", "Borrower A");
				BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Entites_Name, NewBtn_Entites);
				addEntites("PMC", "PMC demo");
				BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Entites_Name, NewBtn_Entites);
				addEntites("Investor", "Lender A");
				BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Entites_Name, NewBtn_Entites);
				addEntites("Debenture", "Independent Trustee Services");
			}

		} catch (Exception e) {

		}
	}

	// Users Section
	public void deleteAndAddUsers() throws InterruptedException {
		if (BaseTest.utilObj.get().getUIUtils().isDisplayed(NoData_User)) {
			Thread.sleep(4000);
			BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Users_Name, NewBtn_Users);
			addUsers("Developer", "Borrower A", "Test 1", "Hyderabad");
			BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Users_Name, NewBtn_Users);
			addUsers("PMC", "PMC demo", "Approver1 test", "Hyderabad");
			BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Users_Name, NewBtn_Users);
			addUsers("Investor", "Lender A", "Test 2", "Hyderabad");
			BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Users_Name, NewBtn_Users);
			addUsers("Debenture", "Independent Trustee Services", "Test 3", "Hyderabad");
		}

		BaseTest.utilObj.get().getUIUtils().clickElement(NextBtn_Name, NextBtn);
		if (BaseTest.utilObj.get().getUIUtils().isDisplayed(NoData_ManageWorkFlow)) {
			BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Name, NewBtn);
			addEntityPriority("Borrower A", "Select type of step", "test1@truboardpartners.com");
			BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Name, NewBtn);
			addEntityPriority("PMC demo", "Recommender", "approver1.test@truboardpartners.com");
			BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Name, NewBtn);
			addEntityPriority("Lender A", "Approver", "test2@truboardpartners.com");
			BaseTest.utilObj.get().getUIUtils().clickElement(NewBtn_Name, NewBtn);
			addEntityPriority("Independent Trustee Services", "Approver", "test3@truboardpartners.com");
		}

		BaseTest.utilObj.get().getUIUtils().clickElement(NextBtn_ManageWorkFlow_Name, NextBtn_ManageWorkFlow);
		Thread.sleep(5000);
		try {
			int countOfRows_AccountDetails = BaseTest.utilObj.get().getUIUtils()
					.countOfRows(AccountDetailsTableRows_Name, AccountDetailsTableRows);
			System.out.println("No of rows in AccountDetails Table= " + countOfRows_AccountDetails);
			if (countOfRows_AccountDetails > 0) {
				for (int i = 0; i < countOfRows_AccountDetails; i++) {
					Thread.sleep(2000);
					BaseTest.utilObj.get().getUIUtils().clickElement(DeleteIcon_AccountDetais_Name,
							DeleteIcon_AccountDetais);
					BaseTest.utilObj.get().getUIUtils().clickElement(YestBtn_AccountDetails_Name,
							YestBtn_AccountDetails);
				}

			}
		} catch (Exception e) {

		}
	}

	// Account Details
	public void addAccountDetails() {
		if (BaseTest.utilObj.get().getUIUtils().isDisplayed(NoData_AccountDetails)) {
			BaseTest.utilObj.get().getUIUtils().clickElement(New_AccountDetails_Name, New_AccountDetails);
			BaseTest.utilObj.get().getUIUtils().selectValue(AccountTypeDrpdwn_AddAccount_Name,
					AccountTypeDrpdwn_AddAccount, "Text", "Master Collection");
			BaseTest.utilObj.get().getUIUtils().inputText(FromDate_Name, FromDate, "Nov 4, 2023");
			BaseTest.utilObj.get().getUIUtils().inputText(AccountNumber_Name, AccountNumber, "1234567890");
			BaseTest.utilObj.get().getUIUtils().inputText(BankName_Name, BankName, "HDFC");
			BaseTest.utilObj.get().getUIUtils().inputText(Address_Name, Address, "Hyd");
			// BaseTest.utilObj.get().getUIUtils().clickElement(TowerDrpdwn_Name,
			// TowerDrpdwn);
			BaseTest.utilObj.get().getUIUtils().inputTextUsingActionClassClick(TowerDrpdwn_Name, TowerDrpdwn,
					"Tower A");
			BaseTest.utilObj.get().getUIUtils().inputTextUsingActionClassClick(TowerDrpdwn_Name, TowerDrpdwn,
					"Tower B");
			BaseTest.utilObj.get().getUIUtils().clickElement(SubmitBtn_AddAccount_Name, SubmitBtn_AddAccount);
		}
	}

	// Threshold Details
	public void AddThresholdDetails() throws InterruptedException {
		BaseTest.utilObj.get().getUIUtils().clearAndEnterText(MSP_Margin_of_Tolerance_Name, MSP_Margin_of_Tolerance,
				"10");
		BaseTest.utilObj.get().getUIUtils().clearAndEnterText(Minimum_Advanced_Payment_Name, Minimum_Advanced_Payment,
				"10");
		BaseTest.utilObj.get().getUIUtils().clearAndEnterText(Margin_of_Tolerance_Name, Margin_of_Tolerance, "10");
		BaseTest.utilObj.get().getUIUtils().inputText(Threshold_Date_Name, Threshold_Date, "Nov 4, 2023");
		BaseTest.utilObj.get().getUIUtils().selectValue(Threshold_Type_Name, Threshold_Type, "Text", "Sanction Date");

		BaseTest.utilObj.get().getUIUtils().inputTextUsingActionClassClick(PriceHeaders_Name, PriceHeaders,
				"Other charges (Exlcuding pass thorugh and deposit, Taxes)");
		BaseTest.utilObj.get().getUIUtils().inputTextUsingActionClassClick(PriceHeaders_Name, PriceHeaders, "Tax");
		Thread.sleep(3000);
		BaseTest.utilObj.get().getUIUtils().selectValue(Average_Price_Calculated_for_Name, Average_Price_Calculated_for,
				"Text", "Project");
		BaseTest.utilObj.get().getUIUtils().selectValue(Period_Name, Period, "Text", "3");
		BaseTest.utilObj.get().getUIUtils().clickElement(Next_Name, Next);
		BaseTest.utilObj.get().getUIUtils().clickElement(Done_Name, Done);
	}

	public void clickOnManageRequest() {
		BaseTest.utilObj.get().getUIUtils().clickElement(ManageRequest_Link_Name, ManageRequest_Link);
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
	}

	// pending table
	public void clickOnShowMyDeliverables_CheckBoxPendingTable() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		BaseTest.utilObj.get().getUIUtils().clickElement(ShowMyDeliverablesPendingTable_Name,
				ShowMyDeliverablesPendingTable);
	}

	public void clickOnApproveAndAuthorizeOrCancelNocBtn() {
		BaseTest.utilObj.get().getUIUtils().clickElement(ApproveAndAuthorizeORCancelNocFirstRowInPendingRequests_Name,
				ApproveAndAuthorizeORCancelNocFirstRowInPendingRequests);
	}

	public void selectValueFromFinalDecisionTable(String projectName) {
		BaseTest.utilObj.get().getUIUtils().selectValue(FinalDecisionTablePendingTable_Name,
				FinalDecisionTablePendingTable, "Text", projectName);
	}

	public void clickOnSubmitBtn() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().clickElement(SubmitBtnPendingTable_Name, SubmitBtnPendingTable);
	}

	public By SelectFieldPendingTable = By.xpath("(//select[@name='wm-datatable'])[1]");
	public String SelectFieldPendingTable_Name = "SelectFieldPendingTable";

	public void selectValueFromeSelectFieldPendingTable() {
		BaseTest.utilObj.get().getUIUtils().selectValue(SelectFieldPendingTable_Name, SelectFieldPendingTable, "Text",
				"Unit");
	}

	public By SearchPendingTable = By.xpath("(//input[@placeholder='Search'])[1]");
	public String SearchPendingTable_Name = "SearchPendingTable";

	public void enterValueInSearchPendingTable() {
		String no = Developer_Page.UNo;
		BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(SearchPendingTable_Name, SearchPendingTable, no,
				Keys.ENTER);
	}

	public void enterValueInSearchPendingTableForCancel() {
		BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(SearchPendingTable_Name, SearchPendingTable,
				TestConfig.getInstance().getUnitNumber(), Keys.ENTER);
	}

	public By UnitNosPendingTable = By.xpath("(//table[@class='table table-hover table-condensed'])[1]/tbody/tr/td[1]//label");
	public String UnitNosPendingTable_Name = "UnitNosPendingTable";

	public void verificationOnPendingTable() {
		String no = Developer_Page.UNo;
		List<WebElement> elements = BaseTest.utilObj.get().getUIUtils().findElements(UnitNosPendingTable_Name,
				UnitNosPendingTable, TestConfig.getInstance().getOBJWAITTIME());
		for (WebElement element : elements) {
			String text = element.getText();
			if (text.equals(no)) {
				System.out.println("text=" + text);
				System.out.println("no=" + no);
				System.out.println("we got unit no in pending table");
				Assert.assertEquals(text, no);
				;
			}
		}
	}

	public By Remarks = By.xpath("(//input[@placeholder='Enter your remark'])[last()]");
	public String Remarks_Name = "Remarks";

	public void enterRemarksFeild() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().inputText(Remarks_Name, Remarks, "Incorrect documents ");
	}

	public By successMsgForRejectNoc = By.xpath("//div[text()='NOC rejected successfully']");
	public String successMsgForRejectNoc_Name = "successMsgForRejectNoc";

	public void successMsgForRejectNoc() {
		String expectedText = BaseTest.utilObj.get().getUIUtils().getText(successMsgForRejectNoc_Name,
				successMsgForRejectNoc);
		String actualText = "NOC rejected successfully";
		if (expectedText.equals(actualText)) {
			Assert.assertTrue(true);
		} else {
			Assert.fail();
		}
	}

	// Hold Request table in Investor
	public By ShowMyDeliverablesHoldTable = By.xpath("(//span[@class='caption'])[2]");
	public String ShowMyDeliverablesHoldTable_Name = "ShowMyDeliverables";
	public void clickOnShowMyDeliverables_CheckBoxHoldTable() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		BaseTest.utilObj.get().getUIUtils().clickElement(ShowMyDeliverablesHoldTable_Name, ShowMyDeliverablesHoldTable);
	}
	
	public By SelectFieldHoldTable = By.xpath("(//select[@name='wm-datatable'])[2]");
	public String SelectFieldHoldTable_Name = "SelectFieldHoldTable";

	public void selectValueFromeSelectFieldHoldTable() {
		BaseTest.utilObj.get().getUIUtils().selectValue(SelectFieldHoldTable_Name, SelectFieldHoldTable, "Text",
				"Unit");
	}

	public By SearchHoldTable = By.xpath("(//input[@placeholder='Search'])[2]");
	public String SearchHoldTable_Name = "SearchPendingTable";

	public void enterValueInSearchHoldTable() {
		String no = Developer_Page.UNo;
		BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(SearchHoldTable_Name, SearchHoldTable, no, Keys.ENTER);
	}

	public void enterValueInSearchHoldTableForCancel() {
		BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(SearchHoldTable_Name, SearchHoldTable,
				TestConfig.getInstance().getUnitNumber(), Keys.ENTER);
	}

	public By UnitNosHoldTable = By.xpath("(//table[@class='table table-hover'])[2]/tbody/tr/td[1]");
	public String UnitNosHoldTable_Name = "UnitNosHoldTable";

	public void verificationOnHoldTable() {
		String no = TestConfig.getInstance().getUnitNumber();
		System.out.println("no=" + no);
		List<WebElement> elements = BaseTest.utilObj.get().getUIUtils().findElements(UnitNosHoldTable_Name,
				UnitNosHoldTable, TestConfig.getInstance().getOBJWAITTIME());
		for (WebElement element : elements) {
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			String text = element.getText();
			if (text.equals(no)) {
				System.out.println("text=" + text);
				System.out.println("no=" + no);
				System.out.println("we got unit no in Hold table");
				Assert.assertEquals(text, no);
			}
			else {
				Assert.fail();
			}
		}
	}

	public void addEntites(String role, String entity) {
		BaseTest.utilObj.get().getUIUtils().selectValue(Role_Drpdwn_Entites_Name, Role_Drpdwn_Entites, "Text", role);
		BaseTest.utilObj.get().getUIUtils().selectValue(Entity_Drpdwn_Entites_Name, Entity_Drpdwn_Entites, "Text",
				entity);
		BaseTest.utilObj.get().getUIUtils().clickElement(SubmitBtn_AddEntity_Name, SubmitBtn_AddEntity);
	}

	public void addUsers(String role, String entity, String user, String address) {
		BaseTest.utilObj.get().getUIUtils().selectValue(Role_Drodwn_User_Name, Role_Drodwn_User, "Text", role);
		BaseTest.utilObj.get().getUIUtils().selectValue(Entity_Drpdwn_User_Name, Entity_Drpdwn_User, "Text", entity);
		BaseTest.utilObj.get().getUIUtils().selectValue(User_Drpdwn_User_Name, User_Drpdwn_User, "Text", user);
		BaseTest.utilObj.get().getUIUtils().inputText(Address_User_Name, Address_User, address);
		BaseTest.utilObj.get().getUIUtils().clickElement(SubmitBtn_User_Name, SubmitBtn_User);
	}

	public void addEntityPriority(String entity, String typeofview, String user) {
		BaseTest.utilObj.get().getUIUtils().selectValue(Entity_AddEntityPriority_Name, Entity_AddEntityPriority, "Text",
				entity);
		BaseTest.utilObj.get().getUIUtils().selectValue(TypeOfStep_AddEntityPriority_Name, TypeOfStep_AddEntityPriority,
				"Text", typeofview);
		BaseTest.utilObj.get().getUIUtils().inputTextUsingActionClassClick(User_AddEntityPriority_Name,
				User_AddEntityPriority, user);
		BaseTest.utilObj.get().getUIUtils().clickElement(Submit_AddEntityPriority_Name, Submit_AddEntityPriority);
	}
	
	public By successMsgForApproveNoc=By.xpath("//div[text()='NOC authorize successfully']");
	public String successMsgForApproveNoc_Name="successMsgForApproveNoc";
	public void successMsgForApproveNoc() {
		String expectedText=BaseTest.utilObj.get().getUIUtils().getText(successMsgForApproveNoc_Name, successMsgForApproveNoc);
		String actualText="NOC authorize successfully";
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		if(expectedText.equals(actualText)) {
			Assert.assertTrue(true);
			System.out.println("actualText= "+actualText);
			System.out.println("expectedText= "+expectedText);
		}else {
			Assert.fail();
		}
	}

}

package com.truboardpartners.pageClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;
import com.truboard.utils.CommonUtils;
import com.truboardpartners.classes.SmokeDeveloper;

import junit.framework.Assert;

public class Invester_Page {
	public By AssertProfile_Menu=By.xpath("//span[text()='Asset Profile']");
	public By NOC_Link=By.xpath("//span[text()='NOC']");
	public By Project_Drpdwn=By.xpath("//select[@name='select1']");
	public By ManageRequest_Link=By.xpath("//span[text()='Manage Request']");
	public By ShowMyDeliverablesPendingTable=By.xpath("(//span[@class='caption'])[1]");
	public By ApproveAndAuthorizeBtnFirstRowInPendingRequests=By.xpath("((//table[@class='table table-hover'])[1]//tbody/tr)[1]/td[8]/span");
	public By FinalDecisionTable=By.xpath("//select[@name='descisionselect']");
	public By Download_Btn=By.xpath("//span[text()='Download']");
	public By Upload=By.xpath("//button//span[text()='Upload']");
	public By SubmitBtn=By.xpath("//span[text()='Submit']");
	public By ApproveAndAuthorizeORCancelNocFirstRowInPendingRequests=By.xpath("//span[text()='Approve and Authorize NoC']");
	
	
	public String AssertProfile_Menu_Name="AssertProfile Menu";
	public String NOC_Link_Name="NOC Link";
	public String Project_Drpdwn_Name="Project_DrpdwnLink"; 
	public String ManageRequest_Link_Name="ManageRequest_Link";
	public String ShowMyDeliverablesPendingTable_Name="ShowMyDeliverables";
	public String ApproveAndAuthorizeBtnFirstRowInPendingRequests_Name="ApproveAndAuthorizeBtnFirstRowInPendingRequests";
	public String FinalDecisionTable_Name="FinalDecisionTable";
	public String Download_Btn_Name="Download_Btn";
	public String Upload_Name="Upload";
	public String SubmitBtn_Name="SubmitBtn";
	public String ApproveAndAuthorizeORCancelNocFirstRowInPendingRequests_Name="ApproveAndAuthorizeORCancelNocFirstRowInPendingRequests";
	
	public void clickOnAssetProfile() {
		BaseTest.utilObj.get().getUIUtils().clickElement(AssertProfile_Menu_Name, AssertProfile_Menu);
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
	}
	
	public void clickOnNOCLink() {
		BaseTest.utilObj.get().getUIUtils().clickElement(NOC_Link_Name, NOC_Link);
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
	}
	
	public void selectProject() {
		BaseTest.utilObj.get().getUIUtils().selectValue(Project_Drpdwn_Name, Project_Drpdwn, "Text", "Asset TestPerform");
	}
	
	public void clickOnManageRequest() {
		BaseTest.utilObj.get().getUIUtils().clickElement(ManageRequest_Link_Name, ManageRequest_Link);
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
	}
	
	public void clickOnShowMyDeliverables_CheckBoxPendingTable() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		BaseTest.utilObj.get().getUIUtils().clickElement(ShowMyDeliverablesPendingTable_Name, ShowMyDeliverablesPendingTable);
	}
	
	public void clickOnApproveAndAuthorizeBtn() {
		BaseTest.utilObj.get().getUIUtils().clickElement(ApproveAndAuthorizeBtnFirstRowInPendingRequests_Name, ApproveAndAuthorizeBtnFirstRowInPendingRequests);
	}
	
	public void selectValueFromFinalDecisionTable(String value) {
		BaseTest.utilObj.get().getUIUtils().selectValue(FinalDecisionTable_Name, FinalDecisionTable, "Text", value);
	}
	
	public void clickOnDownload_Btn() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().clickElement(Download_Btn_Name, Download_Btn);
	}
	
	public void uploadDocument() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(8);
		String downloadedSignatureFile = CommonUtils.getLastModifiedFilePath("C:\\Users\\Admin\\Downloads");
		String expectedFileName = downloadedSignatureFile.replace("C:\\Users\\Admin\\Downloads\\", "");
		System.out.println("expectedFileName:" + expectedFileName);
		BaseTest.utilObj.get().getUIUtils().clickElementUsingAction(Upload_Name, Upload);
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().uploadFile(downloadedSignatureFile);
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
	}
	
	public void clickOnSubmitBtn() {
		BaseTest.utilObj.get().getUIUtils().clickElement(SubmitBtn_Name, SubmitBtn);
	}
	public void clickOnApproveAndAuthorizeOrCancelNocBtn() {
		BaseTest.utilObj.get().getUIUtils().clickElement(ApproveAndAuthorizeORCancelNocFirstRowInPendingRequests_Name, ApproveAndAuthorizeORCancelNocFirstRowInPendingRequests);
	}
	
	public By SelectFieldPendingTable=By.xpath("(//select[@name='wm-datatable'])[1]");
	public String SelectFieldPendingTable_Name="SelectFieldPendingTable";
	public void selectValueFromeSelectFieldPendingTable() {
		BaseTest.utilObj.get().getUIUtils().selectValue(SelectFieldPendingTable_Name, SelectFieldPendingTable, "Text", "Unit");
	}
	public By SearchPendingTable=By.xpath("(//input[@placeholder='Search'])[1]");
	public String SearchPendingTable_Name="SearchPendingTable";
	public void enterValueInSearchPendingTable() {
		String no=Developer_Page.UNo;
		BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(SearchPendingTable_Name, SearchPendingTable, no, Keys.ENTER);
	}
	public void enterValueInSearchPendingTableForCancel() {
		BaseTest.utilObj.get().getUIUtils().inputTextwithKeys(SearchPendingTable_Name, SearchPendingTable, TestConfig.getInstance().getUnitNumber(), Keys.ENTER);
	}
	public By UnitNosPendingTable=By.xpath("(//table[@class='table table-hover table-condensed'])[1]/tbody/tr/td[1]//label");
	public String UnitNosPendingTable_Name="UnitNosPendingTable";
	public void verificationOnPendingTable() {
		String no=Developer_Page.UNo;
		List<WebElement> elements=	BaseTest.utilObj.get().getUIUtils().findElements(UnitNosPendingTable_Name, UnitNosPendingTable, TestConfig.getInstance().getOBJWAITTIME());
		for(WebElement element : elements) {
			String text=element.getText();
			if(text.equals(no)) {
				System.out.println("text="+text);
				System.out.println("no="+no);
				System.out.println("we got unit no in pending table");
				Assert.assertEquals(text, no);;
			}
		}
	}
	public By Remarks = By.xpath("(//input[@placeholder='Enter your remark'])[last()]");
	public String Remarks_Name="Remarks";
	public void enterRemarksFeild() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		BaseTest.utilObj.get().getUIUtils().inputText(Remarks_Name, Remarks,"Incorrect documents ");
	}
	
	
	public By SendBackToBtn=By.xpath("//span[text()='Send Back to']");
	public String SendBackToBtn_Name="SendBackToBtn";
	public void clickOnSendBackToBtn() {
		BaseTest.utilObj.get().getUIUtils().clickElement(SendBackToBtn_Name, SendBackToBtn);
	}
	
	public By SendBackToPMCRow=By.xpath("(//table[@class='table table-hover'])[2]/tbody/tr/td[text()='PMC']/..");
	public String SendBackToPMCRow_Name="SendBackToPMCRow";
	public void clickOnSendBackToPMCRow() {
		BaseTest.utilObj.get().getUIUtils().clickElement(SendBackToPMCRow_Name, SendBackToPMCRow);
	}
	
	public By SendBackToDeveloperRow=By.xpath("(//table[@class='table table-hover'])[2]/tbody/tr/td[text()='Developer']/..");
	public String SendBackToDeveloperRow_Name="SendBackToDeveloperRow";
	public void clickOnSendBackToDeveloperRow() {
		BaseTest.utilObj.get().getUIUtils().clickElement(SendBackToDeveloperRow_Name, SendBackToDeveloperRow);
	}
	
	public By SubmitBtn_SendBackTo=By.xpath("(//span[text()='Submit'])[2]");
	public String SubmitBtn_SendBackTo_Name="SubmitBtn_SendBackTo";
	public void clickOnSubmitBtn_SendBackTo() {
		BaseTest.utilObj.get().getUIUtils().clickElement(SubmitBtn_SendBackTo_Name, SubmitBtn_SendBackTo);
	}
	public By RemarksHold=By.xpath("//input[@name='descisionremarktext']");
	public String RemarksHold_Name="RemarksHold";
	public void enterRemarks_Hold() {
		BaseTest.utilObj.get().getUIUtils().inputText(RemarksHold_Name, RemarksHold, "test");
	}
	
	public By successMsgForRejectNoc=By.xpath("//div[text()='NOC rejected successfully']");
	public String successMsgForRejectNoc_Name="successMsgForRejectNoc";
	public void successMsgForRejectNoc() {
		String expectedText=BaseTest.utilObj.get().getUIUtils().getText(successMsgForRejectNoc_Name, successMsgForRejectNoc);
		System.out.println("expected text is= "+expectedText);
		String actualText="NOC rejected successfully";
		System.out.println("actualText is= "+actualText);
		if(expectedText.equals(actualText)) {
			Assert.assertTrue(true);
		}else {
			Assert.fail();
		}
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

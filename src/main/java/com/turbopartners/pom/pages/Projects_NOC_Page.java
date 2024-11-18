package com.turbopartners.pom.pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.truboard.framework.BaseTest;

public class Projects_NOC_Page extends BaseTest {

	public By search_proj = By.xpath("//input[@class='form-control app-textbox']");
	//public By Project_Name_Txt = By.xpath("//input[@id='myInput']");
	//public By search_click = By.xpath("//button[@class='app-search-button']//i");
	public By View_Req = By.xpath("//button[@title='View Request']");
	public By Noc_Req = By.xpath("//a[@name='anchor2']");
	public By requestNOCBtn = By.xpath("//button[@caption='Request NOC']");
	public By unitNoTxt = By.xpath("//input[@id='myInput']");
	public By dateOfBookingROTxt = By.xpath("//button[contains(@aria-label,'Change Date ')]");
	public By purchaser_NameROTxt = By.xpath("//input[@name='purchasertext']");
	public By purchaser_ProfileTxt = By.xpath("//input[@name='purchaserprofiletext']");
	public By purchaser_ConiderationTxt = By.xpath("//input[@name='purchaseconsiderationtext']");
	public By payment_ReceivedTillDateTxt = By.xpath("//input[@name='advancedpaymenttext']");
	public By realised_PriceROTxt = By.xpath("//input[@name='realisedpricetext']");
	public By financer_Txt = By.xpath("//input[@name='financertext']");
	public By remark_Txt = By.xpath("//input[@name='remarktxt']");
	//public By paginationBtn=By.xpath("//li/a/span[text()='Go to Next page ']/..");
	public By paginationBtn = By.xpath("//pagination[contains(@aria-label,'Showing Page')]/descendant::span[text()='Go to Next page ']");
	public By uploadBank_StatementEle = By.xpath("//button[@title='Upload Bank Statement']");
	public By searchField = By.xpath("//option[text()='Select Field']");
	public String searchField_Name = "Search Field in Projects";
	public By searchFiledBox = By.xpath("//select[@name='wm-datatable']");
	public String searchFiledBox_Name = "Search Bar Field";
	//public By paginationBtn=By.xpath("//li/a/span[text()='Go to Next page ']/..");
	public By uploadLedgerEle_1 = By.xpath("//*[@caption='Upload ledger']//*[contains(@class,'sl-cloud-upload')]");
	public By verifyBtn_1 = By.xpath("//button[@title='Verify Payment']");
	public By downloadDigitallySignedLetterEle_1 = By.xpath("//button[@name='digitalisignbutton']");
	public By uploadSignedRequestLetterEle_1 = By.xpath("//input[@name='financertext']");
	public By download_WS = By.xpath("//span[normalize-space()='Download']");
	//public By uploadedSignedRequestFileNameLbl = By.xpath("(//input[@class='file-input'])[2]");
	public By uploadedSignedRequestFileNameLbl = By.xpath("//button//span[text()='Upload']");
	public By submitBtn = By.xpath("//button[@caption='Submit']");
	public By YesBtn = By.xpath("//span[normalize-space()='YES']");
	//public By toastMsgEle = By.xpath("//div[@class='toast-message']");
	public By logoffLnk = By.xpath("//span[@class='anchor-caption' and text()='Logout']");
	
	
	
	
	
	
	public String searchproj = "Select Project Name";
	public String projectname = "Enter Project Name";
	public String search = "click search";
	public String viewrequest = "NA";
	public String nocrequest = "Noc Request";
	public String requestNOCBtn_Name = "Request NOC Btn";
	public String unitNoTxt_Name = "unit No Txt field";
	public String dateOfBookingROTxt_Name = "Date Of Booking RO txt field";
	public String purchaser_NameROTxt_Name = "Purchaser Name RO txt field";
	public String purchaser_ProfileTxt_Name = "Purchaser Profile Txt field";
	public String purchaser_ConiderationTxt_Name = "Purchaser Conideration txt field";
	public String payment_ReceivedTillDateTxt_Name = "Payment Received Till Date txt field";
	public String realised_PriceROTxt_Name = "Realised Price RO txt field";
	public String financer_Txt_Name = "Financer txt field";
	public String remark_Txt_Name = "Remarks txt field";
	public String paginationBtn_Name = "Arrow button";
	public String uploadBank_StatementEle_Name = "Upload Bank Statement link"; 
	public String uploadLedgerEle_Name_1 = "Upload Ledger link";
	public String verifyBtn_Name_1 = "Verify btn";
	public String downloadDigitallySignedLetterEle_Name = "Download Digitally Signed Letter link";
	public String uploadSignatirePopupEle_Name_1 = "Upload Signature button popup";
	public String downloadws = "Downloaded successfully";
	public String uploadedSignedRequestFileNameLbl_Name = "Uploaded Signed Request File Name Label";
	public String submitBtn_Name = "Submit btn";
	public String YesBtn_Name = "Do You Want Continue Yes Button";
	//public String toastMsgEle_Name = "ToastMessage after NOC Submit";
	public String logoffLnk_Name = "Logged of Successfully";



	
	
	

	LoginPage page = new LoginPage();



public void login() {
	page.loginDeveloper(viewrequest, nocrequest);
}



public boolean getPaymentVerfiedStatusAtLeastOneRow() {
	// TODO Auto-generated method stub
	return false;
}


//	
//	public Projects_NOC_Page clickNOCRequest()
//	{
//		BaseTest.utilObj.get().getUIUtils().clickElement(nocrequest, Noc_Req);
//		
//		return this;
//	}
//	public Projects_NOC_Page clickOnEyeIcon()
//	{
//		BaseTest.utilObj.get().getUIUtils().clickElement(viewrequest, View_Req);
//		
//		return this;
//	}
}

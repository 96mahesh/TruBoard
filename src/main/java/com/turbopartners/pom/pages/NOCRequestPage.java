package com.turbopartners.pom.pages;

import org.openqa.selenium.By;

import com.truboard.framework.BaseTest;

public class NOCRequestPage {
	
	public By requestNOCBtn = By.xpath("//button[@caption='Request NOC']"); //Relative 
	public By projectSelectDD = By.xpath("//select[@name='projectselect']");
	public By unitNoTxt = By.xpath("//input[@id='myInput']");
	public By unitNoList = By.xpath("//div[@id='myInputautocomplete-list']");
	public By dateOfBookingROTxt = By.xpath("//button[contains(@aria-label,'Change Date ')]");
	public By towerROTxt = By.xpath("//input[@name='towertxt']");
	public By floorROTxt = By.xpath("//input[@name='floortext']");
	public By wingROTxt = By.xpath("//input[@name='wingtext']");
	//Approval Status;
	//Mortgage Status;
	public By saleableAreaSqftROTxt = By.xpath("//input[@name='saleabletext']");
	public By purchaserNameROTxt = By.xpath("//input[@name='purchasertext']");
	public By purchaserProfileTxt = By.xpath("//input[@name='purchaserprofiletext']");
	public By purchaserConiderationTxt = By.xpath("//input[@name='purchaseconsiderationtext']");
	public By paymentReceivedTillDateTxt = By.xpath("//input[@name='advancedpaymenttext']");
	public By realisedPriceROTxt = By.xpath("//input[@name='realisedpricetext']");
	public By financerTxt = By.xpath("//input[@name='financertext']");
	public By remarkTxt = By.xpath("//input[@name='remarktxt']");
	public By bankSelectDD = By.xpath("//select[@name='bankselect']");
	public By uploadBankStatementEle = By.xpath("//div[@caption='Upload bank statement']//*[contains(@class,'sl-cloud-upload')]");
	public By uploadedBankFileLbl = By.xpath("(//label[@class='upload-title'])[1]");
	public By uploadLedgerEle = By.xpath("//*[@caption='Upload ledger']//*[contains(@class,'sl-cloud-upload')]");
	//public By uploadLedgerEle = By.xpath("(//input[@name='files'])[2]");
	public By uploadedLedgerFileLbl = By.xpath("(//label[@class='upload-title'])[2]");
	public By verifyBtn = By.xpath("//button[@title='Verify Payment']");
	public By downloadDigitallySignedLetterEle = By.xpath("//button[@name='digitalisignbutton']");
	public By uploadSignatirePopupEle = By.xpath("(//input[@name='files'])[4]");
	//public By uploadSignatirePopupEle = By.xpath("//(//button[@id='dropzone'])[3]");
	public By digitalSignatureSubmitBtn = By.xpath("//button[@name='uploadsignbutton']");
	//public By uploadSignedRequestLetterEle = By.xpath("(//input[@name='files'])[3]");
	public By uploadSignedRequestLetterEle = By.xpath("(//button[@id='dropzone'])[2]/*[contains(@class,'sl-cloud-upload')]");
	//(//button[@id='dropzone'])[2]/*[contains(@class,'sl-cloud-upload')]
	public By uploadedSignedRequestFileNameLbl = By.xpath("(//label[@class='upload-title'])[3]");
	public By submitBtn = By.xpath("//button[@caption='Submit']");
	public By doYouWantContinueYesBtn = By.xpath("//button[@aria-label='Submit button']");
	public By toastMsgEle = By.xpath("//div[@class='toast-message']");
	public By logoffLnk = By.xpath("//span[text()='Logout']");
	
	public String pageTitle = "NA";
	public String requestNOCBtn_Name = "Request NOC Btn";
	public String projectSelectDD_Name = "Project Select dropdown";
	public String unitNoTxt_Name = "unit No Txt field";
	public String unitNoList_Name = "unit No List populated after entering some text in Unit no";
	public String dateOfBookingROTxt_Name = "Date Of Booking RO txt field";
	public String towerROTxt_Name = "Tower RO txt field";
	public String floorROTxt_Name = "Floor RO txt field";
	public String wingROTxt_Name = "Wing RO txt field";
	public String saleableAreaSqftROTxt_Name = "Saleable Area Sqft RO txt field";
	public String purchaserNameROTxt_Name = "Purchaser Name RO txt field";
	public String purchaserProfileTxt_Name = "Purchaser Profile Txt field";
	public String purchaserConiderationTxt_Name = "Purchaser Conideration txt field";
	public String paymentReceivedTillDateTxt_Name = "Payment Received Till Date txt field";
	public String realisedPriceROTxt_Name = "Realised Price RO txt field";
	public String financerTxt_Name = "Financer txt field";
	public String remarkTxt_Name = "Remarks txt field";
	public String bankSelectDD_Name = "Select Bank dropdown";
	public String uploadBankStatementEle_Name = "Upload Bank Statement link";
	public String uploadedBankFileLbl_Name = "Uploaded Bank File Name Label";
	public String uploadLedgerEle_Name = "Upload Ledger link";
	public String uploadedLedgerFileLbl_Name = "Uploaded Ledger File Name Label";
	public String verifyBtn_Name = "Verify btn";
	public String downloadDigitallySignedLetterEle_Name = "Download Digitally Signed Letter link";
	public String uploadSignatirePopupEle_Name = "Upload Signature button popup";
	public String digitalSignatureSubmitBtn_Name = "Digital Signature popup Submit Button";
	public String uploadSignedRequestLetterEle_Name = "Ppload Signed Request Letter button";
	public String uploadedSignedRequestFileNameLbl_Name = "Uploaded Signed Request File Name Label";
	public String submitBtn_Name = "Submit btn";
	public String doYouWantContinueYesBtn_Name = "Do You Want Continue Yes Button";
	public String toastMsgEle_Name = "ToastMessage after NOC Submit";
	public String logoffLnk_Name = "Logoff link";
	
	public boolean getSuccessfulSelectionOfTower() {
		boolean flag = false;
		String purchaserName = "";
		String dateofBooking = "";
		String tower = "";
		String floor = "";
		String wing = "";
		String saleablAreaSqft = "";
		try {
			BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "Going to get successful selection of Tower", false);
			BaseTest.utilObj.get().getUIUtils().inputText(unitNoTxt_Name, unitNoTxt, "tower C-C");
			BaseTest.utilObj.get().getUIUtils().objWait("",By.xpath("//div[@id='myInputautocomplete-list']"), "90", true);
			int numberOfTower = BaseTest.driver.get().findElements(By.xpath("//div[@id='myInputautocomplete-list']/div")).size();
			
			for(int i=1; i<=numberOfTower; i++) {
				BaseTest.utilObj.get().getUIUtils().clickElement("Tower Select from auto list-"+i, By.xpath("(//div[@id='myInputautocomplete-list']/div)["+i+"]"));
				BaseTest.utilObj.get().getUIUtils().waitForSec(5);
				purchaserName = BaseTest.utilObj.get().getUIUtils().getText(purchaserNameROTxt_Name, purchaserNameROTxt, false);
				System.out.println("purchaserName:"+purchaserName);
				if(! purchaserName.trim().equals("")) {
					//dateofBooking = BaseTest.utilObj.get().getUIUtils().getText(dateOfBookingROTxt_Name, dateOfBookingROTxt, false);
					dateofBooking = BaseTest.driver.get().findElement(dateOfBookingROTxt).getAttribute("aria-label");
					dateofBooking = dateofBooking.replace("Change Date ", "");
					System.out.println("dateofBooking:"+dateofBooking);
					tower = BaseTest.utilObj.get().getUIUtils().getText(towerROTxt_Name, towerROTxt, false);
					
					System.out.println("tower:"+tower);
					//floor = BaseTest.utilObj.get().getUIUtils().getText(floorROTxt_Name, floorROTxt, false);
					//System.out.println("floor:"+floor);
					//wing = BaseTest.utilObj.get().getUIUtils().getText(wingROTxt_Name, wingROTxt, false);
					//System.out.println("wing:"+wing);
					flag = true;
					break;
				}
				BaseTest.utilObj.get().getUIUtils().inputText(unitNoTxt_Name, unitNoTxt, "tower C-C");
				BaseTest.utilObj.get().getUIUtils().objWait("Unit auto list",By.xpath("//div[@id='myInputautocomplete-list']"), "90", true);
				//BaseTest.utilObj.get().getUIUtils().waitForSec(5);
			}
			
			
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(flag, true, "Validating Successful selection of valid tower for creating NOC", true, true);
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in Successful selection of valid tower for creating NOC. Exception:"+e.getMessage(), false, true);
		}
		return flag;
	}
	
	public boolean getPaymentVerfiedStatusAtLeastOneRow() {
		boolean paymentVerificationPopulated = false;
		boolean verifiedStatus = false;
		
		int rowCnt = BaseTest.driver.get().findElements(By.xpath("//div[@class='app-datagrid']//table//tr")).size();
		
		if(! (rowCnt>1)) {
			for(int i=0; i<10; i++) {
				BaseTest.utilObj.get().getUIUtils().waitForSec(5);
				rowCnt = BaseTest.driver.get().findElements(By.xpath("//div[@class='app-datagrid']//table//tr")).size();
				if(rowCnt>1) {
					paymentVerificationPopulated = true;
					break;
				}
			}
		}
		String paymentStatus = null;
		if(paymentVerificationPopulated) {
			for(int i=2; i<=rowCnt; i++) {
				paymentStatus = BaseTest.driver.get().findElement(By.xpath("//div[@class='app-datagrid']//table//tr[2]/td[6]")).getText().trim();
				if(paymentStatus.equalsIgnoreCase("Verified")) {
					verifiedStatus = true;
					break;
				}
			}
		}
		
		return verifiedStatus;
			
	}

}

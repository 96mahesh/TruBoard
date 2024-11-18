package com.turbopartners.pom.pages;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.openqa.selenium.By;

import com.truboard.framework.BaseTest;



public class NOCApprovalPage {
	
	public By projectDD = By.xpath("//div[@caption='Project']/a");
	public By NOCDDItem = By.xpath("//a[@title='NOC']");
	public By manageRequestLnk = By.xpath("//span[text()='Manage Request']");
	
	
	public By viewRequestBtn = By.xpath("//button[@caption='View Request']");
	public By enterYourRemarksTxt = By.xpath("//input[@name='remarktext']");
	public By considerationNeededDD = By.xpath("//select[@name='considerationselect']");
	public By advancePaymentconsiderationNeededDD = By.xpath("//select[@name='advancedconsiderationselect']");
	public By advancePaymentRemarksTxt = By.xpath("//input[@name='advancedremarktext']");
	public By finalDecisionDD = By.xpath("//select[@name='descisionselect']");
	public By finalDecisionRemarksTxt = By.xpath("//input[@name='descisionremarktext']");
	public By downloadEle = By.xpath("//button[@name='downloadbutton']");
	public By uploadSignedAuthorizationLetterEle = By.xpath("(//button[@id='dropzone'])/*[contains(@class,'sl-cloud-upload')]");
	public By uploadSignedIssuanceLetterEle = By.xpath("(//button[@id='dropzone'])/*[contains(@class,'sl-cloud-upload')]");
	public By signedAuthorizationUploadedLetterLbl = By.xpath("//label[@class='upload-title']");
	public By signedIssuanceUploadedLetterLbl = By.xpath("//label[@class='upload-title']");
	public By submitBtn = By.xpath("//button[@caption='Submit']");
	
	public By approvedRequetSelectFieldLenderDD = By.xpath("(//select[@name='wm-datatable'])[2]");
	public By approvedRequestSearchFieldLenderTxt = By.xpath("(//input[@placeholder='Search'])[2]");
	
	
	
	public String pageTitle = "NA";
	public String projectDD_Name = "Project dropdown";
	public String NOCDDItem_Name = "NOC dropdown item";
	public String manageRequestLnk_Name = "Manage Request Link";
	public String viewRequestBtn_Name = "View Request Buttton";
	public String considerationNeededDD_Name = "consideration Needed Dropdown";
	public String advancePaymentconsiderationNeededDD_Name = "Advance Payment consideration Needed Dropdown";
	public String enterYourRemarksTxt_Name = "Enter Your Remarks text field";
	public String advancePaymentRemarksTxt_Name = "Advance Payment Remarks consideration needed Text field";
	public String finalDecisionDD_Name = "Final Decision dropdown";
	public String finalDecisionRemarksTxt_Name = "Final Decision Remarks Text";
	public String downloadEle_Name = "Download button";
	public String uploadSignedAuthorizationLetterEle_Name = "Upload Signed Authorization Letter Element";
	public String uploadSignedIssuanceLetterEle_Name = "Upload Signed Issuance Letter Element";
	public String signedAuthorizationUploadedLetterLbl_Name = "Uploaded Signed Authorization Letter label";
	public String signedIssuanceUploadedLetterLbl_Name = "Uploaded Signed Authorization Letter label";
	public String submitBtn_Name = "Submit button";
	public String approvedRequetSelectFieldLenderDD_Name = "Select Field Dropdown for Approved NOC Request";
	public String approvedRequestSearchFieldLenderTxt_Name = "Search field for Approved NOC Request";
	
	public int getTotalPendingRequestNo() {
		
		int pendingNOCTableRowNum = BaseTest.driver.get().findElements(By.xpath("(//table)[1]//tr")).size();
		
		if(pendingNOCTableRowNum>=2) {
			pendingNOCTableRowNum = pendingNOCTableRowNum -1;
		}else if(pendingNOCTableRowNum==1){
			pendingNOCTableRowNum = pendingNOCTableRowNum -1;
		}else {
			pendingNOCTableRowNum =0;
		}
		return pendingNOCTableRowNum;
	}
	
	public LinkedHashMap<Integer, LinkedHashMap<String, String>> getAllPendingRequestsData(){
		LinkedHashMap<Integer, LinkedHashMap<String, String>> allData = new LinkedHashMap<Integer, LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> tempData = null;
		List<String> headerData = new ArrayList<String>();
		List<String> rowData = new ArrayList<String>();
		try {
			BaseTest.utilObj.get().getUIUtils().waitForSec(6);
			int numOfRows = BaseTest.driver.get().findElements(By.xpath("(//table)[1]//tr")).size();
			int numOfCols = BaseTest.driver.get().findElements(By.xpath("(//table)[1]//th")).size();
			String tempHeaderVal = null;
			String tempCellVal = null;
					
			if(numOfRows>1) {
				for(int i =2; i<=numOfRows; i++) {
					for(int j =1; j<=numOfCols; j++) {
						tempHeaderVal = BaseTest.driver.get().findElement(By.xpath("((//table)[1]//th)["+j+"]")).getText();
						if(tempHeaderVal!=null) {
							tempHeaderVal = tempHeaderVal.trim();
						}
						tempCellVal = BaseTest.driver.get().findElement(By.xpath("((//table)[1]//tr)["+i+"]//td["+j+"]")).getText();
						if(tempCellVal!=null) {
							tempCellVal = tempCellVal.trim();
						}
						headerData.add((j-1), tempHeaderVal);
						rowData.add((j-1), tempCellVal);
					}
					tempData = new LinkedHashMap<String, String>();
					for(int k=0; k<rowData.size(); k++) {
						tempData.put(headerData.get(k), rowData.get(k));
					}
					headerData.clear();
					rowData.clear();
					allData.put((i-1), tempData);
					
				}				
			}			
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in getAllPendingRequestsData. Exception:"+e.getMessage(), false, false);
		}
		return allData;
	}
	
	public int getSpecificPendingNOCRecordNo(LinkedHashMap<Integer, LinkedHashMap<String, String>> allPendingRequestsData, String tower, String wing, String unitNo) {
		boolean presentFlag = false;
		int recordNo =0;
		
		String tempTower = null;
		String tempWing = null;
		String tempUnitNo = null;
		
		int recordSize = allPendingRequestsData.size();
		if(recordSize>0) {
			
			for(int i=1; i<=recordSize; i++) {
				tempTower = allPendingRequestsData.get(i).get("TOWER");
				tempWing = allPendingRequestsData.get(i).get("WING");
				tempUnitNo = allPendingRequestsData.get(i).get("UNIT NO");
				if(tempTower.equals(tower) && tempWing.equals(wing) && tempUnitNo.equals(unitNo)) {
					presentFlag = true;
					recordNo = i;
					break;
				}
			}			
		}else {
			System.out.println("record size 0");
		}
		
		if(presentFlag) {
			return recordNo;
		}else {
			return 0;
		}
		
	}
	
	public int getSpecificPendingNOCIssuanceRecordNo(LinkedHashMap<Integer, LinkedHashMap<String, String>> allPendingRequestsData, String purchaser, String wing, String unitNo) {
		boolean presentFlag = false;
		int recordNo =0;
		
		String tempPurchaser = null;
		String tempWing = null;
		String tempUnitNo = null;
		
		int recordSize = allPendingRequestsData.size();
		if(recordSize>0) {
			
			for(int i=1; i<=recordSize; i++) {
				tempPurchaser = allPendingRequestsData.get(i).get("PURCHASER");
				tempWing = allPendingRequestsData.get(i).get("WING");
				tempUnitNo = allPendingRequestsData.get(i).get("UNIT");
				if(tempPurchaser.equals(purchaser) && tempWing.equals(wing) && tempUnitNo.equals(unitNo)) {
					presentFlag = true;
					recordNo = i;
					break;
				}
			}			
		}else {
			System.out.println("record size 0");
		}
		
		if(presentFlag) {
			return recordNo;
		}else {
			return 0;
		}
		
	}
	
	public int getTotalApprovedRequestNo() {
		
		int approvedNOCTableRowNum = BaseTest.driver.get().findElements(By.xpath("(//table)[2]//tr")).size();
		
		if(approvedNOCTableRowNum>=2) {
			approvedNOCTableRowNum = approvedNOCTableRowNum -1;
		}else if(approvedNOCTableRowNum==1){
			approvedNOCTableRowNum = approvedNOCTableRowNum -1;
		}else {
			approvedNOCTableRowNum =0;
		}
		return approvedNOCTableRowNum;
	}
	
	public LinkedHashMap<Integer, LinkedHashMap<String, String>> getAllApprovedRequestsData(){
		LinkedHashMap<Integer, LinkedHashMap<String, String>> allData = new LinkedHashMap<Integer, LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> tempData = null;
		List<String> headerData = new ArrayList<String>();
		List<String> rowData = new ArrayList<String>();
		try {
			BaseTest.utilObj.get().getUIUtils().waitForSec(6);
			int numOfRows = BaseTest.driver.get().findElements(By.xpath("(//table)[2]//tr")).size();
			int numOfCols = BaseTest.driver.get().findElements(By.xpath("(//table)[2]//th")).size();
			String tempHeaderVal = null;
			String tempCellVal = null;
					
			if(numOfRows>1) {
				for(int i =2; i<=numOfRows; i++) {
					for(int j =1; j<=numOfCols; j++) {
						tempHeaderVal = BaseTest.driver.get().findElement(By.xpath("((//table)[2]//th)["+j+"]")).getText();
						if(tempHeaderVal!=null) {
							tempHeaderVal = tempHeaderVal.trim();
						}
						tempCellVal = BaseTest.driver.get().findElement(By.xpath("((//table)[2]//tr)["+i+"]//td["+j+"]")).getText();
						if(tempCellVal!=null) {
							tempCellVal = tempCellVal.trim();
						}
						headerData.add((j-1), tempHeaderVal);
						rowData.add((j-1), tempCellVal);
					}
					tempData = new LinkedHashMap<String, String>();
					for(int k=0; k<rowData.size(); k++) {
						tempData.put(headerData.get(k), rowData.get(k));
					}
					headerData.clear();
					rowData.clear();
					allData.put((i-1), tempData);
					
				}				
			}			
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong in getAllApprovedRequestsData. Exception:"+e.getMessage(), false, false);
		}
		return allData;
	}
	
	public int getSpecificApprovedNOCRecordNo(LinkedHashMap<Integer, LinkedHashMap<String, String>> allApprovedRequestsData, String tower, String wing, String unitNo, String status) {
		boolean presentFlag = false;
		int recordNo =0;
		
		String tempTower = null;
		String tempWing = null;
		String tempUnitNo = null;
		String tempStatus = null;
		
		int recordSize = allApprovedRequestsData.size();
		if(recordSize>0) {
			
			for(int i=1; i<=recordSize; i++) {
				tempTower = allApprovedRequestsData.get(i).get("TOWER");
				tempWing = allApprovedRequestsData.get(i).get("WING");
				tempUnitNo = allApprovedRequestsData.get(i).get("UNIT NO");
				tempStatus = allApprovedRequestsData.get(i).get("STATUS");;
				if(tempTower.equals(tower) && tempWing.equals(wing) && tempUnitNo.equals(unitNo) && tempStatus.equals(status)) {
					presentFlag = true;
					recordNo = i;
					break;
				}
			}			
		}else {
			System.out.println("record size 0");
		}
		
		if(presentFlag) {
			return recordNo;
		}else {
			return 0;
		}
		
	}

}

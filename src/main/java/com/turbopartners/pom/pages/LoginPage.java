package com.turbopartners.pom.pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.truboard.framework.BaseTest;
import com.truboard.setup.TestConfig;

public class LoginPage {
	
	public By emailTxt = By.xpath("//input[@type='email']");
	public By nextBtn = By.xpath("//input[@type='submit']");
	public By passwordTxt = By.xpath("//input[@type='password']");
	public By signInBtn = By.xpath("//input[@type='submit']");
	public By NoBtn_StaySignIn = By.xpath("//input[@id='idBtn_Back']");
	public By logoutBtn = By.xpath("//span[@class='anchor-caption' and text()='Logout']");
	
	public String emailTxt_Name = "Sign-In-email, Phone or Skype text field";
	public String nextBtn_Name = "Next button";
	public String passwordTxt_Name = "Password text field";
	public String signInBtn_Name = "Sign-In button";
	public String NoBtn_StaySignIn_Name = "No button of Stay Sign-In";
	public String logoutBtn_Name = "Logout button";
	
	public void loginDeveloper(String userName, String password) {
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "<b>Going to login into TURBOPARTNERS application using Developer credential<b>", false);
		BaseTest.driver.get().get(TestConfig.getInstance().getDeveloperNOCRequestURL());
		int objCnt = 0;
		BaseTest.utilObj.get().getUIUtils().inputText(emailTxt_Name, emailTxt, userName);
		BaseTest.utilObj.get().getUIUtils().clickElement(nextBtn_Name, nextBtn);
		BaseTest.utilObj.get().getUIUtils().waitForSec(6);
		BaseTest.utilObj.get().getUIUtils().inputText(passwordTxt_Name, passwordTxt, password);
		BaseTest.utilObj.get().getUIUtils().clickElement(signInBtn_Name, signInBtn);
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		objCnt = BaseTest.utilObj.get().getUIUtils().objCnt(NoBtn_StaySignIn);
		if(objCnt > 0) {
			BaseTest.utilObj.get().getUIUtils().clickElement(NoBtn_StaySignIn_Name, NoBtn_StaySignIn);
		}
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
		
		objCnt = BaseTest.utilObj.get().getUIUtils().objCnt(logoutBtn);
		
		BaseTest.sAssert.get().assertEquals(objCnt, 1, "Validation of Logout button for login");
		if(!(objCnt ==1)) {
			Assert.fail("Validation of Logout button for login");
		}
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		
	}
	
	public void loginInvestor(String userName, String password){
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "<b>Going to login into TURBOPARTNERS application using Lender credential<b>", false);
		BaseTest.driver.get().get(TestConfig.getInstance().getInvestorNOCRequestURL());
		int objCnt = 0;
		BaseTest.utilObj.get().getUIUtils().inputText(emailTxt_Name, emailTxt, userName);
		BaseTest.utilObj.get().getUIUtils().clickElement(nextBtn_Name, nextBtn);
		BaseTest.utilObj.get().getUIUtils().waitForSec(6);
		BaseTest.utilObj.get().getUIUtils().inputText(passwordTxt_Name, passwordTxt, password);
		BaseTest.utilObj.get().getUIUtils().clickElement(signInBtn_Name, signInBtn);
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		objCnt = BaseTest.utilObj.get().getUIUtils().objCnt(NoBtn_StaySignIn);
		if(objCnt > 0) {
			BaseTest.utilObj.get().getUIUtils().clickElement(NoBtn_StaySignIn_Name, NoBtn_StaySignIn);
		}
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
		
		objCnt = BaseTest.utilObj.get().getUIUtils().objCnt(logoutBtn);
		
		//BaseTest.sAssert.get().assertEquals(objCnt, 1, "Validation of Logout button for Investor login");
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(objCnt, 1, "Validation of Logout button for Investor login", true, true);
		if(!(objCnt ==1)) {
			Assert.fail("Validation of Logout button for Investor login");
		}
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		
	}
	
	public void loginDebenture(String userName, String password){
		BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "<b>Going to login into TURBOPARTNERS application using Debenture credential<b>", false);
		BaseTest.driver.get().get(TestConfig.getInstance().getDeveloper2NOCRequestURL());
		int objCnt = 0;
		BaseTest.utilObj.get().getUIUtils().inputText(emailTxt_Name, emailTxt, userName);
		BaseTest.utilObj.get().getUIUtils().clickElement(nextBtn_Name, nextBtn);
		BaseTest.utilObj.get().getUIUtils().waitForSec(6);
		BaseTest.utilObj.get().getUIUtils().inputText(passwordTxt_Name, passwordTxt, password);
		BaseTest.utilObj.get().getUIUtils().clickElement(signInBtn_Name, signInBtn);
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		objCnt = BaseTest.utilObj.get().getUIUtils().objCnt(NoBtn_StaySignIn);
		if(objCnt > 0) {
			BaseTest.utilObj.get().getUIUtils().clickElement(NoBtn_StaySignIn_Name, NoBtn_StaySignIn);
		}
		BaseTest.utilObj.get().getUIUtils().waitForSec(2);
		
		objCnt = BaseTest.utilObj.get().getUIUtils().objCnt(logoutBtn);
		
		//BaseTest.sAssert.get().assertEquals(objCnt, 1, "Validation of Logout button for Investor login");
		BaseTest.utilObj.get().getAssertManager().sAssertEquals(objCnt, 1, "Validation of Logout button for Debenture login", true, true);
		if(!(objCnt ==1)) {
			Assert.fail("Validation of Logout button for Debenture login");
		}
		BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		
	}

	public void loginpmc(String userId, String userPWD){
			BaseTest.LOGGER.get().logTestStep(BaseTest.extentTest.get(), "INFO", "<b>Going to login into TURBOPARTNERS application using Developer2 credential<b>", false);
			BaseTest.driver.get().get(TestConfig.getInstance().getpmcNOCRequestURL());
			int objCnt = 0;
			BaseTest.utilObj.get().getUIUtils().inputText(emailTxt_Name, emailTxt, userId);
			BaseTest.utilObj.get().getUIUtils().clickElement(nextBtn_Name, nextBtn);
			BaseTest.utilObj.get().getUIUtils().waitForSec(6);
			BaseTest.utilObj.get().getUIUtils().inputText(passwordTxt_Name, passwordTxt, userPWD);
			BaseTest.utilObj.get().getUIUtils().clickElement(signInBtn_Name, signInBtn);
			BaseTest.utilObj.get().getUIUtils().waitForSec(3);
			objCnt = BaseTest.utilObj.get().getUIUtils().objCnt(NoBtn_StaySignIn);
			if(objCnt > 0) {
				BaseTest.utilObj.get().getUIUtils().clickElement(NoBtn_StaySignIn_Name, NoBtn_StaySignIn);
			}
			BaseTest.utilObj.get().getUIUtils().waitForSec(2);
			
			objCnt = BaseTest.utilObj.get().getUIUtils().objCnt(logoutBtn);
			
			BaseTest.sAssert.get().assertEquals(objCnt, 1, "Validation of Logout button for login");
			if(!(objCnt ==1)) {
				Assert.fail("Validation of Logout button for login");
			}
			BaseTest.utilObj.get().getUIUtils().waitForSec(3);
		
	}
	
	public void clickOnlogOut() {
		BaseTest.utilObj.get().getUIUtils().waitForSec(5);
		BaseTest.utilObj.get().getUIUtils().clickElement(logoutBtn_Name, logoutBtn);
	}
}

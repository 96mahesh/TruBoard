package com.truboard.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.time.*;

import com.aventstack.extentreports.ExtentTest;
import com.truboard.framework.BaseTest;
import com.truboard.framework.LogMe;
import com.truboard.setup.TestConfig;
import com.truboard.setup.TestDataConfig;

public class UIUtils {
	private LogMe LOGGER = null;
	private WebDriver driver = null;
	private ExtentTest extentTest = null;
	private SoftAssert sAssert = null;
	Alert alert;
	
	public void setupTestObj() {
		this.LOGGER = BaseTest.LOGGER.get();
		this.driver = BaseTest.driver.get();
		this.extentTest = BaseTest.extentTest.get();
		this.sAssert = BaseTest.sAssert.get();
	}
	
	public void waitForSec(int i) {
		try {
			long timeInSec = i*1000;
			Thread.sleep(timeInSec);
		}catch(InterruptedException e) {
			e.printStackTrace();			
		}
	}
	
	public String getPageTitle(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String pageTitle = null;
		try {
			if(js.executeScript("return document.readyState").toString().equals("complete")) {
				pageTitle = driver.getTitle();
			}else {
				for(int i=1; i<=15; i++) {
					waitForSec(1);
					if(js.executeScript("return document.readyState").toString().equals("complete")) {
						pageTitle = driver.getTitle();
						break;
					}
				}
			}
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Exception occurred in getPageTitle:"+e.getMessage(), true, false);
		}
		return pageTitle;
	}
	
	public void validatePageTitle(String expectedPageTtitle, boolean isHardAssert) {
		try {
			String actualPageTitle = getPageTitle(driver);
			LOGGER.logTestStep(extentTest, "INFO", "<b><Going to valiadate page title><b>", false);
			BaseTest.sAssert.get().assertEquals(actualPageTitle, expectedPageTtitle);
			if(isHardAssert) {
				BaseTest.sAssert.get().assertAll();
				Assert.fail("validatePageTitle failed");
			}
				
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong while validating page title. Exception:"+e.getMessage(), isHardAssert);
		}
	}
	public boolean objWait(String elementName, By by, String maxDurationInSec, boolean hardAssert, boolean...toBeClickable) {
		boolean flag = true;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Integer.parseInt(maxDurationInSec)))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
			
//			boolean el2 = wait.until(new Function<WebDriver, Boolean>() {
//                public Boolean apply(WebDriver driver) {
//                       boolean isTrue = (boolean)js.executeScript("return window.location.host !== ''");
//                       return isTrue;
//                }
//          });
		wait.until((ExpectedConditions.presenceOfElementLocated(by)));
		flag = driver.findElement(by).isDisplayed();
		wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(by)));
		if(toBeClickable.length>0) {
			if(toBeClickable[0]==true) {
				wait.until((ExpectedConditions.elementToBeClickable(by)));
			}
		}
		try {
			Thread.sleep(1000);
		}catch(Exception e) {
			
		}
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Exception occurred in element:"+elementName+ " wait."+e.getMessage(), true, hardAssert);
			flag = false;
		}		
		return flag;
	}
	
	public boolean objWaitWithoutIsDisplayed(String elementName, By by, String maxDurationInSec, boolean hardAssert) {
		boolean flag = true;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Integer.parseInt(maxDurationInSec)))
					.pollingEvery(Duration.ofMillis(100)).ignoring(NoSuchElementException.class);
		wait.until((ExpectedConditions.presenceOfElementLocated(by)));
		//flag = driver.findElement(by).isDisplayed();
		wait.until((ExpectedConditions.visibilityOfAllElementsLocatedBy(by)));
		wait.until((ExpectedConditions.elementToBeClickable(by)));
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Exception occurred in element:"+elementName+ " wait."+e.getMessage(), true, hardAssert);
			flag = false;
		}		
		return flag;
	}
	
	public WebElement findElement(String elementName, By by,String waitTimeInSec, boolean hardAssert, boolean...toBeClickable) {
		if(toBeClickable.length>0) {
			if(toBeClickable[0]==false) {
				objWait(elementName, by, waitTimeInSec, hardAssert, false );
			}
		}else {
			objWait(elementName, by, waitTimeInSec, hardAssert );
		}
		
		WebDriverWait wWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		return wWait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	//Developed by Kanvitha
	public boolean isDisplayed(By by) {
		WebDriverWait wWait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wWait.until(ExpectedConditions.visibilityOfElementLocated(by));
		
		return driver.findElement(by).isDisplayed();
	}
	
	
	//Developed by Kanvitha
	public List<WebElement> findElements(String elementName, By by,String waitTimeInSec) {
		
		
		WebDriverWait wWait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(waitTimeInSec)));
		return wWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	
	//Developed By Kanvitha
	public int countOfRows(String elementName, By by) {
		return driver.findElements(by).size();
	}
	
	//Developed By Kanvitha
	public void switchToAlertAndAccept() {
		driver.switchTo().alert().accept();
	}
	
	//Developed by Kanvitha
	public void sendKeysWithClickAndKeysEnter(String elementName, By by) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.click(element).sendKeys(Keys.ENTER).build().perform();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Developed by Kanvitha
		public void sendKeysWithKeysEnter(String elementName, By by) {
			Actions action = new Actions(driver);
			WebElement element;
			try {
				element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
				action.sendKeys(Keys.ENTER).build().perform();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	//Developed by Kanvitha
		public void sendKeysWithKeysBACK_SPACE(String elementName, By by) {
			WebElement element;
			try {
				element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
				Thread.sleep(3000);
				element.clear();
				element.click();
				element.sendKeys(Keys.BACK_SPACE);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
	//Developed by Kanvitha
	public void clearAndEnterText(String elementName, By by,String text) {
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			element.clear();
			element.sendKeys(text);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void inputTextUsingActionClassClick(String elementName, By by, String data) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.click(element).sendKeys(data).sendKeys(Keys.ENTER).build().perform();
			LOGGER.logTestStep(extentTest, "INFO", "Entered text:"+data+" on element:"+elementName+".", false);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while inputting text:"+data+" using action class on element:"+elementName+ ".Exception"+e.getMessage(), true, true);
		}
	}
		
	public void inputText(String elementName, By by, String data) {
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), false);
			element.clear();
			element.sendKeys(data);
			if(data.toLowerCase().contains("password")) {
				LOGGER.logTestStep(extentTest, "INFO", "Entered password text:****** on element:"+elementName, false);
			}else {
				LOGGER.logTestStep(extentTest, "INFO", "Entered text:"+data+ " on element:"+elementName, false);
			}			
		}catch(Exception e) {
			if(data.toLowerCase().contains("password")) {
				BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while inputting text **** on element:"+elementName+ ".Exception"+e.getMessage(), true, true);
			}else {
				BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while inputting text:"+data+ " on element:"+elementName+ ".Exception"+e.getMessage(), true, true);
			}			
		}
	}
	public void inputTextwithKeys(String elementName, By by, String data, Keys key) {
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), false);
			element.clear();
			element.sendKeys(data,key);
			if(data.toLowerCase().contains("password")) {
				LOGGER.logTestStep(extentTest, "INFO", "Entered password text:****** on element:"+elementName, false);
			}else {
				LOGGER.logTestStep(extentTest, "INFO", "Entered text:"+data+ " on element:"+elementName, false);
			}			
		}catch(Exception e) {
			if(data.toLowerCase().contains("password")) {
				BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while inputting text **** on element:"+elementName+ ".Exception"+e.getMessage(), true, true);
			}else {
				BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while inputting text:"+data+ " on element:"+elementName+ ".Exception"+e.getMessage(), true, true);
			}			
		}
	}
	
	public void inputTextUsingActionClass(String elementName, By by, String data) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.moveToElement(element).sendKeys(data).build().perform();
			LOGGER.logTestStep(extentTest, "INFO", "Entered text:"+data+" on element:"+elementName+".", false);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while inputting text:"+data+" using action class on element:"+elementName+ ".Exception"+e.getMessage(), true, true);
		}
	}
	
	public void clickElement(String viewrequest, By by) {
		WebElement element;
		try {
			element = findElement(viewrequest, by, TestConfig.getInstance().getOBJWAITTIME(), false);
			element.click();
			LOGGER.logTestStep(extentTest, "INFO", "Clicked on element:"+viewrequest, false);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while clicking on element:"+viewrequest+ ".Exception"+e.getMessage(), true, true);
		}
	}
	
	//developed by Kanvitha
	public int getValueFromTextBox(String viewrequest, By by) {
		WebElement element;
		String value = null;
		int intvalue = 0;
		try {
			element = findElement(viewrequest, by, TestConfig.getInstance().getOBJWAITTIME(), false);
			//element.click();
			//element.sendKeys(Keys.chord(Keys.CONTROL,"a"));
			value=element.getAttribute("value");
			Float fl = Float.valueOf(value);
			intvalue = Math.round(fl);
			LOGGER.logTestStep(extentTest, "INFO", "Clicked on element:"+viewrequest, false);
			return intvalue;
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while clicking on element:"+viewrequest+ ".Exception"+e.getMessage(), true, true);
		}
		return intvalue;
	}
	public int getValueFromTextBox1(String viewrequest, By by) {
		WebElement element;
		String value = null;
		int intvalue = 0;
		String val="";
		int b=0;
		try {
			element = findElement(viewrequest, by, TestConfig.getInstance().getOBJWAITTIME(), false);
			value=element.getAttribute("value");
			//System.out.println("Value is:"+ value);
			int ss = value.indexOf(".");
			String sss=value.substring(0,ss);
			//System.out.println(sss);
			String a[]=sss.split(",");
			for(int i=0;i<a.length;i++) {
				val=val.concat(a[i]);
			}
			//System.out.println(val);
			b=Integer.parseInt(val);
			//System.out.println("int value is:"+b);
			LOGGER.logTestStep(extentTest, "INFO", "Clicked on element:"+viewrequest, false);
			return b;
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while clicking on element:"+viewrequest+ ".Exception"+e.getMessage(), true, true);
		}
		return b;
	}
	
	public String getText(String elementName, By by, boolean logMsg, boolean...toBeClickable) {
		String text = null;
		WebElement element = null;;
		try {
			if(toBeClickable.length>0) {
				if(! toBeClickable[0]==true) {
					element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), false, toBeClickable[0]);
					text = element.getText().trim();
				}
			}else {
				element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), false);
				text = element.getText().trim();
			}	
			
			
			if(StringUtils.isBlank(text)) {
				text = element.getAttribute("value").trim();
			}
			if(logMsg==true) {
				LOGGER.logTestStep(extentTest, "INFO", "Element:"+elementName+" text value:"+text+".", false);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to retrieve text of element:"+elementName+ ".Exception"+e.getMessage(), true, false);
		}
		return text;
	}
	//developed by Kanvitha
	public String getText(String elementName, By by) {

		WebElement element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), false);
		String text = element.getText();

		return text;
	}

	public void selectValue(String elementName, By by, String selectBy, String option) {
		try {
			objWait(elementName, by,TestConfig.getInstance().getOBJWAITTIME(), true);
			Select select = new Select(driver.findElement(by));
			switch (selectBy.toLowerCase()) {
			case "index":
				select.selectByIndex(Integer.valueOf(option));
				LOGGER.logTestStep(extentTest, "INFO", "Selected dropdown value as :"+option+" on element::"+elementName+".", false);
				break;
			case "text":
				select.selectByVisibleText(option);
				LOGGER.logTestStep(extentTest, "INFO", "Selected dropdown value as :"+option+" on element::"+elementName+".", false);
				break;
			case "value":
				select.selectByValue(option);
				LOGGER.logTestStep(extentTest, "INFO", "Selected dropdown value as :"+option+" on element::"+elementName+".", false);
				break;
			case "containstext":
				int indexNum = 1;
				for(WebElement element : select.getOptions()) {
					if(element.getText().toLowerCase().contains(option.toLowerCase())) {
						select.selectByIndex(indexNum);
						LOGGER.logTestStep(extentTest, "INFO", "Selected dropdown containstext value as :"+option+" on element::"+elementName+".", false);
						break;
					}
					indexNum++;
					
				}
			default:
				break;
			}			
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while selecting the value:"+option+ " on element:"+elementName+".Exception"+e.getMessage(), true, true);
		}
	}
	
	public String getSelectedValue(String elementName, By by) {
		String selectedText = null;
		try {
			objWait(elementName, by,TestConfig.getInstance().getOBJWAITTIME(), true);
			Select select = new Select(driver.findElement(by));
			selectedText = select.getFirstSelectedOption().getText();						
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while getting the first selected option for element :"+elementName+".Exception"+e.getMessage(), true, false);
		}
		return selectedText;
	}
	
	public void moveToElement(String elementName, By by) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.moveToElement(element).build().perform();
			LOGGER.logTestStep(extentTest, "INFO", "Moved on element:"+elementName+".", false);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while moving on element:"+elementName+ ".Exception"+e.getMessage(), true, true);
		}
	}
	public void clickElementUsingAction(String elementName, By by) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.moveToElement(element).click().build().perform();
			LOGGER.logTestStep(extentTest, "INFO", "Clicked on element:"+elementName+".", false);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while clickElementUsingAction on element:"+elementName+ ".Exception"+e.getMessage(), true, true);
		}
	}
	
	public void rightClickElement(String elementName, By by) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.contextClick(element).perform();
			LOGGER.logTestStep(extentTest, "INFO", "Right clicked on element:"+elementName+".", false);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while right clicking on element:"+elementName+ ".Exception"+e.getMessage(), true, true);
		}
	}
	
	public void doubleClickElement(String elementName, By by) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.doubleClick().build().perform();
			LOGGER.logTestStep(extentTest, "INFO", "Double clicked on element:"+elementName+".", false);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while double clicking on element:"+elementName+ ".Exception"+e.getMessage(), true, true);
		}
	}
	
	public void pressKeyboardKeys(String elementName, By by, Keys data) {
		Actions action = new Actions(driver);
		WebElement element;
		try {
			element = findElement(elementName, by, TestConfig.getInstance().getOBJWAITTIME(), true);
			action.moveToElement(element).sendKeys(data).build().perform();
			LOGGER.logTestStep(extentTest, "INFO", "Pressed keyboard keys:"+data+" on element:"+elementName+".", false);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while pressing the keyboard keys:"+data+" on element:"+elementName+ ".Exception"+e.getMessage(), true, true);
		}
	}
	
	public String getRandomNumber(int digCount) {
		String num = null;
		try {
			num = CommonUtils.generateNumericNumber(digCount);
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while getting the random number.Exception"+e.getMessage(), true, true);
		}
		return num;
	}
	
	public boolean waitForInvisibilityOfElement(String elementName, By by, String waitInSec, boolean hardAssert) {
		boolean flag = true;
		try {
			WebDriverWait wWait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(waitInSec)));
			wWait.until(ExpectedConditions.invisibilityOfElementLocated(by));			
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Failed while waiting for invisibility of element:"+elementName+".Exception"+e.getMessage(), true, true);
			flag = false;
		}
		return flag;		
	}
	
	public boolean getRightWindow(String windowTitle) {
		String title = null;
		try {
			Set<String> handles = driver.getWindowHandles();
			List<String> hlist = new ArrayList<String>(handles);
			for(String handle : hlist) {
				title = driver.switchTo().window(handle).getTitle();
				if(title.contains(windowTitle)) {
					return true;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong while navigating between the screen:"+windowTitle+".Exception"+e.getMessage(), true, true);					
		}
		return false;
	}
	
	public String getTextUsingJS(String elementName, String xpath, boolean logMsg) {
		String objVal = null;
		try {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			objVal = (String) js.executeScript("return document.evaluate(\""+xpath+"\", document, null, XPathResult.FIRST_ORDERED_TYPE, null).singleNodeValue.value;");
			if(logMsg) {
				LOGGER.logTestStep(extentTest, "INFO", "Element:"+elementName+" text value using JS as:"+objVal+".", false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Unable to retrieve text using JS of element:"+elementName+".Exception"+e.getMessage(), true, false);
		}
		
		return objVal;
	}
	
	public void clickElementUsingJS(String elementName, String xpath, boolean logMsg) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)BaseTest.driver.get();
			String val ="document.evaluate(\""+xpath+"\", document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null).snapshotItem(0).click();";
			//js.executeScript("document.evaluate(\""+xpath+"\", document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null).snapshotItem(0).dispatchEvent(new MouseEvent('dblclick'));");
			js.executeScript("document.evaluate(\""+xpath+"\", document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null).snapshotItem(0).click();");
			if(logMsg) {
				LOGGER.logTestStep(extentTest, "INFO", "Element:"+elementName+" clicked using JS.", false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Element clicked using JS of element:"+elementName+".Exception"+e.getMessage(), true, false);
		}
	}
	
	//js.executeScript("return document.evaluate(\""+xpath+"\", document, null, XPathResult.FIRST_ORDERED_TYPE, null).singleNodeValue.click();");
	public void clickElementUsingJS2(String elementName, String xpath, boolean logMsg) {
		try {
			JavascriptExecutor js = (JavascriptExecutor)BaseTest.driver.get();
			String val ="document.evaluate(\""+xpath+"\", document, null, XPathResult.FIRST_ORDERED_TYPE, null).singleNodeValue.click();";
			js.executeScript("document.evaluate(\""+xpath+"\", document, null, XPathResult.FIRST_ORDERED_TYPE, null).singleNodeValue.click();");
			if(logMsg) {
				LOGGER.logTestStep(extentTest, "INFO", "Element:"+elementName+" clicked using JS.", false);
			}
		}catch(Exception e) {
			e.printStackTrace();
			BaseTest.utilObj.get().getAssertManager().sAssertException("Element clicked using JS of element:"+elementName+".Exception"+e.getMessage(), true, false);
		}
	}	
	public boolean validateObjectPresent(By by, String objectName, boolean screenShot, boolean isHardAssert) {
		boolean flag = false;
		try {
			LOGGER.logTestStep(extentTest, "INFO", "Going to valiadate object:"+objectName+" presents in page", false);
			boolean isObjPresent= objWait(objectName, by, "90", isHardAssert);
			if(isObjPresent) {
				flag = true;
			}
			LOGGER.logTestStep(extentTest, "INFO", "isObjPresent:"+isObjPresent, false);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(isObjPresent, true, "Validating presense of element:"+objectName, screenShot, isHardAssert);
			
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong while validating page title. Exception:"+e.getMessage(), true, isHardAssert);
			flag = false;
		}
		return flag;
	}
	public boolean validateObjectPresentWithoutIsDisplayed(By by, String objectName, boolean screenShot, boolean isHardAssert) {
		boolean flag = false;
		try {
			LOGGER.logTestStep(extentTest, "INFO", "Going to valiadate object:"+objectName+" presents in page", false);
			boolean isObjPresent= objWaitWithoutIsDisplayed(objectName, by, "90", isHardAssert);
			if(isObjPresent) {
				flag = true;
			}
			LOGGER.logTestStep(extentTest, "INFO", "isObjPresent:"+isObjPresent, false);
			BaseTest.utilObj.get().getAssertManager().sAssertEquals(isObjPresent, true, "Validating presense of element:"+objectName, screenShot, isHardAssert);
			
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong while validating page title. Exception:"+e.getMessage(), true, isHardAssert);
			flag = false;
		}
		return flag;
	}
	
	public void scrollIntoView(By by) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));
			waitForSec(1);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int objCnt(By by) {
		int cnt =0;
		try {
			setOnMinImplicitWait();
			cnt = driver.findElements(by).size();
			setOffMinImplicitWait();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	public void setOnMinImplicitWait() {
		BaseTest.driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	public void setOffMinImplicitWait() {
		BaseTest.driver.get().manage().timeouts().implicitlyWait(Long.parseLong(TestConfig.getInstance().getScriptTimeoutSecounds()), TimeUnit.SECONDS);
	}
	
	public void uploadFile(String filePath) {
		try {
			StringSelection str = new StringSelection(filePath);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(str, null);
			BaseTest.utilObj.get().getUIUtils().waitForSec(4);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			BaseTest.utilObj.get().getUIUtils().waitForSec(4);
		}catch(Exception e) {
			BaseTest.utilObj.get().getAssertManager().sAssertException("Something went wrong while validating page title. Exception:"+e.getMessage(), true, true);
			
		}
	}
}


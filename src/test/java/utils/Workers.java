package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import testBase.BrowserManager;

public class Workers extends BrowserManager {

	/**
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * @param elementList
	 * @param selectValue
	 */
	public static void clickRadioOrCheckbox(List<WebElement> elementList, String selectValue) {
		for (WebElement eachElement : elementList) {
			String elementValue = eachElement.getAttribute("value").trim();

			if (elementValue.equals(selectValue) && eachElement.isEnabled()) {
				eachElement.click();
				break;
			}
		}
	}
	/**
	 * @param seconds
	 */
	public static void wait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param element
	 * @param text
	 */
	public static void selectDropdown(WebElement element, String text) {
		try {
			Select mySelect = new Select(element);
			mySelect.selectByVisibleText(text);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * @param element
	 * @param index
	 */
	public static void selectDropdown(WebElement element, int index) {
		try {
			Select mySelect = new Select(element);
			mySelect.deselectByIndex(index);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public static void switchToAlert() {
		try {
			myDriver.switchTo().alert();
		}catch(NoAlertPresentException exception) {
			exception.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public static void acceptAlert() {
		try {
			Alert myAlert = myDriver.switchTo().alert();
			myAlert.accept();
		} catch (NoAlertPresentException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public static void dismissAlert() {
		try {
			Alert myAlert = myDriver.switchTo().alert();
			myAlert.dismiss();
		} catch (NoAlertPresentException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * @return
	 */
	public static String getAlertText() {
		String alertText = null;

		try {
			Alert myAlert = myDriver.switchTo().alert();
			alertText = myAlert.getText();
		} catch (NoAlertPresentException exception) {
			exception.printStackTrace();
		}
		return alertText;
	}

	/**
	 * @param text
	 */
	public static void sendTextToAlert(String text) {
		try {
			Alert myAlert = myDriver.switchTo().alert();
			myAlert.sendKeys(text);
		} catch (NoAlertPresentException exception) {
			exception.printStackTrace();
		}
	}
	/**
	 * @param text
	 */
	public static void switchToFrame(String text) {
		try {
			myDriver.switchTo().frame(text);
			
		}catch(NoSuchFrameException exception) {
			exception.printStackTrace();
		}
	}
	/**
	 * @param index
	 */
	public static void switchToFrame(int index) {
		try {
			myDriver.switchTo().frame(index);
		}catch(NoSuchFrameException exception) {
			exception.printStackTrace();
		}
	}
	/**
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			myDriver.switchTo().frame(element);
		}catch(NoSuchFrameException exception) {
			exception.printStackTrace();
		}
	}
	/**
	 * 
	 */
	public static void switchToChildWindow() {
		String currentWindow = myDriver.getWindowHandle();
		Set<String>handles = myDriver.getWindowHandles();
		
		for(String eachHandle : handles){
			
			if(!eachHandle.equals(currentWindow)) {
				myDriver.switchTo().window(eachHandle);
			}
		}
	}
	/**
	 * @return
	 */
	public static WebDriverWait createWaitObject () {
		
		WebDriverWait myDriverWait = new WebDriverWait(myDriver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		return myDriverWait;
		}
	/**
	 * @param seconds
	 * @return
	 */
	public static WebDriverWait createWaitObject (int seconds) {
		
		WebDriverWait myDriverWait = new WebDriverWait(myDriver, Duration.ofSeconds(seconds));
		return myDriverWait;
	}
	/**
	 * @param element
	 * @return
	 */
	public static WebElement waitForClickability(WebElement element){
		return createWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * @param element
	 * @return
	 */
	public static WebElement waitForVisibility(WebElement element) {
		return createWaitObject().until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}
	/**
	 * @return
	 */
	public static JavascriptExecutor jsInit() {
		
		return (JavascriptExecutor)myDriver;
	}
	/**
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		
		jsInit().executeScript("arguments[0].click()", element);
	}
	/**
	 * @param pixels
	 */
	public static void scrollDown(int pixels) {
		
		jsInit().executeScript("window.scrollBy(0, " + pixels + ")");
	}
	/**
	 * @param pixels
	 */
	public static void scrollUp(int pixels) {
		
		jsInit().executeScript("window.scrollBy(-" + pixels + ")");
	}
	/**
	 * @param element
	 */
	public static void scrollToElement(WebElement element) {
		
		jsInit().executeScript("arguments[0].scrollIntoView(true)", element);
	}
	/**
	 * @param calendar
	 * @param date
	 */
	public static void selectCalendarDate(List<WebElement> calendar, String date) {
		
		for(WebElement day : calendar) {
			
			if(day.getText().equals(date) && day.isEnabled()) {
				
				click(day);
				break;
				
			}else {
				
				System.out.println("Date is unavailable");
			}
		}
	}
	/**
	 * 
	 * @param filePath
	 */
	public static String captureScreenshot(String fileName) {
		
		TakesScreenshot screenshoter = (TakesScreenshot) myDriver;
		
		File screenshot = screenshoter.getScreenshotAs(OutputType.FILE);
		
		String screenshotDestination = Constants.SCREENSHOT_PATH + fileName + timeStamp() + ".png";
		
		try {
		
		FileUtils.copyFile(screenshot, new File(screenshotDestination));
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return screenshotDestination;
	}
	
	/**
	 * 
	 * @param element
	 * @param fileName
	 */
	public static void captureElementScreenshot(WebElement element, String fileName) {
		
		try {
		
		File screenshot = element.getScreenshotAs(OutputType.FILE);
		
		Files.copy(screenshot, new File("./screenshot/" + fileName));
		
	    }catch(Exception e) {
	    	
	    	e.printStackTrace();
	    }
	}
	
	/**
	 * 
	 * @return
	 */
	public static String timeStamp() {
		
		Date date = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		
		return sdf.format(date);
	}
	
	
	
}
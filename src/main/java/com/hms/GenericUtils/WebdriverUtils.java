package com.hms.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtils {

	public void Maximizethewindow(WebDriver driver) {
		/**
		 * this method is use to maximize the window
		 */
		driver.manage().window().maximize();
	}
	
	

	public void Minimizethewindow(WebDriver driver) {
		/**
		 * this method is use to minimize the window
		 */
		driver.manage().window().minimize();
	}

	public void Waitforpageload(WebDriver driver, int sec) {
		/**
		 * this method is use to wait until the webpage is loaded
		 */
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
	}

	public void implicitwait(WebDriver driver, int sec) {
		/**
		 * this method is use to wait for findelements and findelement
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
	}

	public void waituntilelementtobevisible(WebDriver driver, int sec, WebElement element) {
		/**
		 * 
		 */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waituntilelementtoclickable(WebDriver driver, int sec, WebElement element) {
		/**
		 * 
		 */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void dropdownselectbyindex(WebElement element, int index) {
		Select sc = new Select(element);
		sc.selectByIndex(index);
	}

	public void selectbyvalue(WebElement element, String value) {
		Select sc = new Select(element);
		sc.selectByValue(value);
	}

	public void selectbyvisibletext(WebElement element, String text) {
		Select sc = new Select(element);
		sc.selectByVisibleText(text);
	}

	public void click(WebDriver driver) {
		Actions action = new Actions(driver);
		action.click().perform();
	}

	public void doubleclick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void doubleclick(WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick().perform();
	}

	public void dragandrop(WebDriver driver, WebElement source, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	public void contextclick(WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}

	public void contextclick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void movetoelement(WebDriver driver, WebElement ele, long sec) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().pause(Duration.ofSeconds(sec));
	}

	public void keypressenter() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);

	}

	public void keyreleaseenter() throws AWTException {
		Robot rb = new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

	public void switchtoframe(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	public void switchtoframe(WebDriver driver, String frameorid) {
		driver.switchTo().frame(frameorid);

	}

	public void switchtoframe(WebDriver driver, WebElement address) {
		driver.switchTo().frame(address);

	}

	public void switchtowindow(WebDriver driver, String nameorhandel) {
		driver.switchTo().window(nameorhandel);
	}

	public void scrollbarto(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(" + x + "," + y + ")");
	}

	public void scrollbarby(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + "," + y + ")");
	}

	public void scrolluntilementisvisible(WebDriver driver, WebElement ele) {
		Point loc = ele.getLocation();
		int y = loc.getY();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0 ," + y + ")");
		// js.executeScript("arguments[0].scrollIntoView(true);", ele);
		// js.executeScript("arguments[0].scrollIntoView();", ele)

	}
	public static String Takescreenshot(WebDriver driver, String Screenshotname) throws Throwable
	{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	String file="./Screenshot/"+ Screenshotname+".png";
	File dest = new File(file);
	FileUtils.copyFile(src, dest);
	return file;
	}
	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public String alertText(WebDriver driver) {
		String text1 = driver.switchTo().alert().getText();
		return text1;

	}
	
}

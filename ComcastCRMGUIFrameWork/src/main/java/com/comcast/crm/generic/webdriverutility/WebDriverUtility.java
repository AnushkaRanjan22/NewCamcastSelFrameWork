package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	// for implicitly wait
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void pageToMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	// for explicitly wait
	public void waitForElementToLoad(WebDriver driver, WebElement element) {
		WebDriverWait ww = new WebDriverWait(driver, Duration.ofSeconds(20));
		ww.until(ExpectedConditions.visibilityOf(element));

	}

	// Switching the window by partial url
	public void switchToTabOnUrl(WebDriver driver, String partialUrl) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String windowId = itr.next();
			driver.switchTo().window(windowId);
			String actUrl = driver.getCurrentUrl();
			if (actUrl.contains(partialUrl)) {
				break;
			}
		}
	}

	// switching the window by tittle
	public void switchToTittle(WebDriver driver, String tittle) {
		Set<String> set = driver.getWindowHandles();
		Iterator<String> itr = set.iterator();

		while (itr.hasNext()) {
			String windowId = itr.next();
			driver.switchTo().window(windowId);

			String acttittle = driver.getTitle();
			if (acttittle.contains(tittle)) {
				break;
			}
		}
	}

	// it is example for overLoading we are using same method name for diffrent
	// argument type;

	// switch to iframe using Index
	public void switchTOFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	// switch to iframe using nameId
	public void switchTOFrame(WebDriver driver, String name) {
		driver.switchTo().frame(name);
	}

	// switch to iframe using webelement
	public void switchTOFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}

	// perform popup action

	// accept
	public void switchtoAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	// cencle
	public void switchToAlertAndCencle(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	// handle the drop down list using select class
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void select(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	// mouse related action

	public void mouseoverOnElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

	}

	public void doubleclick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		;
	}

}

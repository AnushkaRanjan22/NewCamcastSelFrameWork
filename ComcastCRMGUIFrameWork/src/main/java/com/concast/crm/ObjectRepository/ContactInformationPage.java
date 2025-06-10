 package com.concast.crm.ObjectRepository;

import java.lang.classfile.WritableElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v116.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	WebDriver driver;

	public ContactInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDateVerify;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement endDateVerify;

	@FindBy(xpath = "//span[@id='dtlview_Last Name']")
	private WebElement lastNameVerify;
	
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']")
	private WebElement orgNameVerify;
	
	public WebElement getOrgNameVerify() {
		return orgNameVerify;
	}

	public WebElement getLastNameVerify() {
		return lastNameVerify;
	}

	public WebElement getStartDateVerify() {
		return startDateVerify;
	}

	public WebElement getEndDateVerify() {
		return endDateVerify;
	}

}

package com.concast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	WebDriver driver;

	public OrganizationInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerOrgName;

	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']")
	private WebElement bodyOrgName;
	
	@FindBy(xpath = "//td[@id='mouseArea_Industry']")
	private WebElement orgindustInfo;
	
	@FindBy (id = "mouseArea_Phone")
	private WebElement phoneVerify;
	
	
	public WebElement getPhoneVerify() {
		return phoneVerify;
	}
	
	public WebElement getOrgIndustInfo() {
		return orgindustInfo;
	}

	public WebElement getHeaderOrgName() {
		return headerOrgName;
	}

	public WebElement getBodyOrgName() {
		return bodyOrgName;
	}
}

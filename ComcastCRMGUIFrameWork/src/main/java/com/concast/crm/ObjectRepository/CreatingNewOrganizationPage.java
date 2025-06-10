package com.concast.crm.ObjectRepository;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	

	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement orgName;

	@FindBy(name = "button")
	private WebElement savebtn;

	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industdrop;

	@FindBy(name = "accounttype")
	private WebElement typedrop;

	@FindBy(name = "phone")
	private WebElement phone;

	public WebElement getOrgName() {
		return orgName;
	}

	public void setOrgName(WebElement orgName) {
		this.orgName = orgName;
	}
	public WebElement getSavebtn() {
		return savebtn;
	}
	public WebElement getIndustdrop() {
		return industdrop;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getTypedrop() {
		return typedrop;
	}

	public void setTypedrop(WebElement typedrop) {
		this.typedrop = typedrop;
	}

	public void createOrg(String orgname) {

		orgName.sendKeys(orgname);
		savebtn.click();
	}

	public void createOrgWithIndust(String orgname, String indust, String type) {
		orgName.sendKeys(orgname);
		industdrop.sendKeys(indust);
		typedrop.sendKeys(type);
		savebtn.click();
		
	}

	public void createOrgWithPhone(String orgname, String phoneNo) {
		
		orgName.sendKeys(orgname);
		phone.sendKeys(phoneNo);
		savebtn.click();

	}

}

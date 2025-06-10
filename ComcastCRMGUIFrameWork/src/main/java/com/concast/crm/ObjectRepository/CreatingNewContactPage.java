package com.concast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class CreatingNewContactPage {
	
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgPlusIcon;

	@FindBy(id = "jscal_field_support_start_date")
	private WebElement startDate;

	@FindBy(id = "jscal_field_support_end_date")
	private WebElement endDate;

	@FindBy(name = "button")
	private WebElement saveButton;

	@FindBy(name = "search_text")
	private WebElement searchOnOrg;

	@FindBy(name = "search")
	private WebElement searchButton;

	public WebElement getSearchButton() {
		return searchButton;

	}

	public WebElement getSearchOrg() {
		return searchOnOrg;

	}

	public WebElement getConatactPage() {
		return contactLink;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOrgPlusIcon() {
		return orgPlusIcon;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public void craeteContact(String lastname) {
		lastName.sendKeys(lastname);
		saveButton.click();
	}

	public void createConatactWithDate(String lastname, String startdate, String enddate) {

		lastName.sendKeys(lastname);
		startDate.clear();
		startDate.sendKeys(startdate);
		endDate.clear();
		endDate.sendKeys(enddate);
		saveButton.click();

	}

	public void createContactWithOrg(WebDriver driver, String lastname, String orgname) {
		WebDriverUtility wdu=new WebDriverUtility();
		lastName.sendKeys(lastname);
		orgPlusIcon.click();
		wdu.switchToTabOnUrl(driver, "module=Accounts");
		searchOnOrg.sendKeys(orgname);
		searchButton.click();
		}
	
	

	public WebElement getStartDate() {
		return startDate;
	}

}

package com.concast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	WebDriver driver;
	
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "img[src='themes/softed/images/btnL3Add.gif']")
	private WebElement plusIcon;

	public WebElement getPlusIcon() {
		return plusIcon;
	}
	
	public void getCreateOrgPage() {
		plusIcon.click();
	}
}

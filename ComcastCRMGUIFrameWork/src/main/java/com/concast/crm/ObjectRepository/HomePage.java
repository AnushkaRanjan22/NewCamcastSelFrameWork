package com.concast.crm.ObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@href='index.php?action=index&module=Home']")
	private WebElement homeLink;
	
	@FindBy(linkText = "Calendar")
	private WebElement calendarLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(linkText = "Documents")
	private WebElement documentsLink;
	
	@FindBy(linkText = "Email")
	private WebElement emailLink;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signout;
	
	@FindBy(xpath = "//td[@class='small']/img[@src='themes/softed/images/user.PNG']")
	private WebElement adminitatorIcon;
	
	public WebElement getAdminitatorIcon() {
		return adminitatorIcon;
	}
	
	public WebElement getSignIOut() {
		return signout;
	}
	
	public WebElement getOrgPage() {
		return organizationsLink;
	}
	
	public void getHomePage() {
		homeLink.click();
	}

	public WebElement getHomeLink() {
		return homeLink;
	}

	public WebElement getCalendarLink() {
		return calendarLink;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getDocumentsLink() {
		return documentsLink;
	}

	public WebElement getEmailLink() {
		return emailLink;
	}
	
	public void logoutFromCrm() throws Throwable {
	WebDriverUtility wdu= new WebDriverUtility();
//	Thread.sleep(1000);
	try {
		wdu.mouseoverOnElement(driver, adminitatorIcon);
		signout.click();
	}
	catch(Exception e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", signout);
	}
		
	}
	
	public void clickOnOrg() {
		organizationsLink.click();
	}
	public void clickOnContact() {
		contactLink.click();
	}
	

}

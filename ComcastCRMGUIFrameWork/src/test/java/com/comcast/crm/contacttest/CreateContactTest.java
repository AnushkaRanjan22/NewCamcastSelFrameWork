
package com.comcast.crm.contacttest;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.concast.crm.ObjectRepository.ContactInformationPage;
import com.concast.crm.ObjectRepository.ContactsPage;
import com.concast.crm.ObjectRepository.CreatingNewContactPage;
import com.concast.crm.ObjectRepository.CreatingNewOrganizationPage;
import com.concast.crm.ObjectRepository.HomePage;
import com.concast.crm.ObjectRepository.OrganizationInformationPage;
import com.concast.crm.ObjectRepository.OrganizationsPage;
import com.crm.comcast.generic.baseUtility.BaseClass;

public class CreateContactTest extends BaseClass {
	
	@Test(groups = "regression")
	public void createContactTest() throws EncryptedDocumentException, IOException {

		// calling random number
		int random = ju.getRandomNum();

		String lastName = el.getDataFromExcelSheet("contact", 1, 2) + "" + random;
		// login in orgPage
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// click on contact plus icon
		ContactsPage cp = new ContactsPage(driver);
		cp.getPlusIcon().click();

		// create a contact page
		CreatingNewContactPage cnc = new CreatingNewContactPage(driver);
		cnc.craeteContact(lastName);

		// verify
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actlastName = cip.getLastNameVerify().getText();
		Assert.assertEquals(actlastName, lastName);
		Reporter.log("verify in createContact");
	}

	@Test(groups = "regression")
	public void createConatctWithIntigrationTest() throws EncryptedDocumentException, IOException {

		// calling random number
		int random = ju.getRandomNum();

		String orgName = el.getDataFromExcelSheet("org", 4, 2) + "" + random;
		String lastName = el.getDataFromExcelSheet("contact", 1, 2) + "" + random;

		// navigate to orgPage
		HomePage hp = new HomePage(driver);
		hp.clickOnOrg();

		// go to org page
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgPage();

		// creat org page
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createOrg(orgName);

		// verify header msg the data
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actorgNameHeader = oip.getHeaderOrgName().getText();
		boolean HearderOrg = actorgNameHeader.contains(orgName);
		Assert.assertEquals(true, HearderOrg);
		// going to contact page
		HomePage hp1 = new HomePage(driver);
		hp1.clickOnContact();

		// going to create contact
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnPlusIcon();

		// craete a contact with orgName
		CreatingNewContactPage cnc = new CreatingNewContactPage(driver);
		cnc.createContactWithOrg(driver, lastName, orgName);

		driver.findElement(By.xpath("//a[text()='" + orgName + "']")).click();

		// switch to window
		wdu.switchToTabOnUrl(driver, "module=Contacts");
		// save button
		CreatingNewContactPage cnc1 = new CreatingNewContactPage(driver);
		cnc1.getSaveButton().click();

		// verify
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actlastName = cip.getLastNameVerify().getText();
		Assert.assertEquals(actlastName, lastName);

		Reporter.log("verify in createContact with org last name and org name verify ");
		// verify the orgnization name from contact
		ContactInformationPage cip1 = new ContactInformationPage(driver);
		String actorg = cip1.getOrgNameVerify().getText();
		boolean HearderOrg1 = actorg.contains(orgName);
		Assert.assertEquals(true, HearderOrg1);
	}

	@Test(groups = "regression")
	public void createContactwithDateTest() throws Throwable {

		// creating a random number
		int random = ju.getRandomNum();

		String lastName = el.getDataFromExcelSheet("contact", 1, 2) + random;

		// fatch date frm javautility class
		String startDate = ju.getSystemDateYYYYMMDD();
		String endDate = ju.getSystemPlusThirtyDay();
		Reporter.log(endDate);

		// click on contact page
		HomePage hp = new HomePage(driver);
		hp.clickOnContact();

		// plus icon
		ContactsPage cp = new ContactsPage(driver);
		cp.getPlusIcon().click();

		// inter the last name
		CreatingNewContactPage cnp = new CreatingNewContactPage(driver);
		cnp.createConatactWithDate(lastName, startDate, endDate);

		// verify
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actStartDate = cip.getStartDateVerify().getText();
		Assert.assertEquals(actStartDate, startDate);

		ContactInformationPage cip1 = new ContactInformationPage(driver);
		String actEndDate = cip1.getEndDateVerify().getText();
		Reporter.log(actEndDate);

		Assert.assertEquals(actEndDate, endDate);
		Reporter.log("start date and last date verified");
	}

}

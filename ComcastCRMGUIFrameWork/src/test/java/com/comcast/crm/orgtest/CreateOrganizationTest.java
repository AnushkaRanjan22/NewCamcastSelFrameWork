package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.camcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.concast.crm.ObjectRepository.CreatingNewOrganizationPage;
import com.concast.crm.ObjectRepository.HomePage;
import com.concast.crm.ObjectRepository.OrganizationInformationPage;
import com.concast.crm.ObjectRepository.OrganizationsPage;
import com.crm.comcast.generic.baseUtility.BaseClass;

public class CreateOrganizationTest extends BaseClass {
	@Test
	public void createOrgTest() throws EncryptedDocumentException, IOException {

		// creating a random number
		//test11
		JavaUtility ju = new JavaUtility();
		int random = ju.getRandomNum();

		// create a object of excel class and fatch the data
		ExcelUtility el = new ExcelUtility();
		String orgName = el.getDataFromExcelSheet("org", 1, 2);
		UtilityClassObject.getTest().log(Status.INFO, "click on orgnization icon");

		// navigate to orgPage
		HomePage hp = new HomePage(driver);
		hp.clickOnOrg();

		// navigate to plus icon button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgPage();

		// create a org
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createOrg(orgName + random);

		// verify header msg the data
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actorgNameHeader = oip.getHeaderOrgName().getText();
		if (actorgNameHeader.contains(orgName)) {
			UtilityClassObject.getTest().log(Status.PASS,orgName + " header is successfully added==pass ");
		} else
			UtilityClassObject.getTest().log(Status.FAIL,orgName + " header is not created==fail");

		// verify the orgNameInfo
		OrganizationInformationPage oip1 = new OrganizationInformationPage(driver);
		String actorgNameBody = oip1.getBodyOrgName().getText();
		if (actorgNameBody.contains(orgName))
			UtilityClassObject.getTest().log(Status.PASS,orgName + "  body is successfully added==pass ");

		else
			UtilityClassObject.getTest().log(Status.FAIL,orgName + " body is not created==fail");

		UtilityClassObject.getTest().log(Status.INFO,"successfully create a orgnization");

	}

	@Test
	public void createOrgIndustTest() throws EncryptedDocumentException, IOException {

		JavaUtility ju = new JavaUtility();
		int random = ju.getRandomNum();

		ExcelUtility el = new ExcelUtility();
		String orgName = el.getDataFromExcelSheet("org", 4, 2);
		String indust = el.getDataFromExcelSheet("org", 4, 3);
		String type = el.getDataFromExcelSheet("org", 4, 4);

		// navigate to orgPage
		HomePage hp = new HomePage(driver);
		hp.clickOnOrg();

		// navigate to org page
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgPage();

		// navigate to createorg page
		CreatingNewOrganizationPage cpo = new CreatingNewOrganizationPage(driver);
		cpo.createOrgWithIndust(orgName + random, indust, type);

		// verify header organization the data
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String orgNameHeader = oip.getHeaderOrgName().getText();
		if (orgNameHeader.contains(orgName)) {
			UtilityClassObject.getTest().log(Status.PASS,orgName + " header is successfully added==pass ");
		} else
			UtilityClassObject.getTest().log(Status.FAIL,orgName + " header is not created==fail");

		// verify the orgNameInfo

		OrganizationInformationPage oip1 = new OrganizationInformationPage(driver);
		String orgNameBody = oip1.getBodyOrgName().getText();

		if (orgNameBody.contains(orgName))
			UtilityClassObject.getTest().log(Status.PASS,orgName + "  body is successfully added==pass ");

		else
			UtilityClassObject.getTest().log(Status.FAIL,orgName + " body is not created==fail");

		// verify the indust
		OrganizationInformationPage oip2 = new OrganizationInformationPage(driver);
		String industory = oip2.getOrgIndustInfo().getText();

		if (industory.contains(indust))
			UtilityClassObject.getTest().log(Status.PASS,indust + "  industory is successfully added==pass ");

		else
			UtilityClassObject.getTest().log(Status.FAIL,orgName + " industory is not created==fail");

		// verify the type
		String indtype = driver.findElement(By.xpath("//td[@id='mouseArea_Type']")).getText();
		if (indtype.contains(type))
			UtilityClassObject.getTest().log(Status.PASS,type + " type is successfully added==pass ");

		else
			UtilityClassObject.getTest().log(Status.FAIL,type + " type is not created==fail");

		System.out.println("successfully create a orgnization");

	}

	@Test
	public void createOrgWithPhoneTest() throws EncryptedDocumentException, IOException {
		JavaUtility ju = new JavaUtility();
		// creating a random number
		int random = ju.getRandomNum();

		ExcelUtility el = new ExcelUtility();
		String orgName = el.getDataFromExcelSheet("org", 4, 2);
		String phone = el.getDataFromExcelSheet("org", 4, 5);

		// navigate to orgPage
		HomePage hp = new HomePage(driver);
		hp.clickOnOrg();
		;

		// navigate to org page
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrgPage();

		// create a org with phone
		CreatingNewOrganizationPage cno = new CreatingNewOrganizationPage(driver);
		cno.createOrgWithPhone(orgName + random, phone);

		// verification
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actPhoneNo = oip.getPhoneVerify().getText();
		if (actPhoneNo.contains(phone)) {
			UtilityClassObject.getTest().log(Status.PASS,phone + " is successfully created");
		} else
			UtilityClassObject.getTest().log(Status.FAIL,phone + " no invalide");

	}

}

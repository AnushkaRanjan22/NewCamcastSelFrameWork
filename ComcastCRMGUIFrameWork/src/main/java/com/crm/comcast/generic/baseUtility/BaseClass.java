package com.crm.comcast.generic.baseUtility;

import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;
import com.camcast.crm.generic.fileutility.ExcelUtility;
import com.camcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.concast.crm.ObjectRepository.HomePage;
import com.concast.crm.ObjectRepository.WelcomePage;

@Listeners(com.camcast.crm.ListenerImp.ListenerImpClass.class)
public class BaseClass {
	public FileUtility flib = new FileUtility();
	public ExcelUtility el = new ExcelUtility();
	public JavaUtility ju = new JavaUtility();
	public WebDriverUtility wdu = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "ST", "RT" })
	public void configBeforSuit() {
		System.out.println("---connect database----");
	}

//	@Parameters("browser")
	@BeforeClass(groups = { "ST", "RT" })
	public void lunchTheBrowser() throws IOException {
		// UtilityClassObject.getTest().log(Status.INFO, "blowser lunched");
		// String Browser = flib.getDataFromProperties("browser");
		String Browser = System.getProperty("browser", flib.getDataFromProperties("browser"));
		// String url = flib.getDataFromProperties("url");
		String url = System.getProperty("url", flib.getDataFromProperties("url"));
		if (Browser.equals("chrome"))
			driver = new ChromeDriver();
		else if (Browser.equals("firefox"))
			driver = new FirefoxDriver();
		else if (Browser.equals("edge"))
			driver = new EdgeDriver();
		else
			System.out.println("driver is not given");

		sdriver = driver;
		UtilityClassObject.setDriver(driver);

		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// test.log(Status.INFO,"browser launched");
	}

	@BeforeMethod(groups = { "ST", "RT" })
	public void loginToCrm() throws IOException {
		// fatch data from properties file
		// UtilityClassObject.getTest().log(Status.INFO, "login");
		//String username = flib.getDataFromProperties("userName");
		//String password = flib.getDataFromProperties("password");
		
		String username=System.getProperty("username",flib.getDataFromProperties("userName"));
		String password=System.getProperty("password",flib.getDataFromProperties("password"));

		// login to crm
		WelcomePage wp = new WelcomePage(driver);
		wp.loginInCrm(username, password);
		// test.log(Status.INFO, "Login to app");
	}

	@AfterMethod(groups = { "ST", "RT" })
	public void logoutToCrm() throws Throwable {
		// get the signout
		UtilityClassObject.getTest().log(Status.INFO, "logout");
		HomePage hp = new HomePage(driver);
		hp.logoutFromCrm();
		// test.log(Status.INFO, "Logout from app");

	}

	@AfterClass(groups = { "ST", "RT" })
	public void closeTheBrowser() {
		UtilityClassObject.getTest().log(Status.INFO, "close the browser");
		driver.quit();
		// test.log(Status.INFO, "close the browser");

	}

	@AfterSuite(groups = { "ST", "RT" })
	public void configAfterSuit() {
		UtilityClassObject.getTest().log(Status.INFO, "close database connection");
		// test.log(Status.INFO, "---Disconnect DB----");
	}

}

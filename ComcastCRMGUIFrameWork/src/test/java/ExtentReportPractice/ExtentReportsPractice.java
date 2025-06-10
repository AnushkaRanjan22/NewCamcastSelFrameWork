package ExtentReportPractice;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.comcast.generic.baseUtility.BaseClass;

public class ExtentReportsPractice extends BaseClass {

		@Test
		public void CreateTest1() {
			ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
			spark.config().setDocumentTitle("crm test suite result");
			spark.config().setReportName("crm reporter");
			spark.config().setTheme(Theme.STANDARD);
		
			ExtentReports report=new ExtentReports();
			report.attachReporter(spark);
			report.setSystemInfo("OS", "WINDOWS_10");
			report.setSystemInfo("BROWSER", "CHROME_100");
			
			ExtentTest test=report.createTest("Create Contact Test");
		    
			test.log(Status.INFO,"TestCase-1.1");
			test.log(Status.INFO,"TestCase-1.2");
			String title = driver.getTitle();
			if(title.equals("home"))
			{
				test.log(Status.PASS,"Home Page");
			}
			else {
				test.log(Status.PASS,"It was not home page");
			}
			test.log(Status.INFO,"TestCase-1.3");
			test.log(Status.INFO,"TestCase-1.4");
			test.log(Status.INFO,"TestCase-1.5");
			report.flush();
		}
		@Test
		public void CreateTest2() {
            ExtentSparkReporter spark= new ExtentSparkReporter("./AdvanceReport/report1.html");
            spark.config().setDocumentTitle("Create Conatct test");
            spark.config().setReportName("Create Contct");
            spark.config().setTheme(Theme.DARK);
            
            ExtentReports report=new ExtentReports();
            report.attachReporter(spark);
            report.setSystemInfo("OS", "WINDOWS-10");
            report.setSystemInfo("BWOWSER", "CHROME-100");
           
            ExtentTest test=report.createTest("Contact Create");
            
			test.log(Status.INFO,"TestCase-2.1");
			test.log(Status.INFO,"TestCase-2.2");
			test.log(Status.INFO,"TestCase-2.3");
			test.log(Status.INFO,"TestCase-2.4");
			test.log(Status.INFO,"TestCase-2.5");
			report.flush();
		}

	}




package PracticeForListener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.generic.baseUtility.BaseClass;
//@Listeners(com.camcast.crm.ListenerImp.ListenerImpClass.class)
public class PracticeListener extends BaseClass{
	@Test(retryAnalyzer = com.camcast.crm.ListenerImp.RetryListenerImp.class )
	public void CreateTest1() {
		System.out.println("TestCase-1.1");
		System.out.println("TestCase-1.2");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Home");
		System.out.println("TestCase-1.3");
		System.out.println("TestCase-1.4");
		System.out.println("TestCase-1.5");
	}
	@Test
	public void CreateTest2() {
		System.out.println("TestCase-2.1");
		System.out.println("TestCase-2.2");
		System.out.println("TestCase-2.3");
		System.out.println("TestCase-2.4");
		System.out.println("TestCase-2.5");
	}

}

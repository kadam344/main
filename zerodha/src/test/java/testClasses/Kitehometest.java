package testClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClassUtility.Utility;
import pomClasses.Kitehome;
import pomClasses.Kitelogin;
import pomClasses.Kitelogin2;

public class Kitehometest {
	WebDriver driver ;
	Kitelogin login1;
	Kitelogin2 login2;
	Kitehome homepage1;
	String TcId;
	Utility base;
	
	@BeforeClass
	public void openbrowser() {
		Reporter.log("open browser");
		base = new Utility();
	driver = base.initializebrowser();
	
	// object of loginpom
	login1= new Kitelogin(driver);
	//pin pom object
	login2 = new Kitelogin2(driver);
	// home object
	homepage1= new Kitehome(driver);
	driver.navigate().refresh();
	}
	
	@BeforeMethod
	public void login() throws InterruptedException {
		Reporter.log("login to application");
		login1.enteruserid("DAA677");
		Thread.sleep(2000);
		login1.enterpassword("Velocity@123");

		login1.clickonlogin();
		Thread.sleep(2000);
		login2.enterpin("866918");
		login2.clickonctn();
	}
	@Test
	public void verifyuserid() throws InterruptedException {
		String actid = homepage1.getcrtuserid();
		String expid = "DAA677";
		Thread.sleep(5000);
		Assert.assertEquals(actid, expid);
	}
	@AfterMethod
	public void logout(ITestResult res) throws IOException, InterruptedException {
	if(res.getStatus()==res.FAILURE) {
			Utility.takescrshot(driver, TcId);
			
		}
		Reporter.log("logout from application");
		Thread.sleep(2000);
		homepage1.clickonuserid();
		homepage1.clickonlogout();
	}
	@AfterClass
	public void closebrowser() throws InterruptedException {
		Thread.sleep(2000);
	driver.close();
	}

}

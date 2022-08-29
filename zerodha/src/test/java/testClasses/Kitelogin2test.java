package testClasses;

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

public class Kitelogin2test extends Utility {
	WebDriver driver ;
	Kitelogin login1;
	Kitelogin2 login2;
	Kitehome homepage;
	
	@BeforeClass
	public void openbrowser() {
		Reporter.log("open browser");
	driver = initializebrowser();
	
	// object of loginpom
	login1= new Kitelogin(driver);
	//pin pom object
	login2 = new Kitelogin2(driver);
	// home object
	Kitehome homepage= new Kitehome(driver);
	}
	
	@BeforeMethod
	public void login() throws InterruptedException {
		Reporter.log("login to application");
		login1.enteruserid("DAA677");
		login1.enterpassword("Velocity@123");
		Thread.sleep(2000);
		login1.clickonlogin();
		login2.enterpin("866918");
		login2.clickonctn();
	}
	@Test
	public void verifyuserid() {
		Reporter.log("verify the id");
		String actid = homepage.getcrtuserid();
		String expid = "DAA677";
		Assert.assertEquals(actid, expid);
				
	}
	@AfterMethod
	public void logout(ITestResult res) {
		if(res.getStatus()==res.FAILURE) {
			
		}
		Reporter.log("logout from application");
	}
	@AfterClass
	public void closebrowser() {
		driver.close();
	}
}	
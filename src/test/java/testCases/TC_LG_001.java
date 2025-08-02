package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import testBase.BaseTestcaseClass;

public class TC_LG_001 extends BaseTestcaseClass {
	@Test
	public void testLogout() throws InterruptedException {
		logger.info("****Starting TC_LG_001****");
//		Home Page
		HomePage homObj = new HomePage(driver);
		homObj.clickMyAccounts();
		homObj.selectLogin();
		logger.info("Opening Login Page");
		
//		Login Page
		LoginPage logObj = new LoginPage(driver);
		logger.info("Entering Details");
		logObj.setEmail(prop.getProperty("email"));
		logObj.setPass(prop.getProperty("pass"));
		logObj.clickLogin();
		
		Thread.sleep(3000);
		homObj.clickMyAccounts();
		homObj.selectLogout();
		
		LogoutPage logOut = new LogoutPage(driver);
		logOut.clickContinue();
		
		homObj.clickMyAccounts();
		Assert.assertEquals(homObj.isLogoutPresent(), false);
		
		
		logger.info("Checking Output");		
		logger.info("****Finished TC_LG_001****");
	}
}

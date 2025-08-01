package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.BaseTestcaseClass;

public class TC_LF_001 extends BaseTestcaseClass {
	@Test(groups={"Sanity","Master"})
	public void testLogin() {
		logger.info("****Starting TC_LF_001****");
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
		logger.info("Checking Output");
		
//		MyAccount Page
		MyaccountPage myAccObj = new MyaccountPage(driver);
		boolean target = myAccObj.getConfirmation();
		if(target) {
			logger.info("Test Pass");
			Assert.assertTrue(true);
		} else {
			logger.error("Invalid Credentials");
			Assert.assertTrue(false);			
		}
		logger.info("****Finished TC_LF_001****");
	}
}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.LogoutPage;
import pageObjects.MyaccountPage;
import testBase.BaseTestcaseClass;
import utilities.Dataproviders;

public class TC003_LoginDatadrivenTest extends BaseTestcaseClass {
	@Test(dataProvider="loginData", dataProviderClass=Dataproviders.class)
	public void dataDrivenTest(String email, String pass, String valid) {
		logger.info("****Starting TC003_LoginDatadrivenTest****");
//		Home Page
		HomePage homObj = new HomePage(driver);
		homObj.clickMyAccounts();
		homObj.selectLogin();
		logger.info("Opening Login Page");
		
//		Login Page
		LoginPage logObj = new LoginPage(driver);
		logger.info("Entering Details");
		logObj.setEmail(email);
		logObj.setPass(pass);
		logObj.clickLogin();
		logger.info("Checking Output");
		
//		MyAccount Page
		MyaccountPage myAccObj = new MyaccountPage(driver);
		boolean target = myAccObj.getConfirmation();

//		Logout Page
		LogoutPage logout = new LogoutPage(driver);
		
//		Conditions
		if(target && valid.equals("valid")) {
			logger.info("Test Pass");
			homObj.clickMyAccounts();
			homObj.selectLogout();
			logout.clickContinue();
			logger.info("****Finished TC003_LoginDatadrivenTest****");
			Assert.assertTrue(true);
		} else if (target && valid.equals("Invalid")) {
			logger.info("Test Failed Invalid Data but Logged In");
			homObj.clickMyAccounts();
			homObj.selectLogout();
			logout.clickContinue();
			logger.info("****Finished TC003_LoginDatadrivenTest****");
			Assert.assertTrue(false);
		} else {
			logger.error("Invalid Credentials");
			logger.info("****Finished TC003_LoginDatadrivenTest****");
			Assert.assertTrue(false);			
		}
		
	}
}

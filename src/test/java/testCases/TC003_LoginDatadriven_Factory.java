package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.BaseTestcaseClass;

public class TC003_LoginDatadriven_Factory extends BaseTestcaseClass {
	private String email;
	private String pass;
	private String valid;
	
	public TC003_LoginDatadriven_Factory(String email, String pass, String valid) {
		this.email = email;
		this.pass = pass;
		this.valid = valid;
	}
	
	@Test(groups={"Datadriven"})
	public void dataDrivenTest() {
		logger.info("****Starting TC003_LoginDatadrivenTest****");
//		Home Page
		HomePage homObj = new HomePage(driver);
		homObj.clickMyAccounts();
		homObj.selectLogin();
		logger.info("Opening Login Page");
		
//		Login Page
		LoginPage logObj = new LoginPage(driver);
		logger.info("Entering Details");
		logObj.setEmail(this.email);
		logObj.setPass(this.pass);
		logObj.clickLogin();
		logger.info("Checking Output");
		
//		MyAccount Page
		MyaccountPage myAccObj = new MyaccountPage(driver);
		boolean target = myAccObj.getConfirmation();
		
//		Conditions
		if(target && this.valid.equals("valid")) {
			logger.info("Test Pass");
			logger.info("****Finished TC003_LoginDatadrivenTest****");
			Assert.assertTrue(true);
		} else if (target && this.valid.equals("Invalid")) {
			logger.info("Test Failed Invalid Data but Logged In");
			logger.info("****Failed TC003_LoginDatadrivenTest****");
			Assert.assertTrue(false);
		} else {
			logger.error("Invalid Credentials");
			logger.info("****Failed TC003_LoginDatadrivenTest****");
			Assert.assertTrue(false);			
		}
	}
}
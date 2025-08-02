package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseTestcaseClass;

public class TC_FP_001 extends BaseTestcaseClass {
	@Test
	public void testForgetLink() {
		logger.info("****Starting TC_FP_001****");
//		Home Page
		HomePage homObj = new HomePage(driver);
		homObj.clickMyAccounts();
		homObj.selectLogin();
		logger.info("Opening Login Page");
		
		LoginPage log = new LoginPage(driver);
		
		logger.info("Clicking on Forget Password");
		log.clickForgetPass();
		logger.info("Entering Email");
		log.setForgetEmail("demo5231@gmail.com");
		log.clickContinue();
		
		logger.info("Checking Results");
		Assert.assertEquals(log.isMessageDisplayed(), true);
		
		logger.info("****Finished TC_FP_001****");
	}
}

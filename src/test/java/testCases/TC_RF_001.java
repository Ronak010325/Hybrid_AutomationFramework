package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseTestcaseClass;

public class TC_RF_001 extends BaseTestcaseClass {
	@Test(groups={"Regression","Master"}) //enabled=false to disable the test method
	public void testReg() throws InterruptedException {
			logger.info("**** Starting TC_RF_001****");
			HomePage homeObj = new HomePage(driver);
			homeObj.clickMyAccounts();
			logger.info("Clicked in Register Btn");

			homeObj.selectRegistration();
			RegistrationPage regObj = new RegistrationPage(driver);
			String pass = randomPass();
			logger.info("Passing Details");

			regObj.setDetails(randomString().toUpperCase(), randomString().toUpperCase(), randomString()+"@gmail.com", randomNumber(), pass, pass, false, true);
			Thread.sleep(5000);
			regObj.clickRegister();
			logger.info("Validating Message");

			String expected = "Your Account Has Been Created!";
			if (expected.equals(regObj.getConfirmationMsg())) {
				Assert.assertTrue(true);
			} else {
				logger.error("Error Log");
				logger.debug("Debug Log");
				Assert.assertTrue(false);
			}
		logger.info("**** Finished TC_RF_001****");
	}
}
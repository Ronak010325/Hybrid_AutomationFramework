package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseTestcaseClass;

public class TC001_AccountRegistrationTest extends BaseTestcaseClass {
	@Test
	public void testReg() throws InterruptedException {
		try {
			logger.info("**** Starting TC001_AccountRegistrationTest****");
			HomePage homeObj = new HomePage(driver);
			homeObj.clickMyAccounts();
			logger.info("Clicked in Register Btn");

			homeObj.selectRegistration();
			RegistrationPage regObj = new RegistrationPage(driver);
			String pass = randomPass();
			logger.info("Passing Details");

			regObj.setDetails(randomString().toUpperCase(), randomString().toUpperCase(), randomString()+"@gmail.com", randomNumber(), pass, pass, true);
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
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC001_AccountRegistrationTest****");
	}
}
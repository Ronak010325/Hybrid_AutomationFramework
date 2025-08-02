package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.NewsLetterPage;
import pageObjects.RegistrationPage;
import testBase.BaseTestcaseClass;

public class TC_RF_006 extends BaseTestcaseClass {
	@Test
	public void testRegWithNo() throws InterruptedException {
		logger.info("**** Starting TC_RF_006****");
		HomePage homeObj = new HomePage(driver);
		homeObj.clickMyAccounts();
		logger.info("Clicked in Register Btn");

		homeObj.selectRegistration();
		RegistrationPage regObj = new RegistrationPage(driver);
		String pass = randomPass();
		logger.info("Passing Details");

		regObj.setDetails(randomString().toUpperCase(), randomString().toUpperCase(), randomString() + "@gmail.com", randomNumber(), pass, pass, false, true);
		Thread.sleep(5000);
		regObj.clickRegister();

		logger.info("Going to the NewsLetter Page");
		NewsLetterPage newsObj = new NewsLetterPage(driver);
		newsObj.clickNewLetter();

		if (newsObj.isSelectedNo()) {
			logger.info("No is Selected");
			Assert.assertTrue(true);
			logger.info("**** Finished TC_RF_002****");
		} else {
			logger.info("Yes is Selected even when in registration No is selected");
			logger.error("Error Log");
			logger.debug("Debug Log");
			Assert.assertTrue(false);
			logger.info("**** Finished TC_RF_006****");
		}
	}
}

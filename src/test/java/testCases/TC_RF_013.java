package testCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseTestcaseClass;

public class TC_RF_013 extends BaseTestcaseClass {
	@Test
	public void testFieldPlaceholders() {
		SoftAssert assertObj = new SoftAssert();
		logger.info("****Starting TC_RF_013****");
		HomePage homObj = new HomePage(driver);
		homObj.clickMyAccounts();
		homObj.selectRegistration();
		
		
		logger.info("Opened Registration Page");
		RegistrationPage regObj = new RegistrationPage(driver);
		logger.info("Getting Input Fields Placeholders");
		String[] actual = regObj.getPlaceholder();
		String[] expected = {"First Name", "Last Name", "E-Mail", "Telephone", "Password", "Password Confirm"};
		logger.info("Validating inputs");
		for(int i = 0 ; i < actual.length ; i++) {
			assertObj.assertEquals(actual[i], expected[i]);
		}
		assertObj.assertAll();
	}
}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseTestcaseClass;

public class TC_SF_001 extends BaseTestcaseClass {
	@Test
	public void testSearch() {
		logger.info("****Starting TC_SF_001****");
		HomePage home = new HomePage(driver);
		home.searchProduct("imac");
		
		SearchPage search = new SearchPage(driver);
		logger.info("Checking for results");
		Assert.assertEquals(search.getProductName().toLowerCase(), "imac");
	}
}

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseTestcaseClass;

public class TC_ATC_001 extends BaseTestcaseClass {
	@Test
	public void testCart() throws InterruptedException {
		logger.info("****Starting TC_ATC_001****");
		HomePage home = new HomePage(driver);
		logger.info("Searching iMac");
		home.searchProduct("iMac");
		
		SearchPage search = new SearchPage(driver);
		logger.info("Add to Cart");
		Thread.sleep(3000);
		search.addToCart();
		
		Thread.sleep(2000);
		logger.info("See Cart");
		search.seeCart();
		
		CartPage cart = new CartPage(driver);
		
		logger.info("Verify Adding");
		Assert.assertEquals(cart.isAdded(), true);
		logger.info("****Finished TC_ATC_001****");
	}
}

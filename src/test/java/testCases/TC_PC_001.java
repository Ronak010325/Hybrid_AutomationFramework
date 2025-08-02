package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.ProductCompairPage;
import pageObjects.ProductDisplayPage;
import pageObjects.SearchPage;
import testBase.BaseTestcaseClass;

public class TC_PC_001 extends BaseTestcaseClass {
	@Test
	public void testCompair() throws InterruptedException {
		HomePage home = new HomePage(driver);
		home.searchProduct("imac");
		
		SearchPage search = new SearchPage(driver);
		search.clickProduct();
		
		ProductDisplayPage dis = new ProductDisplayPage(driver);
		Thread.sleep(3000);
		dis.clickCompair();
		
		Thread.sleep(3000);
		if(dis.isMessageDisplayed()) {
			dis.clickLink();
			ProductCompairPage compair = new ProductCompairPage(driver);
			Assert.assertEquals(compair.isContainProduct("iMac"), true);
		} else {
			Assert.fail();
		}
	}
}

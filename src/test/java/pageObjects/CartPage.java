package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePageObjectClass;

public class CartPage extends BasePageObjectClass {
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class='dropdown-menu pull-right']//li[1]//tbody[1]//tr") WebElement product;
	
	public boolean isAdded() {
		try {
			return product.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePageObjectClass;

public class ProductDisplayPage extends BasePageObjectClass {
	public ProductDisplayPage(WebDriver driver) {
		super(driver);
	}
	
//	Locators
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement message;
	@FindBy(xpath="//div[@class='col-sm-4']//div[@class='btn-group']//button[2]") WebElement product_comparison;
	@FindBy(xpath="//a[normalize-space()='product comparison']")WebElement link;
	
//	Actions
	public void clickCompair() {
		product_comparison.click();
	}
	
	public boolean isMessageDisplayed() {
		try {			
			return message.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clickLink() {
		link.click();
	}
	
}

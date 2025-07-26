package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePageObjectClass;

public class MyaccountPage extends BasePageObjectClass{
	public MyaccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement confirmation;
	
	public boolean getConfirmation() {
		try {
			return confirmation.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	
}

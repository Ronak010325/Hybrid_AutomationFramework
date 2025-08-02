package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePageObjectClass;

public class HomePage extends BasePageObjectClass {
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	
//	Locators
	@FindBy(xpath="//a[@title='My Account']") WebElement nav_Reg_Link;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement nav_Reg_Btn;
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement nav_log_Btn;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']") WebElement nav_logout_Btn;
	@FindBy(xpath="//input[@placeholder='Search']") WebElement search_field;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']") WebElement search_btn;
	
//	Actions
	public void clickMyAccounts() {
		nav_Reg_Link.click();
	}
	
	public void selectRegistration() {
		nav_Reg_Btn.click();
	}
	
	public void selectLogin() {
		nav_log_Btn.click();
	}
	
	public void selectLogout() {
		nav_logout_Btn.click();
	}
	
	public boolean isLogoutPresent() {
		try {			
			return nav_logout_Btn.isDisplayed();
		} catch(Exception e) {
			return false;
		}
	}
	
	public void searchProduct(String product) {
		search_field.sendKeys(product);
		search_btn.click();
	}
	
}
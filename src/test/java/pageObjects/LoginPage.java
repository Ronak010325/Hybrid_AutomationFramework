package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePageObjectClass;

public class LoginPage extends BasePageObjectClass {
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-email']") WebElement email_field;
	@FindBy(xpath="//input[@id='input-password']") WebElement pass_field;
	@FindBy(xpath="//input[@value='Login']") WebElement login_btn;
	
	public void setEmail(String email) {
		email_field.sendKeys(email);
	}
	
	public void setPass(String pass) {
		pass_field.sendKeys(pass);
	}
	
	public void clickLogin() {
		login_btn.click();
	}
}

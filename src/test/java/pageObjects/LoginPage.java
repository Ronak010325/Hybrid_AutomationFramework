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
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']") WebElement forgetPass_btn;
	@FindBy(xpath="//input[@id='input-email']") WebElement forgetPass_email_field;
	@FindBy(xpath="//input[@value='Continue']") WebElement continue_btn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement message;
	
	public void setEmail(String email) {
		email_field.sendKeys(email);
	}
	
	public void setPass(String pass) {
		pass_field.sendKeys(pass);
	}
	
	public void clickLogin() {
		login_btn.click();
	}
	
	public void clickForgetPass() {
		forgetPass_btn.click();
	}

	public void setForgetEmail(String email) {
		forgetPass_email_field.sendKeys(email);
	}
	
	public void clickContinue() {
		continue_btn.click();
	}
	
	public boolean isMessageDisplayed() {
		try {
			return message.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
}

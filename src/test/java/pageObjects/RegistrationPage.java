package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePageObjectClass;

public class RegistrationPage extends BasePageObjectClass {
	public RegistrationPage (WebDriver driver) {
		super(driver);
	}
	
	
//	Locators
	@FindBy(xpath="//input[@id='input-firstname']") WebElement firstName_Field;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lastName_Field;
	@FindBy(xpath="//input[@id='input-email']") WebElement email_Field;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement telephone_Field;
	@FindBy(xpath="//input[@id='input-password']") WebElement password_Field;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement passwordConfirm_Field;
	@FindBy(xpath="//input[@name='agree']") WebElement agreeCheckBox;
	@FindBy(xpath="//input[@value='Continue']") WebElement register_Btn;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirmation;
	

//	Actions
	public void setDetails(String firstName, String lastName, String email, String telephone, String pass, String confirmPass, boolean agree) {
		firstName_Field.sendKeys(firstName);
		lastName_Field.sendKeys(lastName);
		email_Field.sendKeys(email);
		telephone_Field.sendKeys(telephone);
		password_Field.sendKeys(pass);
		passwordConfirm_Field.sendKeys(confirmPass);
		if(agree) {
			agreeCheckBox.click();
		}
	}
	
	public void clickRegister() {
		register_Btn.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return confirmation.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}

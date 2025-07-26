package testBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageObjectClass {
	WebDriver driver;
	public BasePageObjectClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}

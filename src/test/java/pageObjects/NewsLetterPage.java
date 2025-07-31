package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePageObjectClass;

public class NewsLetterPage extends BasePageObjectClass {
	
	public NewsLetterPage (WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Newsletter']") WebElement newLetterBtn;
	@FindBy(xpath="//input[@value='0']") WebElement NoRadioBtn;
	
	public void clickNewLetter() {
		newLetterBtn.click();
	}

	public boolean isSelectedNo() {
		return NoRadioBtn.isSelected();
	}
}

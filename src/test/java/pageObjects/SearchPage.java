package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePageObjectClass;

public class SearchPage extends BasePageObjectClass {
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
//	Locators
	@FindBy(xpath="//div[@class='caption']//h4") WebElement product_Title;
	@FindBy(xpath="//div[@class='caption']//h4/a") WebElement product;
	@FindBy(xpath="//div[@class='row'][3]/div//button[1]") WebElement addToCart;
	@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']") WebElement CartButton;
	
//	Action
	public void addToCart() {
		addToCart.click();
	}
	
	public String getProductName() {
		try {
			return product_Title.getText();
		} catch (Exception e) {
			return "No Result Found";
		}
	}

	public void clickProduct() {
		try {
			product.click();
		} catch(Exception e) {
			System.out.println("No product Found");
		}
	}
	
	public void seeCart() {
		CartButton.click();
	}
	
}

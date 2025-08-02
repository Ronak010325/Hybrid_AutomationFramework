package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.BasePageObjectClass;

public class ProductCompairPage extends BasePageObjectClass {
	public ProductCompairPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//tbody[1]/tr[1]/td[2]") WebElement product_title;
	
	public boolean isContainProduct(String product) {
		try {
			String prod = product.toLowerCase();
			String title = product_title.getText().toLowerCase(); 
			return title.equals(prod);
		} catch (Exception e) {
			return false;
		}
	}
	
}

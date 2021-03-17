/**
* @author  Ajith Manjunath
* @date    04-Sep-2019
* Purpose:	To have collective page locator for Home page
*/
package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.utils.GenericFunctions;
import framework.utils.DriverFactory;

public class ProductPageObjects extends DriverFactory {

	@FindBy(xpath = "//h1[@class='product-header__title']")
	public WebElement productHeader;

	@FindBy(id = "button--add-to-basket")
	public WebElement cartSubmitButton;

	@FindBy(xpath = "//a[@class='add-to-basket-view-basket-link']")
	public WebElement goToYourBasket;
	
	@FindBy(id = "link-button--basket-continue-securely")
	public WebElement continueToCheckout;


	static Logger log = Logger.getLogger(ProductPageObjects.class.getName());
	GenericFunctions genericFunctions = PageFactory.initElements(driver, GenericFunctions.class);

	// To implement page actions
	public void CreateOrder() {
		try {
			genericFunctions.clickOnElementJs(cartSubmitButton);
			genericFunctions.waitWebDriver(3000);
			genericFunctions.clickOnElementJs(goToYourBasket);
			genericFunctions.waitWebDriver(3000);
			genericFunctions.clickOnElementJs(continueToCheckout);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

}

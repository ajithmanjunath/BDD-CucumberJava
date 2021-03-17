/**
 * @author  Ajith Manjunath
 * @date    07-Sep-2019
 * Purpose:	To have collective page locator for checkout page
 */
package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import framework.utils.DriverFactory;
import framework.utils.GenericFunctions;

public class CheckoutPageObjects extends DriverFactory{

	static Logger log = Logger.getLogger(CheckoutPageObjects.class.getName());
	GenericFunctions genericFunctions = PageFactory.initElements(driver, GenericFunctions.class);

	@FindBy(xpath="(//input[@type='radio'])[2]")
	public WebElement guestCheckout;

	@FindBy(id="email")
	public WebElement guestEmail;

	@FindBy(id="loginForm")
	public WebElement continueAsGuest;

	@FindBy(xpath="//button[@data-id='delivery']")
	public WebElement delivery;

	@FindBy(id="title")
	public WebElement title;

	@FindBy(id="firstName")
	public WebElement firstName;

	@FindBy(id="lastName")
	public WebElement lastName;

	@FindBy(id="phoneNumber-number")
	public WebElement phoneNumber;

	@FindBy(id="searchPostcode")
	public WebElement searchPostcode;

	@FindBy(id="postcodeSearchForm")
	public WebElement findAddress;

	@FindBy(id="addressSearchSelect")
	public WebElement addressSearchSelect;

	@FindBy(xpath="//select[@id='addressSearchSelect']/option[@value='0']")
	public WebElement selectAddress;

	@FindBy(xpath="//button[@data-test='delivery-address-use-address']")
	public WebElement useThisAddress;

	//To check out product as guest
	/**
	 * @param testData
	 */
	public void checkoutOrderAsGuest(String testData){
		try{
			genericFunctions.clickOnElementJs(guestCheckout);
			//genericFunctions.waitWebDriver(1500);
			genericFunctions.clickOnElementJs(guestEmail);
			//genericFunctions.waitWebDriver(1500);
			genericFunctions.enterText(guestEmail, genericFunctions.getTestData(testData, "email"));
			genericFunctions.waitWebDriver(3000);
			genericFunctions.clickOnElementJs(continueAsGuest);	

		}catch(Exception e){
			e.printStackTrace();
			log.error("Failed: checkoutOrderAsGuest()");
		}
	}

	//To have delivery option and to fill in required details
	/**
	 * @param testData
	 */
	public void deliveryOption(String testData){
		try{
			genericFunctions.waitWebDriver(1500);
			genericFunctions.clickOnElementJs(delivery);
			//genericFunctions.waitWebDriver(3000);
			genericFunctions.enterText(title, genericFunctions.getTestData(testData, "title"));
			genericFunctions.enterText(firstName, genericFunctions.getTestData(testData, "firstName"));
			genericFunctions.enterText(lastName, genericFunctions.getTestData(testData, "lastName"));
			genericFunctions.enterText(phoneNumber, genericFunctions.getTestData(testData, "phoneNumber"));
			genericFunctions.enterText(searchPostcode, genericFunctions.getTestData(testData, "postcode"));
			//genericFunctions.waitWebDriver(1500);
			genericFunctions.clickOnElementJs(findAddress);
			//genericFunctions.waitWebDriver(1500);
			genericFunctions.clickOnElementJs(useThisAddress);

		}catch(Exception e){
			e.printStackTrace();
			log.error("Failed: deliveryOption()");
		}
	}
}

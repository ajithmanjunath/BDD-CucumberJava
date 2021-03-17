/**
* @author  Ajith Manjunath
* @date    08-Sep-2019
* Purpose:	To have collective page locator for delivery page
*/
package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.listener.Reporter;

import framework.utils.DriverFactory;
import framework.utils.GenericFunctions;

public class DeliveryPageObjects extends DriverFactory {

	@FindBy(xpath = "//span[@data-test='address-address-line-1']")
	public WebElement addressLine1;

	@FindBy(xpath = "//span[@data-test='address-address-line-2']")
	public WebElement addressLine2;

	@FindBy(xpath = "//span[@data-test='address-address-line-3']")
	public WebElement addressLine3;

	@FindBy(xpath = "//span[@data-test='address-town-or-city']")
	public WebElement addressTownOrCity;

	@FindBy(xpath = "//span[@data-test='address-postcode']")
	public WebElement addressPostcode;

	// @FindBy(xpath="//div[@class='delivery_container__9707e']//div[2]//div[1]//input")
	@FindBy(id = "deliveryMethod-5:5")
	public WebElement nextOrNamedDayDelivery;

	@FindBy(xpath = "//span[contains(text(),'Continue to payment')]")
	public WebElement continueToPayment;

	@FindBy(xpath = "	//p[@data-test='day-picker-additional-information']")
	public WebElement deliveryTime;

	static Logger log = Logger.getLogger(DeliveryPageObjects.class.getName());
	GenericFunctions genericFunctions = PageFactory.initElements(driver, GenericFunctions.class);
	public static Calendar dateValue;
	public static String time;

	/**
	 * @param testData
	 *            asserts the displayed address
	 */
	public void assertDisplayedAddress(String testData) {
		try {
			genericFunctions.verifyText(addressLine1, genericFunctions.getTestData(testData, "addressLine1"));
			genericFunctions.verifyText(addressLine2, genericFunctions.getTestData(testData, "addressLine2"));
			genericFunctions.verifyText(addressLine3, genericFunctions.getTestData(testData, "addressLine3"));
			genericFunctions.verifyText(addressTownOrCity, genericFunctions.getTestData(testData, "addressTownOrCity"));
			genericFunctions.verifyText(addressPostcode, genericFunctions.getTestData(testData, "postcode"));
			Reporter.addScenarioLog("Verified and validated user address");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Failed: assertDisplayedAddress()");
		}
	}

	/**
	 * @param testData
	 *            select next or named delivery
	 */
	/**
	 * @param testData
	 */
	public void selectDeliveryType(String testData) {
		try {
			genericFunctions.clickOnElementJs(nextOrNamedDayDelivery);
			Calendar dateValue = genericFunctions.dateIncrementer(2);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
			String incrementedDate = formatter.format(dateValue.getTime());
			String[] date = incrementedDate.split("-");
			System.out.println("incrementedDate " + incrementedDate);
			
			String locator = "//span[contains(text(),'" + date[0] + "')]//span[contains(text(),'" + date[1] + "')]";
			System.out.println("Locator made" + locator);
			genericFunctions.clickOnElementJs(getDriver().findElement(By.xpath(locator)));
		//	genericFunctions.waitWebDriver(1500);
			time = deliveryTime.getText().toString().substring(59,71);
			log.info("Delivery Time"+time);
			genericFunctions.submitElement(continueToPayment);
			;
			// genericFunctions.clickOnElement(addressLine1);
			//genericFunctions.waitWebDriver(1500);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Failed: selectDeliveryType()");
		}
	}
}

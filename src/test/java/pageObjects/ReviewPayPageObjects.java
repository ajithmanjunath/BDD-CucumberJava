/**
 * @author  Ajith Manjunath
 * @date    08-Sep-2019
 * Purpose:	To have collective page locator for review page
 */
package pageObjects;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.utils.DriverFactory;
import framework.utils.GenericFunctions;

public class ReviewPayPageObjects extends DriverFactory {

	static Logger log = Logger.getLogger(ReviewPayPageObjects.class.getName());
	GenericFunctions genericFunctions = PageFactory.initElements(driver, GenericFunctions.class);
	DeliveryPageObjects deliveryPage = PageFactory.initElements(driver, DeliveryPageObjects.class);

	@FindBy(xpath = "(//p[@data-test='delivery-details-message']//strong)[1]")
	public WebElement deliveryDate;
	

	@FindBy(xpath = "(//p[@data-test='delivery-details-message']//strong)[2]")
	public WebElement deliveryDateString;


	// To verify and validate delivery address
	public void validateDeliveryAddress() {
		try {
			// Calendar calendar = Calendar.getInstance();
			Calendar dateValue = genericFunctions.dateIncrementer(2);
			Date date = dateValue.getTime();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMMM-yyyy");
			String[] expectedDate = formatter.format(date).split("-");
			String[] actualDate = deliveryDate.getText().toString().split(" ");
			// asserting day
			System.out.println("expectedDate[0]" + expectedDate[0] + " AND " + "actualDate[1] " + actualDate[1]);
			Assert.assertEquals(expectedDate[0], actualDate[1]);
			// asserting month
			System.out.println("expectedDate[1]" + expectedDate[1] + " AND " + "actualDate[2] " + actualDate[2]);
			Assert.assertEquals(expectedDate[1], actualDate[2]);
			Assert.assertEquals(DeliveryPageObjects.time, deliveryDateString.getText().toString());

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
}

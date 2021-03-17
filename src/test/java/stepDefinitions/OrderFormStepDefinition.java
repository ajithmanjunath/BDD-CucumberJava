/**
 * @author  Ajith Manjunath
 * @date    04-Sep-2019
 * Purpose:	Step definition file for sample feature
 */
package stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.utils.DriverFactory;
import framework.utils.GenericFunctions;
import pageObjects.CheckoutPageObjects;
import pageObjects.DeliveryPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.ProductPageObjects;
import pageObjects.ReviewPayPageObjects;

public class OrderFormStepDefinition extends DriverFactory {

	//declaring all pages required
	HomePageObjects homePage = PageFactory.initElements(driver, HomePageObjects.class);
	ProductPageObjects productPage = PageFactory.initElements(driver, ProductPageObjects.class);
	CheckoutPageObjects checkoutPage = PageFactory.initElements(driver, CheckoutPageObjects.class);
	DeliveryPageObjects deliveryPage = PageFactory.initElements(driver, DeliveryPageObjects.class);
	ReviewPayPageObjects reviewPayPageObjects = PageFactory.initElements(driver, ReviewPayPageObjects.class);
	GenericFunctions genericFunctions = PageFactory.initElements(driver, GenericFunctions.class);
	static Logger log = Logger.getLogger(OrderFormStepDefinition.class.getName());

	/**
	 * @param testData
	 * @throws Throwable
	 */
	@Given("^User navigates to the web site \"([^\"]*)\"$")
	public void user_navigates_to_the_website(String testData) throws Throwable {

		getDriver().get(genericFunctions.getTestData(testData, "url"));
		//genericFunctions.waitWebDriver(3000);
	
		try {

			if (getDriver().findElement(By.xpath("//div[@id='monetate_allinone_lightbox']")) != null) {
				System.out.println("cookies box found");
				genericFunctions.clickOnElementJs(homePage.acceptCookies);
			} else {
				System.out.println("Cookie box not found");
				if (getDriver().findElement(By.xpath("//a[@data-test='close']")) != null) {
					System.out.println("Privacy box found");
					genericFunctions.clickOnElementJs(homePage.privacyMessageBox);
				}
				log.info("HomePage:Completed navigation to website");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Could not find any cookie box");
			e.printStackTrace();
		}
	}

	/**
	 * @param testData
	 * @throws Throwable
	 */
	@When("^search for the product \"([^\"]*)\"$")
	public void i_search_for_the_product(String testData) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		homePage.searchProduct(testData);
		log.info("able to search products");
	}

	/**
	 * @param testData
	 * @throws Throwable
	 */
	@When("^checkout selected product as guest \"([^\"]*)\"$")
	public void i_checkout_selected_product_as_guest(String testData) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		checkoutPage.checkoutOrderAsGuest(testData);
		log.info("ProductPage:Successfully checked out as Guest");
		
		checkoutPage.deliveryOption(testData);
		log.info("DeliveryPage:selected delivery option");
	}

	@When("^select next or named day delivery option \"([^\"]*)\"$")
	public void i_select_next_or_named_day_delivery_option(String testData) throws Throwable {
		
		deliveryPage.assertDisplayedAddress(testData);
		log.info("DeliveryPage:Address details validated");
		
		deliveryPage.selectDeliveryType(testData);
		log.info("DeliveryPage:Selected named delivery option");
		
	}

	@Then("^I validate the delivery date and time on Review and pay page$")
	public void i_validate_the_delivery_date_and_time_on_Review_and_pay_page() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		reviewPayPageObjects.validateDeliveryAddress();
		log.info("ReviewPayPage:Valiated the deivery address on review page");
		
		GenericFunctions.captureScreenshot();
		log.info("ReviewPayPage:captured screenshot of review page");
	}

}

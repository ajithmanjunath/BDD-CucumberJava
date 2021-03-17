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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import framework.utils.GenericFunctions;
import framework.utils.DriverFactory;

public class HomePageObjects extends DriverFactory{

	@FindBy(id="desktopSearch")
	public WebElement iSearchBox;

	@FindBy(xpath="//input[@id='desktopSearch']/following-sibling::button")
	public WebElement iSearchButton;

	@FindBy(xpath="//div[@id='monetate_allinone_lightbox']")
	public WebElement cookieComplianceBox;

	@FindBy(xpath="//button[.='Continue']")
	public WebElement acceptCookies;
	
	@FindBy(xpath="//a[@data-test='close']")
	public WebElement privacyMessageBox;

	static Logger log = Logger.getLogger(HomePageObjects.class.getName());
	GenericFunctions genericFunctions = PageFactory.initElements(driver, GenericFunctions.class);
	ProductPageObjects productPage = PageFactory.initElements(driver, ProductPageObjects.class);

	// To implement page actions
	/**
	 * @param searchKey
	 */
	public void searchProduct(String searchKey) {
		try {
			//set of actions for home dashboard
			String TestData = genericFunctions.getTestData(searchKey,"productName");
			genericFunctions.enterText(iSearchBox,TestData);
			genericFunctions.clickOnElementJs(iSearchButton);
			genericFunctions.isElementDisplayed(productPage.productHeader);
			productPage.CreateOrder();

		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	//To check for cookie compliance and accept cookies
	public void checkCookieCompliance() throws InterruptedException
	{
		WebDriverWait wait =  new WebDriverWait(getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(cookieComplianceBox));
		try{
			if(genericFunctions.isElementDisplayed(cookieComplianceBox))
				genericFunctions.clickOnElementJs(acceptCookies);

		}catch(Exception e)
		{
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	
}

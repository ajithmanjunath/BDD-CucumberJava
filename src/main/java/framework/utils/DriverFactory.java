/**
* @author  Ajith Manjunath
* @date    04-Sep-2019
* Purpose:	To have driver initiations as utilities.
*/
package framework.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

	public static WebDriver driver;

	//Initiation of browser instance
	public WebDriver getDriver() {
		try {

			ReadConfigFile readConfFile = new ReadConfigFile();
			String browserName = readConfFile.getBrowser();

			switch (browserName) {
			// selection of browser case depending in inputs
			case "chrome":
				if (driver == null) {
					System.setProperty(Constants.CHROME_KEY, Constants.CHROME_VALUE);
					Map<String, Integer> prefs = new HashMap<String, Integer>();
					prefs.put("profile.default_content_settings.cookies", 2);
					ChromeOptions options = new ChromeOptions();
					options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
					options.setAcceptInsecureCerts(true);
					options.setExperimentalOption("prefs",prefs);
					driver = new ChromeDriver(options);
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
				break;

			case "firefox":
				if (driver == null) {
					System.setProperty(Constants.FIREFOX_KEY, Constants.FIREFOX_VALUE);
					FirefoxOptions options = new FirefoxOptions();
					options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
					options.setAcceptInsecureCerts(true);
					driver = new FirefoxDriver(options);
					driver.manage().deleteAllCookies();
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				}
				break;

			case "ie":
				break;

			default:
				break;

			}
		}

		catch (Exception e) {

			// TODO: handle exception
			e.printStackTrace();
		}

		finally {

			driver.manage().timeouts().implicitlyWait(Constants.MID_WAIT, TimeUnit.SECONDS);
		}

		return driver;
	}
}
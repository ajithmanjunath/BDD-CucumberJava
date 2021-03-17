/**
* @author  Ajith Manjunath
* @date    04-Sep-2019
* Purpose:	Master Hooks
*/
package framework.utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;

public class Hooks extends DriverFactory {
	
	public static String featureName;
	public static String scenarioName;
	
	static Logger log = Logger.getLogger(Hooks.class.getName());

	
	@Before
	//Initiating the browser session 
	public void setup(Scenario scenario) {
		driver = getDriver();
		System.out.println("Printing before method from the hooks");
		scenarioName = scenario.getName();
		System.out.println("Scenario Name"+scenarioName);
		featureName = scenario.getId().split(";")[0].replaceAll("-","_");
		System.out.println("Printing feature name in hooks"+featureName);
		log.info("Starting Execution |Feature File : " +featureName+"Scenario Name :"+scenarioName );
	}

	@After
	//Ending browser session and on failure by capturing the screenshot and ending the browser session 
	public void screenshotOnFailureAndTearDown(Scenario scenario) {
		try {
			if (driver != null && scenario.isFailed()) {
				GenericFunctions.captureScreenshot();
				driver.manage().deleteAllCookies();
				driver.close();
				driver.quit();
				driver = null;
			}
			if (driver != null) {
				driver.manage().deleteAllCookies();
				driver.close();
				driver.quit();
				driver = null;
			}
		} catch (Exception e) {
			System.out.println("Methods failed: tearDownAndScreenshotOnFailure, Exception: " + e.getMessage());
		}
	}
}

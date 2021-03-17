/**
* @author  `Ajith Manjunath`
* @date    04-Sep-2019
* Purpose:	To declare and define constants used across project.
*/
package framework.utils;

public class Constants {
	
	public final static String 
	
			CONFIG_PROPERTY_DIR = System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties",
			LOG4J_PROPERTY_DIR = System.getProperty("user.dir")+"\\src\\main\\resources\\Properties\\log4j.properties",
			CHROME_KEY = "webdriver.chrome.driver",
			CHROME_VALUE = System.getProperty("user.dir")+"\\Drivers\\win\\chromedriver.exe",
			FIREFOX_KEY = "webdriver.firefox.marionette",
			FIREFOX_VALUE = System.getProperty("user.dir")+"\\Drivers\\win\\geckodriver.exe",		
			SWITCH = "SWITCH",
			ACCEPT = "ACCEPT",
			DISMISS = "DISMISS",
			GETTEXT = "GETTEXT";
	
	public final static int 
	
			MIN_WAIT = 30,
			MID_WAIT = 60,
			MAX_WAIT = 120;
}

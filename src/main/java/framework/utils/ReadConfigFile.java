/**
* @author  Ajith Manjunath
* @date    04-Sep-2019
 * Purpose:	To load and read certain configuration required.
 */
package framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class ReadConfigFile {

	protected FileInputStream input = null;
	protected Properties property = null;
	
	//To read configuration files
	public ReadConfigFile() {
		try {
			property = new Properties();
			property.load(new FileInputStream(Constants.CONFIG_PROPERTY_DIR));
			property.load(new FileInputStream(Constants.LOG4J_PROPERTY_DIR));
			PropertyConfigurator.configure(property);
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	//To get browser property
	public String getBrowser() {
		if (property.getProperty("browser") == null)
			return null;
		return property.getProperty("browser");
	}
	
	//To get json data path
	public String getJsonDataPath()
	{
		if (property.getProperty("testdataPath") == null)
			return null;
		return property.getProperty("testdataPath");
	}
	
	

}

/**
* @author  Ajith Manjunath
* @date    04-Sep-2019
 * Purpose:	To have runner class for initiation of all test execution.
 */

package cucumberRunner;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
/*import cucumber.api.junit.Cucumber;*/
import cucumber.api.testng.AbstractTestNGCucumberTests;
import framework.utils.GenericFunctions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
		retryCount = 0,
		detailedReport = true,
		detailedAggregatedReport = true,
		overviewReport = true,
		coverageReport = true,
		jsonUsageReport = "target/cucumber.json",
		usageReport = true,
		toPDF = true,
		excludeCoverageTags = { "@flaky" },
		includeCoverageTags = { "@passed" },
		// outputFolder = {"target"}
		formats = { "pretty", "html:target/cucumber", "json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/report.html" })

// @RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Features/Order_Form.feature" },

		glue = { "framework.utils", "stepDefinitions" },
		monochrome = true,
		tags = {},
		plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json",
				"com.cucumber.listener.ExtentCucumberFormatter:target/report.html" })

public class TestRunner extends AbstractTestNGCucumberTests {
	@BeforeClass
	public static void setUp() {
		// To validate the run time environment
		GenericFunctions.validateEnvironment();
	}

	@AfterClass
	public static void generateExtentReport() throws IOException {

		Reporter.loadXMLConfig(
				System.getProperty("user.dir") + "\\src\\main\\java\\framework\\utils\\extent-config.xml");
		// To back up the reports after execution
		GenericFunctions.backUpExtentReport();
	}

}

package contacts;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import framework.DataUtil;
import framework.Driver;
import framework.EventMethods;
import framework.ReporterUtil;
import framework.Utilities;

public class ConfigurationMethods extends EventMethods{
	protected HashMap<String, String> envData;
	protected ReporterUtil reporter;
	@BeforeTest
	public void beforeTest(ITestContext testContext) {
		reporter = new ReporterUtil();
		
		String curSuiteName = testContext.getCurrentXmlTest().getSuite().getName();
		String curTestName = testContext.getCurrentXmlTest().getName();
		reporter.initializeReport(curTestName, curSuiteName);
		
	}
	
	@AfterTest
	public void afterTest() {
	  reporter.finalizeReport();
	}
	
	@Parameters("env")
	@BeforeSuite
	public void beforeSuite(String env) {
	  EventMethods.killProcesses();
	  envData = (new DataUtil()).getPropertiesData(DataUtil.getEnvConfigFile(env));		
	}
	
	@AfterSuite
	public void afterSuite() {
	  System.out.println("I am in after suite.");	
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser, Method method) {
		reporter.createTest(method.getName());
		Driver.createInstace(browser, envData.get("url"));
	}
	
	@AfterMethod
	public void afterMethod() {
		Driver.quitDriver();
	}
	

}

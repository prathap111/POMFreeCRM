package tests.employeeManagement;

import java.io.IOException;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import framework.Driver;
import framework.EventMethods;
import framework.ReporterUtil;

public class SampleTestCases extends EventMethods{

	public static void main(String[] args) throws IOException {
		
		ReporterUtil reportUtil = new ReporterUtil();
		
		reportUtil.intializeReport("Regression_26-11-2021", "Regression Execuction for Sprint - 15");
		
		reportUtil.createTest("Sample Test Case");
		Driver.createInstace("chrome", "https://opensource-demo.orangehrmlive.com/");
		
		if (getElement(By.id("txtUsername"), 20) != null) {
			reportUtil.writeLog(Status.PASS, "Application is launched successfully.");
		} else {
			reportUtil.writeLog(Status.FAIL, "Application is not launched properly.", "LoginPage");
		}
		
		enterValue(By.id("txtUsername"), "Admin");
		enterValue(By.id("txtPassword"), "admin123");
		clickElement(By.id("btnLogin"), 20);
		
		if (getElement(By.id("welcome"), 30) != null) {
			reportUtil.writeLog(Status.PASS, "Login is successful","Login_Success");
		} else {
			reportUtil.writeLog(Status.FAIL, "Login is not success", "Login_Fail");
		}
		
		Driver.get().quit();
		
		reportUtil.finalizeReport();

	}

}

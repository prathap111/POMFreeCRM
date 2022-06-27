package sample;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import contacts.ConfigurationMethods;
import framework.DataUtil;
import framework.Driver;
import framework.ElementLocators;
import listeners.RetryAnalyzer;
import pages.impl.LoginPage;

public class TestCase1 extends ConfigurationMethods{
	

	
	@Test
	public void tc1() throws InterruptedException {
		
		
		if (getElement(By.xpath("\\input[@id,'xyz123']"), 0) != null) {
			reporter.writeLog(Status.PASS, "Application is navigated to Login page");
			Driver.get().findElement(By.xpath("//input[@name='email']") ).sendKeys(envData.get("username"));
			Driver.get().findElement(By.xpath("//input[@name='password']") ).sendKeys(envData.get("password"));
			Driver.get().findElement(By.xpath("//div[text()='Login']") ).click();
			reporter.writeLog(Status.PASS, "Login is successful");
			
		} else {
			reporter.writeLog(Status.FAIL, "Application is NOT navigated to Login page");
			Assert.assertFalse(true);
		}
	
		
		Thread.sleep(10000);
		
		
		
	
		
	}
	

	@Test
	public void tc2() throws InterruptedException, IOException {
	
		
		Driver.get().findElement(By.linkText("Sign Up") ).click();
		reporter.writeLog(Status.PASS, "Application is navigated to Sign Up Page");
		Driver.get().findElement(By.xpath("//input[@name='email']") ).sendKeys("test@test.com");
		Driver.get().findElement(By.xpath("//button[contains(text(),'Sign Up')]") ).click();
		
		Thread.sleep(10000);
		
		reporter.writeLog(Status.PASS, "Sign Up is successful.","SignUp");
		
		
		
	}
}

package tests.employeeManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParameterizationFromProperties {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		HashMap<String, String> data = getPropertiesData( System.getProperty("user.dir")+"\\src\\test\\resources\\config\\AppConfig.properties");
		
		launchApplication(data.get("browser"), data.get("url"));
		Thread.sleep(5000);
	//	driver.findElement(By.xpath("//span[text()='Log In']")).click();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(data.get("username"));
		driver.findElement(By.name("password")).sendKeys(data.get("password"));
		
	}
	
	
	public static void launchApplication(String browser, String url) {
		
		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		
		driver.get(url);
		
	}
	
	
	
	


}

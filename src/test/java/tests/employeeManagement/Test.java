package tests.employeeManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import exceptions.ValueInListBoxNotFoundException;
import framework.Driver;
import framework.EventMethods;
import pages.impl.AddEmployeePage;
import pages.impl.EmployeeDetailsPage;
import pages.impl.HomePage;
import pages.impl.LoginPage;

public class Test extends EventMethods {

	public static void main(String[] args) throws ValueInListBoxNotFoundException, FileNotFoundException, IOException {
		
		Driver.createInstace("chrome", "https://login.salesforce.com");
		
		/*
		 * Properties props = new Properties(); props.load (new FileInputStream(new
		 * File(System.getProperty("user.dir") + "\\AppCookies.properties")));
		 * 
		 * Set<Entry<Object, Object>> vals = props.entrySet();
		 * 
		 * for (Entry<Object, Object> val : vals) { Cookie c = new
		 * Cookie(val.getKey().toString(), val.getValue().toString());
		 * Driver.get().manage().addCookie(c);
		 * 
		 * }
		 */
		
		
		Driver.get().findElement(By.name("username")).sendKeys("vsudeerkumarreddy@salesforce.com");
		Driver.get().findElement(By.name("pw")).sendKeys("Vullikanti@996");
		Driver.get().findElement(By.id("Login")).click();
		
		Set<Cookie> allCookies = Driver.get().manage().getCookies();
		
		for (Cookie c : allCookies) {
			System.out.println(c.getName() + " : " + c.getValue());
		}
		
		/*
		Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement listBox = Driver.get().findElement(By.id("Teams"));
		
		*/
		
		//createEmployee();
		
		//Select class
		
		//Driver.createInstace("chrome", "file:///E:/51/HtmlFiles/ListBoxItems.html");
		
		//testMethod();
	
	//	constantWait(76423);
		
		//Select select = new Select(listBox);
		
		/*
		WebElement listBox = Driver.get().findElement(By.id("Teams"));
		
		 List<WebElement> options =  listBox.findElements(By.tagName("Option"));
		 String valToSelect = "punjab kinds     ";
		 boolean isOptFOund = false;
		 for (WebElement opt : options) {
			 String optText = opt.getText();
			 
			 if (optText.trim().contains(valToSelect.trim())) {
				 opt.click();
				 isOptFOund = true;
				 break;
			 }
		 }
		 
		 if (!isOptFOund) {
			 System.out.println("Option : " + valToSelect+ " is not found. ");
		 }
		
		
		*/
		
		
		
		//Select select = new Select(listBox);
		
       // listBox.getTagName();
		
		/*WebElement listBox = Driver.get().findElement(By.id("TestTeams"));
		Select select = new Select(listBox);
		
		
		
		String val = "Bangladesh";
		
		 List<WebElement> allOptions = select.getAllSelectedOptions();
		 boolean isFound = false;
		 for (WebElement opt: allOptions) {
			 String optText = opt.getText();
			 if (optText.equalsIgnoreCase(val)) {
				 isFound = true;
				 break;
			 }
		 }
		
		 if (isFound) {
			 
		 } else {
			 
		 }*/
		//select.deselectAll();
		
	//	select.selectByVisibleText("Australia");
		
		/*
		String[] countriesToSelect = {"India", "England","Scotlond", "Newzeland","Australia"};
		
		for (String country: countriesToSelect) {
			select.selectByVisibleText(country);
		}*/
		
		/*
		select.selectByVisibleText("India");
		select.selectByVisibleText("England");
		select.selectByVisibleText("Newzeland");
		*/
		/*
		WebElement listBox =  Driver.get().findElement(By.id("Teams"));
		
		Select select = new Select(listBox); //Creating the instance of Select class with Listbox ..
		
	//	select.selectByVisibleText("Delhi Capitals");
		//select.selectByIndex(8);
		select.selectByValue("KKR");
		
		
*/		
		

	}
	
	
	public static void constantWait(long millis) throws InterruptedException {
		
		
			Thread.sleep(millis);
		
		
	}
	
	public static void testMethod() {
		
		Scanner sc = new Scanner(System.in);
		try {
		
			System.out.println("Enter value for A :");
			int A = sc.nextInt();
			System.out.println("Enter value for B :");
			int B = sc.nextInt();
			
			try {
				int res = A / B;
				System.out.println("result of A / B : " + res);
			} catch (InputMismatchException e) {
				System.out.println("Invalid input.");
			}
		} catch(NullPointerException e) {
			System.out.println("Null pointer.");
		} catch (ArithmeticException e){
			System.out.println("B value cannot be 0. Division cannot be performed with 0.");
			
		}finally {
			sc.close();
		}

		
		/*
		WebElement listBox = Driver.get().findElement(By.id("TestTeams"));
		
		String[] allCountriesToSelect = {"Australia","India","Bangladesh","Newzeland","England"};
		
		Select select = new Select(listBox);
		
		
		
		for (String country: allCountriesToSelect) {
			try {
				Driver.get().findElement(By.id("BestPlayer")).sendKeys("DsadsadaS");
				select.selectByVisibleText(country);
			} catch (NoSuchElementException e) {
				System.out.println(country+" is not found in the list. Unable to select.");
				break;
			} finally {
				System.out.println("this is finally block");
			}
			
		}*/
	}
	
	
	
	
	
	
	public static void createEmployee() {
		
		Driver.createInstace("chrome", "https://opensource-demo.orangehrmlive.com/");
		
		LoginPage loginPage = new LoginPage();
		HomePage homePage = new HomePage();
		AddEmployeePage addEmpPage = new AddEmployeePage();
		EmployeeDetailsPage empDetailsPage = new EmployeeDetailsPage();
		
		if (loginPage.isLoginPageDisplayed()) {
			System.out.println("Application is launched.");
		} else {
			System.out.println("Application is not launched.");
		}
		
		
		
		loginPage.login("Admin", "admin123");
		
	}
	
	
}

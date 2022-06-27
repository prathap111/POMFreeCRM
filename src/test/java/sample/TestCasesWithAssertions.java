package sample;

import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import listeners.RetryAnalyzer;

public class TestCasesWithAssertions {
	static int A = 0;
	@Test
	public void tc1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value for A :");
		int A = sc.nextInt();
		 System.out.println("I am in test case 1");
		 Assert.assertTrue(A > 100, "A is invalid value");
		 Assert.assertEquals(A % 2, 0, "A is not even number.");
		 sc.close();
	}
	
	@Test
	public void tc2() {
		
		A++;
	//	int A = 120;
		System.out.println("I am test case 2");
		Assert.assertTrue(isPrime(A),A + " is not prime.");
		
		//Assert.assertEquals(A % 2, 0, "A is not even number.");
		
	}
	
	public boolean isPrime(int n) {
	
		if (n <= 3 || n % 2 == 0) 
				return false;
		
		for (int i = 2; i <= n/2; i++) {
			if (n % i == 0)
					return false;
		}
		
		return true;
	}
	
	@Test(dependsOnMethods = {"tc1","tc2"})
	public void tc3() {
		System.out.println("I am test case 3");
	}
	
	
	
	
	
	/*static int A = 1;
	
	@Test
	public void tc1() {
		SoftAssert softAssert = new SoftAssert();
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter value for A :");
	//	int A = sc.nextInt();
		int res =A % 2;
		A++;
		System.out.println("Application is launched successful.");
		
		softAssert.assertEquals(res, 0,"Invalid number given for A");
		
		
		System.out.println("Login is done.");
		
		softAssert.assertTrue(A > 100, "A is given less than 100");
		
		System.out.println("navigating to Company page is done.");
		
		System.out.println("Company creation is successful");
		
		System.out.println("Logout is successful.");
		
		sc.close();
		
		softAssert.assertAll();
	}
*/
}

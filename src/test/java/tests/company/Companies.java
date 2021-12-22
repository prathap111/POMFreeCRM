package tests.company;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Companies {
	
	@DataProvider
	public Object[][] getData(){
		Object[][] arr = new Object[2][3];
		
		arr[0][0] = 4;
		arr[0][1] = "B";
		
		arr[1][0] = 1;
		arr[1][1] = "E";
		arr[1][2] = "X";

		return arr;
		
		
	}
	
	
	
	
	@Test(priority = -2,groups = {"delete","regression"})
	public void deleteMultipleCompanies() {
		System.out.println("Delete multiple companies");
	}

	@Test(priority = 1,groups = "create")
	public void createCompany() {
		System.out.println("I am in create company");
	}
	
	@Test(priority = 2,groups = "modify")
	public void modifyCompany() {
		System.out.println("I am in modify company");
	}
	
	@Test(priority = 3,groups = "delete")
	public void deleteCompany() {
		System.out.println("I am in delete company");
	}
	
	

}

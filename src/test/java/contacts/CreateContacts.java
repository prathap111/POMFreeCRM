package contacts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateContacts extends ConfigurationMethods {
	
	
	@Test(groups = "create")
	public void createContact() {
		System.out.println("Create Contact");
	}
	
	@Test(groups =  "modify")
	public void modifyContact() {
		System.out.println("Modify Contact");
	}
	
	@Test(groups = "delete")
	public void deleteContact() {
		System.out.println("Delete Contact");
	}

}

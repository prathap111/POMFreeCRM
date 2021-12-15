package pages;

import exceptions.ValueInListBoxNotFoundException;

public interface ICreateCompanyPage {
	
	boolean navigateToCreateCompanyPage() throws Exception;
	
	void enterCompanyName(String companyName) throws Exception;
	
	void selectCompanyAccessibility(String access) throws Exception;
	
	void selectStatus(String status) throws ValueInListBoxNotFoundException ;
	
	void selectPriority(String priority) throws ValueInListBoxNotFoundException;
	
	void selectCategory(String category) throws ValueInListBoxNotFoundException;
	
	void enterAddress();
	
	void saveCompany();
	
	
	
	
	

}

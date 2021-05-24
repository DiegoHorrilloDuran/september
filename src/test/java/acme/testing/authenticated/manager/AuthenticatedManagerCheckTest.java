package acme.testing.authenticated.manager;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

//Aquí vamos a testear si esta un administrador autenticado como manager
public class AuthenticatedManagerCheckTest extends AcmePlannerTest {

	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/manager/list.csv", encoding = "utf-8", numLinesToSkip = 1)
@Order(10)
public void listAllTasks(final int recordIndex, final String Username, final String Name,final String Surname,final String Email, final String Roles, final String Status) {
		super.signIn("administrator", "administrator");
		super.clickOnMenu("Account", "Become a manager");
		super.clickOnSubmitButton("Accept");
		super.clickOnMenu("Administrator", "User accounts");
		//super.checkColumnHasValue(recordIndex, 0, Title);
	//	super.checkColumnHasValue(recordIndex, 1, Start);
		//super.checkColumnHasValue(recordIndex, 2, End);
		//super.checkColumnHasValue(recordIndex, 4, Workload);
		//super.checkColumnHasValue(recordIndex, 5, Description);
		
		
	
		
		super.clickOnListingRecord(recordIndex);
//		super.checkInputBoxHasValue("username", Username);
//		super.checkInputBoxHasValue("name", Name);
//		super.checkInputBoxHasValue("surname", Surname);
//		super.checkInputBoxHasValue("email", Email);
		super.checkInputBoxHasValue("roleList", Roles);
//		super.checkInputBoxHasValue("status", Status);
		super.signOut();
	}
}
package acme.testing.manager.task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

//Aquí vamos a testear el mostrar el listado de todas las shouts disponibles
public class ManagerTaskListTest extends AcmePlannerTest{
	@Override
	@BeforeAll
	public void beforeAll() {
		//super.setHeadless(true);
		super.beforeAll();
		
		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		
		super.setAutoPausing(false);
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/listTask.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
    public void listManagerTasks(final int recordIndex, final String idmanager, final String description, final String end, 
    	final String privacy, final String start, final String title, final String workload) {
		super.signIn("manager01","manager01");
		super.clickOnMenu("Manager", "Manager tasks");
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, start);
		super.checkColumnHasValue(recordIndex, 2, end);
	
		
		super.clickOnListingRecord(recordIndex);
		
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("start", start);	
		super.checkInputBoxHasValue("end", end);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("description", description);
		
		super.signOut();
	}

}
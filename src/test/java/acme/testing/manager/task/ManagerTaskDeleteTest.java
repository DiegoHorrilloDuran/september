package acme.testing.manager.task;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmePlannerTest;

/*
 * En este test vamos a comprobar el caso positivo de borrar una task del manager.
 */
public class ManagerTaskDeleteTest extends AcmePlannerTest {
	
	/*
	 * CASO POSITIVO: Borramos una tarea correctamente
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/manager/task/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
	public void createPositive(final int recordIndex, final String title, final String start, final String end, final String workload, final String description) {
		
		//Iniciamos sesion con el usuario de manager01
		super.signIn("manager01", "manager01");
		
		//clicamos en la lista de tareas del manager
		super.clickOnMenu("Manager", "Manager tasks");
		
		//Clicamos en la tarea especifica para ver los detalles de la tarea que vamos a borrar
		super.clickOnListingRecord(recordIndex);
	
		super.clickOnSubmitButton("Delete"); //le damos al boton para borrar la tarea
		
		super.clickOnMenu("Manager", "Manager tasks"); //nos vamos ahora al listado de todas las tareas del manager
		
		//Comprueba en el listado que ya no existe la tarea borrada y. en su lugar, la tarea siguiente a la borrada
		//ocupa ahora el lugar de la otra (por el número del índice). Comprobando que la tarea siguiente a la borrada
		//tiene el índice en i-1 sabríamos que se ha borrado correctamente
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, start);
		super.checkColumnHasValue(recordIndex, 2, end);
		
		//Clicamos en la tarea especifica para ver los detalles de esa tarea
		super.clickOnListingRecord(recordIndex);
		
		//Vamos a comprobar que cada elemnto tiene el valor del csv
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("start", start);
		super.checkInputBoxHasValue("end", end);
		super.checkInputBoxHasValue("workload", workload);
		super.checkInputBoxHasValue("description", description);
		
		//Salimos de la sesion
		super.signOut();
		
	}

}

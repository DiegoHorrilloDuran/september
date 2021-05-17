package acme.testing.anonymous.shout;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeTest;


//Aquí vamos a testear crear una nueva Shout, sin fallos, en la que probamos dos casos, uno con el parámetro info relleno y otro vacío
public class AnonymousShoutCreateTest extends AcmeTest {
	
	@Override
	@BeforeAll
	public void beforeAll() {
		super.beforeAll();
		
		super.setBaseCamp("http", "localhost", "8080", "/Acme-Planner", "/master/welcome", "?language=en&debug=true");
		super.setAutoPausing(false);
	}
	
	
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(10)
    public void createPositive(final int recordIndex, final String author, final String text, final String info) {
		
		super.clickOnMenu("Anonymous", "New shout");
		
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		
		super.clickOnSubmitButton("Shout!");
		
	}

}

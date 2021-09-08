package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;

public class AnonymousShoutCreateTest extends AcmeWorkPlansTest {
	
	/*CASO POSITIVO
	1. Todo relleno correctamente
	2. Todo relleno excepto Información
	 */
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
    @Order(13)
    public void createPositive(final int recordIndex, final String author, final String text, final String info, final String xxx1, final String xxx2, final String currency, final String amount, final String amount2, final String xxx4) {
		
		super.clickOnMenu("Anonymous", "New shout");
		
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		super.fillInputBoxIn("xxxis.xxx1", xxx1);
		super.fillInputBoxIn("xxxis.xxx2", xxx2);
		super.fillInputBoxIn("xxxis.xxx3.currency", currency);
		super.fillInputBoxIn("xxxis.xxx3.amount", amount);
		super.fillInputBoxIn("xxxis.xxx4", xxx4);
		
		super.clickOnSubmitButton("Shout!");
		
		super.clickOnMenu("Anonymous", "Shouts");

		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		super.checkColumnHasValue(recordIndex, 3, info);
		super.checkColumnHasValue(recordIndex, 4, xxx1);
		super.checkColumnHasValue(recordIndex, 5, xxx2);
		super.checkColumnHasValue(recordIndex, 6, currency+" "+amount2);
		super.checkColumnHasValue(recordIndex, 7, xxx4);
		
	}
	
	/*CASO NEGATIVO
	1. Longitud de Nombre incorrecto
	2. Información rellenada incorrectamente
	3. Texto rellenado con Spam
	4. Texto superior al 10% de Spam
	5. Todos los errores a la vez
	 */		
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(14)
	public void createNegative(final int recordIndex, final String author, final String text, final String info, final String xxx1, final String xxx2, final String currency, final String amount, final String xxx4) {
			
		super.clickOnMenu("Anonymous", "New shout");
			
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		super.fillInputBoxIn("xxxis.xxx1", xxx1);
		super.fillInputBoxIn("xxxis.xxx2", xxx2);
		super.fillInputBoxIn("xxxis.xxx3.currency", currency);
		super.fillInputBoxIn("xxxis.xxx3.amount", amount);
		super.fillInputBoxIn("xxxis.xxx4", xxx4);
			
		super.clickOnSubmitButton("Shout!");
		super.checkErrorsExist();
			
	}
}
package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeWorkPlansTest;


public class AnonymousShoutListTest extends AcmeWorkPlansTest{

	/*
	TEST LIST POSITIVO
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/listAll.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
    public void listAllShouts(final int recordIndex, final String author, final String text, final String info, final String xxx1, final String xxx2, final String xxx3, final String xxx4) {
		
		super.clickOnMenu("Anonymous", "Shouts");

		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		super.checkColumnHasValue(recordIndex, 3, info);
		super.checkColumnHasValue(recordIndex, 4, xxx1);
		super.checkColumnHasValue(recordIndex, 5, xxx2);
		super.checkColumnHasValue(recordIndex, 6, xxx3);
		super.checkColumnHasValue(recordIndex, 7, xxx4);
		
	}

	/*
	TEST LIST NEGATIVO
	*/
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/listAll-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(11)
	public void listAllNegative(final int recordIndex, final String path) {
		super.signIn("administrator", "administrator");
		super.navigateTo(path);
		super.checkErrorsExist();
		super.signOut();
	}
}

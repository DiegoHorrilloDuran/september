package acme.features.anonymous.shout;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.entities.CustomisationParameter;
import acme.framework.entities.Shout;
import acme.framework.services.AbstractCreateService;

@Service
public class AnonymousShoutCreateService implements AbstractCreateService<Anonymous, Shout> {

	@Autowired
	protected AnonymousShoutRepository repository;
	
	@Override
	public boolean authorise(final Request<Shout> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Shout> request, final Shout entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors);
		
	}

	@Override
	public void unbind(final Request<Shout> request, final Shout entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "author", "text", "info");
	}

	@Override
	public Shout instantiate(final Request<Shout> request) {
		assert request != null;
		
		Shout result;
		Date moment;

		moment = new Date(System.currentTimeMillis()-1);
		
		result = new Shout();
		result.setAuthor("");
		result.setText("");
		result.setMoment(moment);
		result.setInfo("");
		
		return result;
	}

	@Override
	public void validate(final Request<Shout> request, final Shout entity, final Errors errors) {
        assert request != null;
        assert entity != null;
        assert errors != null;

        if (!errors.hasErrors("author")) {
            errors.state(request, !this.isSpamText(entity.getAuthor()), "author", "anonymous.shout.error.spam");
        }

        if (!errors.hasErrors("text")) {
            errors.state(request, !this.isSpamText(entity.getText()), "text", "anonymous.shout.error.spam");
        }

    }

    private boolean isSpamText(final String textToCheck) {
        boolean result = false;
        Double numSpWordsInText = 0.;
        final Integer numOfWords = textToCheck.split(" ").length;
        final List<CustomisationParameter> customisation = this.repository.findSpam();

        final String spamWords = customisation.get(0).getSpamWords();
        final String[] spamWordsArray = spamWords.split(",");
        final List<String> spamWordsList = Arrays.asList(spamWordsArray);

        for (final String sw : spamWordsList) {
            numSpWordsInText = numSpWordsInText + this.timesAppearSpamWord(textToCheck.toLowerCase(), sw.toLowerCase(), 0.0);
            final Double percentage = numSpWordsInText / numOfWords * 100;

            if (percentage > customisation.get(0).getThreshold()) {
                result = true;
                break;
            }

        }

        return result;
    }

	private double timesAppearSpamWord(final String textToCheck, final String spamWord, Double numSpWord) {
	        if (textToCheck.contains(spamWord)) {
	            final Integer index = textToCheck.indexOf(spamWord) + spamWord.length();
	            numSpWord++;
	            
	            return this.timesAppearSpamWord(textToCheck.substring(index).trim(), spamWord, numSpWord);
	        }
	
	        return numSpWord;
	    }

	@Override
	public void create(final Request<Shout> request, final Shout entity) {
		assert request != null;
		assert entity != null;
		
		Date moment;
		
		moment = new Date(System.currentTimeMillis()-1);
		entity.setMoment(moment);
		this.repository.save(entity);
	}
	
}

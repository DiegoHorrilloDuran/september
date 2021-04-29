package acme.features.authenticated.manager.task;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Manager;
import acme.framework.entities.Task;
import acme.framework.services.AbstractCreateService;

@Service
public class AuthenticatedManagerTaskCreateService implements AbstractCreateService<Authenticated, Task> {

	@Autowired
	protected  AuthenticatedManagerTaskRepository repository;
	
	@Override
	public boolean authorise(final Request<Task> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors);
		
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "title", "start", "end", "workload", "description", "privacy", "manager");
	}

	@Override
	public Task instantiate(final Request<Task> request) {
		assert request != null;
		
		Task result;
		Date start;
		Date end;
		Manager manager;
		
		manager = new Manager();
		start = new Date(System.currentTimeMillis()-1);
		end = new Date(System.currentTimeMillis()-1);
		
		result = new Task();
		result.setTitle("");
		result.setStart(start);
		result.setEnd(end);
		result.setWorkload(0.0);
		result.setDescription("");
		result.setManager(manager);
		
		return result;
	}
/*
	@Override
	public void validate(final Request<Task> request, final Task entity, final Errors errors) {
        assert request != null;
        assert entity != null;
        assert errors != null;

        if (!errors.hasErrors("title")) {
            errors.state(request, !this.isSpamText(entity.getTitle()), "title", "authenticated.task.error.spam");
        }

        if (!errors.hasErrors("description")) {
            errors.state(request, !this.isSpamText(entity.getDescription()), "description", "authenticated.task.error.spam");
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
*/
	@Override
	public void create(final Request<Task> request, final Task entity) {
		assert request != null;
		assert entity != null;
		
		
		this.repository.save(entity);
	}

@Override
public void validate(final Request<Task> request, final Task entity, final Errors errors) {
	// TODO Auto-generated method stub
	
}
	
}

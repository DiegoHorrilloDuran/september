package acme.features.anonymous.shout;

import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.entities.CustomisationParameter;
import acme.framework.entities.Shout;
import acme.framework.services.AbstractCreateService;
import acme.framework.utilities.AcmeDuration;
import acme.framework.utilities.SpamDetect;

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
		
		request.unbind(entity, model, "author", "text", "info", "xxxis.xxx1", "xxxis.xxx2", "xxxis.xxx3.currency", "xxxis.xxx3.amount", "xxxis.xxx4");
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
        
        final CustomisationParameter params = this.repository.findSpam().get(0);

		String xxx1;
		String xxx2;
		String currency;
		String amount;
		String xxx4;
		
		final Date ahora = Date.from(Instant.now());
		
		xxx1 = request.getModel().getString("xxxis.xxx1");
		xxx2 = request.getModel().getString("xxxis.xxx2");
		currency = request.getModel().getString("xxxis.xxx3.currency");
		amount = request.getModel().getString("xxxis.xxx3.amount");
		xxx4 = request.getModel().getString("xxxis.xxx4");

        if (!errors.hasErrors("author")) {
            errors.state(request, !SpamDetect.isSpamText(entity.getAuthor(),params), "author", "anonymous.shout.error.spam");
        }

        if (!errors.hasErrors("text")) {
            errors.state(request, !SpamDetect.isSpamText(entity.getText(), params), "text", "anonymous.shout.error.spam");
        }
 
        if (!errors.hasErrors("xxxis.xxx1")) {
            errors.state(request, !xxx1.isEmpty() , "xxxis.xxx1", "anonymous.shout.error.xxxis.xxx1");
        }
        
        if (!errors.hasErrors("xxxis.xxx2")) {
            errors.state(request, !xxx2.isEmpty(), "xxxis.xxx2", "anonymous.shout.error.xxxis.xxx2");
        }
        
        if (!errors.hasErrors("xxxis.xxx3.currency")) {
            errors.state(request, !currency.isEmpty(), "xxxis.xxx3.currency", "anonymous.shout.error.xxxis.xxx3.currency");
        }
        
        if (!errors.hasErrors("xxxis.xxx3.amount")) {
            errors.state(request, !amount.isEmpty(), "xxxis.xxx3.amount", "anonymous.shout.error.xxxis.xxx3.amount");
        }
        
        if (!errors.hasErrors("xxxis.xxx3.amount")) {
        	
        	final Double am = new Double(amount.replace(',','.'));
        	if(am<=0) {
        		errors.state(request, am>0 , "xxxis.xxx3.amount", "anonymous.shout.error.xxxis.xxx3.amount.positive");
        	}else {
        		
        		if(amount.contains(".")) {
        			final int indexOfDecimal = amount.indexOf(".");
        			final String entero = amount.substring(0,indexOfDecimal);
        			final String decimal = amount.substring(indexOfDecimal);
        			errors.state(request, (entero.length()<=10 && decimal.length()<=3) , "xxxis.xxx3.amount", "anonymous.shout.error.xxxis.xxx3.amount.digits");
        		
        		}else if(amount.contains(",")) {
        			final int indexOfDecimal = amount.indexOf(",");
        			final String entero = amount.substring(0,indexOfDecimal);
        			final String decimal = amount.substring(indexOfDecimal);
        			
        			errors.state(request, (entero.length()<=10 && decimal.length()<=3) , "xxxis.xxx3.amount", "anonymous.shout.error.xxxis.xxx3.amount.digits");
        		} else {
        			
        			errors.state(request, amount.length()<=10 , "xxxis.xxx3.amount", "anonymous.shout.error.xxxis.xxx3.amount.digits");
                }
        		
            }
        }
        
        if (!errors.hasErrors("xxxis.xxx1")) {
            errors.state(request, xxx1.matches("^\\d{2}[-](0[1-9]|[12][0-9]|3[01])(0[1-9]|1[012])\\d{2}") , "xxxis.xxx1", "anonymous.shout.error.xxxis.xxx1-pattern");
        }
        
        if (!errors.hasErrors("xxxis.xxx3.currency")) {
            errors.state(request, (currency.trim().equals("EUR")||currency.trim().equals("USD")||(currency.trim().equals("GBP"))), "xxxis.xxx3.currency", "anonymous.shout.error.xxxis.xxx3.currency-only");
        }
        
        if (!errors.hasErrors("xxxis.xxx2")) {
            errors.state(request, entity.getXxxis().getXxx2().after(ahora), "xxxis.xxx2", "anonymous.shout.error.xxxis.xxx2.date.future");
        }
        
        if (!errors.hasErrors("xxxis.xxx2")) {
        	final Date d = entity.getXxxis().getXxx2();
            errors.state(request, AcmeDuration.getDuration(ahora, d)>168.0, "xxxis.xxx2", "anonymous.shout.error.xxxis.xxx2.date.week");
        }
    }

	@Override
public void create(final Request<Shout> request, final Shout entity) {
		assert request != null;
		assert entity != null;

		Date moment;
		moment = new Date(System.currentTimeMillis()-1);
		entity.setMoment(moment);
		this.repository.save(entity.getXxxis());
		this.repository.save(entity);
	}
	
}

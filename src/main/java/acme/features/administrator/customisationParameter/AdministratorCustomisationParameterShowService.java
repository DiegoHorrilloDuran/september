package acme.features.administrator.customisationParameter;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.CustomisationParameter;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorCustomisationParameterShowService implements AbstractShowService<Administrator, CustomisationParameter> {


	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorCustomisationParameterRepository repository;

	// AbstractShowService<Administrator, CustomisationParameter> interface --------------
	
	@Override
	public boolean authorise(final Request<CustomisationParameter> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<CustomisationParameter> request, final CustomisationParameter entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "spamWords", "threshold");
		
	}

	@Override
	public CustomisationParameter findOne(final Request<CustomisationParameter> request) {
		assert request != null;

		CustomisationParameter result;

		result = this.repository.findSpam().stream().collect(Collectors.toList()).get(0);

		return result;
	}
	
	

}

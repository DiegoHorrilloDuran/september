package acme.features.manager.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Manager;
import acme.framework.entities.Task;
import acme.framework.services.AbstractCreateService;

@Service
public class ManagerTaskCreateService implements AbstractCreateService<Manager, Task> {

	@Autowired
	protected  ManagerTaskRepository repository;
	
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
		
		request.unbind(entity, model, "title", "start", "end", "workload", "description", "privacy", "idmanager");
	}

	@Override
	public Task instantiate(final Request<Task> request) {
		assert request != null;
		
		Task result;
		Integer manager;
		
		manager = request.getPrincipal().getAccountId();
		
		result = new Task();
		result.setIdmanager(manager);
		
		return result;
	}

	@Override
	public void validate(final Request<Task> request, final Task entity, final Errors errors) {
        assert request != null;
        assert entity != null;
        assert errors != null;
     
      errors.state(request, entity.getStart().before(entity.getEnd()), "end", "La fecha de fin no puede ser anterior a la de inicio");  
        
        
     
      

      /*  if (!errors.hasErrors("title")) {
            errors.state(request, !this.isSpamText(entity.getTitle()), "title", "authenticated.task.error.spam");
        }

        if (!errors.hasErrors("description")) {
            errors.state(request, !this.isSpamText(entity.getDescription()), "description", "authenticated.task.error.spam");
        }*/

    }

	@Override
	public void create(final Request<Task> request, final Task entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	}


	
}

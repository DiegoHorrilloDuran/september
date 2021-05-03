package acme.features.manager.task;



import java.time.Instant;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Manager;
import acme.framework.entities.Task;
import acme.framework.services.AbstractUpdateService;

@Service
public class ManagerTaskUpdateService implements AbstractUpdateService<Manager, Task>{

	@Autowired
	protected ManagerTaskRepository repository;

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
		assert request!=null;
		assert entity!=null;
		assert model!=null;
				
		request.unbind(entity, model, "title","start","end","workload","description","privacy");
		
		
	}

	@Override
	public Task findOne(final Request<Task> request) {
		assert request != null;
		
		final Integer id = request.getModel().getInteger("id");
		Task res;
		
		res = this.repository.findOneTaskById(id);
		return res;
			
	}

	@Override
	public void validate(final Request<Task> request, final Task entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
        final Date ahora = Date.from(Instant.now());
        
        
        
      errors.state(request, !entity.getStart().before(ahora), "start", "La fecha de inicio no puede ser anterior a la actual");
		errors.state(request, entity.getStart().before(entity.getEnd()), "end", "La fecha de fin no puede ser anterior a la de inicio");
		
	}

	@Override
	public void update(final Request<Task> request, final Task entity) {
		assert request != null;
		assert entity != null;
		
		String title;
		Date start;
		Date end;
		Double workload;
		String description;
		Boolean privacy;
		
		title = request.getModel().getString("title");
		start = request.getModel().getDate("start");
		end = request.getModel().getDate("end");
		workload = request.getModel().getDouble("workload");
		description = request.getModel().getString("description");
		privacy = request.getModel().getBoolean("privacy");
		
		entity.setTitle(title);
		entity.setStart(start);
		entity.setEnd(end);
		entity.setWorkload(workload);
		entity.setDescription(description);
		entity.setPrivacy(privacy);
		
		this.repository.save(entity);
		
	}
	
	
	

}

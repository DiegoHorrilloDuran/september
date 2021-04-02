package acme.features.administrator.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.entities.Dashboard;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	private AdministratorDashboardRepository repository;
	
	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "numberOfTasks", "numberOfPrivateTasks", "numberOfFinishedTasks");
		
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		final Dashboard dashboard = new Dashboard();
		
		final Integer numberOfTasks = this.repository.getNumberOfTasks();
		final Integer numberOfPrivateTasks = this.repository.getNumberOfPrivateTasks();
		final Integer numberOfFinishedTasks = this.repository.getNumberOfFinishedTasks();
		
		dashboard.setNumberOfTasks(numberOfTasks);
		dashboard.setNumberOfPrivateTasks(numberOfPrivateTasks);
		dashboard.setNumberOfFinishedTasks(numberOfFinishedTasks);
		
		return dashboard;
	}

}

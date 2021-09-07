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
		
		final Integer pt = entity.numberOfPublicTasks();
		final Integer ut = entity.numberOfUnfinishedTasks();
		
		request.unbind(entity, model,"ratio1","ratio2","avg3","stddev4","avg5","stddev6", "numberOfTasks", "numberOfPrivateTasks", "numberOfFinishedTasks","maxTaskExecutionPeriod","minTaskExecutionPeriod","avgTaskExecutionPeriods","stdDevTaskExecutionPeriods","maxTaskWorkload","minTaskWorkload","avgTaskWorkloads","stdDevTaskWorkloads");
		model.setAttribute("numberOfPublicTasks", pt);
		model.setAttribute("numberOfUnfinishedTasks", ut);
	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		final Dashboard dashboard = new Dashboard();
		final Integer t = this.repository.getNumberOfShouts();
		final Integer q1 = this.repository.getQuery1();
		final Integer q2 = this.repository.getQuery2();
		
		dashboard.setRatio1(q1 + "/" + t);
		dashboard.setRatio2(q2 + "/" + t);
		dashboard.setAvg3(this.repository.getAvg3());
		dashboard.setStddev4(this.repository.getStdDev4());
		dashboard.setAvg5(this.repository.getAvg5());
		dashboard.setStddev6(this.repository.getStdDev6());
		dashboard.setNumberOfTasks(this.repository.getNumberOfTasks());
		dashboard.setNumberOfPrivateTasks(this.repository.getNumberOfPrivateTasks());
		dashboard.setNumberOfFinishedTasks(this.repository.getNumberOfFinishedTasks());
		dashboard.setMaxTaskExecutionPeriod(this.repository.getMaxTaskExecutionPeriod());
		dashboard.setMinTaskExecutionPeriod(this.repository.getMinTaskExecutionPeriod());
		dashboard.setAvgTaskExecutionPeriods(this.repository.getAvgTaskExecutionPeriods());
		dashboard.setStdDevTaskExecutionPeriods(this.repository.getStdDevTaskExecutionPeriods());
		dashboard.setMaxTaskWorkload(this.repository.getMaxTaskWorkload());
		dashboard.setMinTaskWorkload(this.repository.getMinTaskWorkload());
		dashboard.setAvgTaskWorkloads(this.repository.getAvgTaskWorkloads());
		dashboard.setStdDevTaskWorkloads(this.repository.getStdDevTaskWorkloads());
		
		return dashboard;
	}

}

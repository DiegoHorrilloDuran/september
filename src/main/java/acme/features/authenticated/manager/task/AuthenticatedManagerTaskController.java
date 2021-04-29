package acme.features.authenticated.manager.task;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;
import acme.framework.entities.Task;

@Controller
@RequestMapping("/authenticated/manager/task/")
public class AuthenticatedManagerTaskController extends AbstractController<Authenticated, Task>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	private AuthenticatedManagerTaskListService listService;
	
	@Autowired
	private AuthenticatedManagerTaskShowService showService;
	
	@Autowired
	private AuthenticatedManagerTaskCreateService createService;
	
	// Constructors -----------------------------------------------------------

	@PostConstruct
	protected void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}

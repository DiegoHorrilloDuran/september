package acme.framework.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.framework.components.BasicCommand;
import acme.framework.entities.Anonymous;
import acme.framework.entities.Task;
import acme.framework.services.AnonymousTaskListService;
import acme.framework.services.AnonymousTaskShowService;

@Controller
@RequestMapping("/anonymous/task/")
public class AnonymousTaskController extends AbstractController<Anonymous, Task>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	private AnonymousTaskListService listService;
	
	@Autowired
	private AnonymousTaskShowService showService;
	
	// Constructors -----------------------------------------------------------

	@PostConstruct
	protected void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
	
}

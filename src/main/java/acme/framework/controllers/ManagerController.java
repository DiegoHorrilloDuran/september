package acme.framework.controllers;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.framework.components.BasicCommand;
import acme.framework.entities.Manager;
import acme.framework.entities.UserRole;
import acme.framework.services.ManagerListService;
import acme.framework.services.ManagerShowService;

@Controller
@RequestMapping("/manager/")
public class ManagerController  extends AbstractController<UserRole, Manager>{

	// Internal state ---------------------------------------------------------
	
	@Autowired
	private ManagerListService listService;
	
	@Autowired
	private ManagerShowService showService;
	
	// Constructors -----------------------------------------------------------

	@PostConstruct
	protected void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
	

}

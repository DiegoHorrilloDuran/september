package acme.features.administrator.customisationParameter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/administrator/customisation-parameter/")
public class AdministratorCustomisationParameterController {
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected AdministratorCustomisationParameterShowService	showService;

	@Autowired
	protected AdministratorCustomisationParameterUpdateService	updateService;

	// Constructors -----------------------------------------------------------


	@PostConstruct
	protected void initialise() {
//		super.addCustomCommand(CustomCommand.SHOW, this.showService);
//		super.addCustomCommand(CustomCommand.UPDATE, this.updateService);
	}


}

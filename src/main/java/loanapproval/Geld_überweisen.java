package loanapproval;

import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class Geld_�berweisen implements JavaDelegate {

	
	
private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

public void execute(DelegateExecution execution) throws Exception {

		// TODO Auto-generated method stub
		LOGGER.info("Der Betrag von'"
		+ execution.getVariable("Amount") +
		"' Euro wurde �berwiesen an: '" +
		execution.getVariable("ClaimedFahrer") +
		"'");
	}
	

}



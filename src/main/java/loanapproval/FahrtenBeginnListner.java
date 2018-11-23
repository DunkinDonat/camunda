package loanapproval;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class FahrtenBeginnListner implements TaskListener{
	private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

	
	public void notify(DelegateTask execution) {
		// TODO Auto-generated method stub
		LOGGER.info("Kunde wurde Transportiert");
	}


}

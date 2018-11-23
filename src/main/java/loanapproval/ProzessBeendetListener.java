package loanapproval;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class ProzessBeendetListener implements ExecutionListener{
	private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

	

	public void notify(DelegateExecution execution) throws Exception {
		LOGGER.info("Prozesswurde Beendet");
		
	}


}

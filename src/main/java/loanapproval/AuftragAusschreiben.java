package loanapproval;

import java.util.Random;
import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class AuftragAusschreiben implements JavaDelegate {

	private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

	public void execute(DelegateExecution execution) throws Exception {

		// LOGGER.info("Hallo Oguz '" + execution.getVariable("customerId") +
		// "'...");
		LOGGER.info("Auftrag der Fahrergruppe zuteilen...");

		if (execution.getVariable("LimousineType").equals("Limousine A")) {
			LOGGER.info("Fahrergruppe A zugeteilt!");
			execution.setVariable("FahrerGruppe", "FahrerA");
		} else if (execution.getVariable("LimousineType").equals("Limousine B")) {
			LOGGER.info("Fahrergruppe B zugeteilt!");
			execution.setVariable("FahrerGruppe", "FahrerB");
		}

	}

}
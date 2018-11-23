package loanapproval;

import java.util.Random;
import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Zielort_schreiben implements JavaDelegate {


	private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

	
	public void execute(DelegateExecution execution) throws Exception {
		
		LOGGER.info("Zielort wird �berpr�ft...");
		
		Class.forName("org.h2.Driver");
		Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement stmt = con.createStatement();
		


		String sql = "INSERT INTO ORT (Zielname) VALUES ('" + execution.getVariable("Zielort") + "')";

		stmt.execute(sql);

		LOGGER.info("Zielort '" + execution.getVariable("Zielort") + "' in DB eingef�gt!");
	}

		
	
}
package loanapproval;

import java.util.Random;
import java.util.logging.Logger;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ZielortPruefen implements JavaDelegate {

	private final static Logger LOGGER = Logger.getLogger("LOAN-REQUESTS");

	public void execute(DelegateExecution execution) throws Exception {

		LOGGER.info("Zielort wird überprüft...");

		Class.forName("org.h2.Driver");
		//Camunda Datenbank Treiber
		Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement stmt = con.createStatement();

		// String sql = "CREATE TABLE IF NOT EXISTS ORT ( "
		// + "ORTID int NOT NULL AUTO_INCREMENT,"
		// + "ZielName varchar(255) NOT NULL,"
		// + "PRIMARY KEY (ORTID)"
		// + ")";

		// stmt.execute(sql);

		// sql = "INSERT INTO ORT (ZielName) VALUES ('test')";
		// stmt.execute(sql);

		String sql = "Select count(*) from ORT where ZielName='" + execution.getVariable("Zielort") + "'";

		// Random rando = new Random();
		// execution.setVariable("name", "Niall");
		// execution.setVariable("ZielOK", rando.nextBoolean());
		// execution.setVariable("ZielOK", true);

		// String sql = "CREATE TABLE IF NOT EXISTS ORT ( "
		// + "ORTID int NOT NULL AUTO_INCREMENT,"
		// + "ZielName varchar(255) NOT NULL,"
		// + "PRIMARY KEY (ORTID)"
		// + ")";

		// stmt.execute(sql);

		// String sql = "INSERT INTO ORT (ZielName) VALUES ('Test2')";

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {

			if (rs.getInt(1) >= 1) {

				LOGGER.info("Zielort in Datenbank vorhanden");
				execution.setVariable("ZielOK", true);

			} else if (rs.getInt(1) == 0) {
				LOGGER.info("Zielort nicht in Datenbank vorhanden");
				execution.setVariable("ZielOK", false);
			}

			// LOGGER.info("Zielorte werden ueberprueft..." + rs.getString(2));

		}

	}

}

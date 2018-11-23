package loanapproval;

import java.util.logging.Logger;

import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.identity.User;
import org.camunda.bpm.engine.impl.context.Context;
import org.camunda.bpm.engine.runtime.Execution;

public class TestTaskListener implements TaskListener {

	private final static Logger LOGGER = Logger.getLogger("TaskListener");

	public void notify(DelegateTask delegateTask) {
		// Custom logic goes here
		String assignee = delegateTask.getAssignee();
		LOGGER.info(assignee);
		// identity service
		delegateTask.setVariable("ClaimedFahrer", assignee);
	}

}

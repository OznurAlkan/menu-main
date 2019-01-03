package ie.com.chatbot.action;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ie.com.chatbot.chat.Conversion;
import ie.com.chatbot.domain.UserInput;
import ie.com.chatbot.tree.TreeNode;

public abstract class BaseAction implements IAction {

	public final static Logger logger = LoggerFactory.getLogger(BaseAction.class);
	@Autowired
	protected Conversion conversion;

	public void run(UserInput input) {
		_run(input);
		System.out.println("01 - Back to Main Menu");
		System.out.println("02 - Back to Previous Menu");
		System.out.println("03 - Exit");
		System.out.println();
		System.out.println("USER " + input.getUserId() + ":\t");
	}

	public boolean checkIfExit(TreeNode node, String input) {
		if (input.equals("03"))
			return true;
		return false;
	}

	public boolean validate(TreeNode node, UserInput input) {
		String choice = input.getChoice();
		if (!(choice.equals("01") || choice.equals("02") || choice.equals("03") || (NumberUtils.isNumber(choice)
				&& Integer.valueOf(choice) <= node.getChilds().size() && Integer.valueOf(choice) > 0))) {
			System.out.println("Please enter correct choice");
			return false;
		}
		return true;
	}

	public boolean validateParemeter(TreeNode node, UserInput input) {
		return true;
	}

	public abstract void _run(UserInput input);
}

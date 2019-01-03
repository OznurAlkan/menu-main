package ie.com.chatbot.action;

import ie.com.chatbot.domain.UserInput;
import ie.com.chatbot.tree.TreeNode;

public interface IAction {

	public void run(UserInput input);
	
	public boolean validate(TreeNode node,UserInput input);
	
	public boolean checkIfExit(TreeNode node, String input);
	
	public boolean validateParemeter(TreeNode node, UserInput input);

}

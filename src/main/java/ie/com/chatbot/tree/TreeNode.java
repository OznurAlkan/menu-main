package ie.com.chatbot.tree;

import java.util.ArrayList;
import java.util.List;

import ie.com.chatbot.action.IAction;
import ie.com.chatbot.domain.UserInput;

public class TreeNode {

	private TreeNode parent;
	private List<TreeNode> childs;
	private IAction action;

	public TreeNode(TreeNode parent, IAction action) {
		super();
		this.parent = parent;
		this.action = action;
		this.childs = new ArrayList<>();
	}

	public void process(UserInput input) {
		action.run(input);		
	}
	
	public TreeNode nextNode(String input) {
		return childs.get(Integer.valueOf(input)-1);		
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public List<TreeNode> getChilds() {
		return childs;
	}

	public void setChilds(List<TreeNode> childs) {
		this.childs = childs;
	}

	public IAction getAction() {
		return action;
	}

	public void setAction(IAction action) {
		this.action = action;
	}

	

}

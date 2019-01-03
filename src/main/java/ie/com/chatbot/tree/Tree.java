package ie.com.chatbot.tree;

import ie.com.chatbot.domain.UserInput;

public class Tree {
	private TreeNode root;
	private TreeNode currentNode;

	public Tree(TreeNode root) {
		super();
		this.root = root;
		this.currentNode = root;
	}

	public void processNode(UserInput input) {
		currentNode.process(input);
	}

	public void nextNode(String input) {
		if (input.equals("03")) {
			return;
		}
		if (input.equals("01")) {
			currentNode = root;
		} else if (input.equals("02")) {
			currentNode = currentNode.getParent() != null ? currentNode.getParent() : currentNode;
		} else {
			currentNode = currentNode.nextNode(input);
		}
	}

	public boolean validateInput(UserInput input) {
		boolean result = currentNode.getAction().validate(currentNode, input);
		if (result) {
			if (!input.getChoice().startsWith("0")) {
				result = currentNode.nextNode(input.getChoice()).getAction().validateParemeter(currentNode, input);
			}
		}
		return result;
	}

	public boolean isExit(String input) {
		return currentNode.getAction().checkIfExit(currentNode, input);
	}

}

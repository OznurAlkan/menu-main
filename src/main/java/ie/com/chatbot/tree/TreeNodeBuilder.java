package ie.com.chatbot.tree;

import ie.com.chatbot.action.IAction;

public class TreeNodeBuilder {
	private IAction action;
	private TreeNode parent;

	private TreeNodeBuilder() {

	}

	public static TreeNodeBuilder aBuilder() {
		return new TreeNodeBuilder();
	}

	public TreeNode build() {
		TreeNode node = new TreeNode(parent, action);
		if (parent != null) {
			parent.getChilds().add(node);
		}
		return node;
	}

	public TreeNodeBuilder addAction(IAction action) {
		this.action = action;
		return this;
	}

	public TreeNodeBuilder addParent(TreeNode parent) {
		this.parent = parent;
		return this;
	}

}

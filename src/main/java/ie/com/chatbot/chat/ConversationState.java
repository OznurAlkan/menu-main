package ie.com.chatbot.chat;

import ie.com.chatbot.domain.RecommendationItem;
import ie.com.chatbot.tree.Tree;

public class ConversationState {
	private String userId;

	private Tree tree;
	private RecommendationItem currentRecommendation;

	public ConversationState(String userId) {
		super();
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public RecommendationItem getCurrentRecommendation() {
		return currentRecommendation;
	}

	public void setCurrentRecommendation(RecommendationItem currentRecommendation) {
		this.currentRecommendation = currentRecommendation;
	}
}

package ie.com.chatbot.domain;

import java.util.ArrayList;

public class Recommendation {
	private ArrayList<RecommendationItem> recommendationList;

	public ArrayList<RecommendationItem> getRecommendationList() {
		return recommendationList;
	}

	public void setRecommendationList(ArrayList<RecommendationItem> recommendationList) {
		this.recommendationList = recommendationList;
	}
}

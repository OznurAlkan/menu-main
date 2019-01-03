package ie.com.chatbot.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ie.com.chatbot.chat.Conversion;
import ie.com.chatbot.domain.RecommendationItem;

@Component
public class GoalRecommenderApiService extends BaseBotService{

	@Autowired
	private Conversion conversion;

	public RecommendationItem getRecommendations(String userId) {
		RecommendationItem gr = new RecommendationItem();
		gr.setTitles(Arrays.asList("PM - Project Manager", "TL - Team Leader"));
		gr.setExplanations(Arrays.asList("you used to work as PM", "your skills are suit to TL"));
		gr.setDetails(Arrays.asList("Project Manager details", "Team Leader details"));
		conversion.getUserCurrentChat(userId).setCurrentRecommendation(gr);
		return gr;
	}
}

package ie.com.chatbot.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ie.com.chatbot.domain.RecommendationItem;
import ie.com.chatbot.domain.UserInput;
import ie.com.chatbot.service.GoalRecommenderApiService;

@Component("GenerateRecommender")
public class GenerateRecommenderAction extends BaseAction {

	@Autowired
	private GoalRecommenderApiService service;

	@Override
	public void _run(UserInput input) {
		RecommendationItem gr = service.getRecommendations(input.getUserId());
		gr.getTitles().forEach(System.out::println);
		System.out.println("1- Explanation");
		System.out.println("2- Details");
	}
	
}

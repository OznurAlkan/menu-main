package ie.com.chatbot.action;

import org.springframework.stereotype.Component;

import ie.com.chatbot.domain.UserInput;

@Component("MainMenu")
public class MainMenuAction extends BaseAction {
	
	@Override
	public void _run(UserInput input) {	
		System.out.println("-----------------------------------------------------");
		System.out.println("-----------------------------------------------------");
		System.out.println("Welcome to Chat Bot, here are your options: ");
		System.out.println("1 - Generate Recommendation");
		System.out.println("2 - Show Profile");
	}


}

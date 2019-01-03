package ie.com.chatbot.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ie.com.chatbot.domain.UserInput;
import ie.com.chatbot.service.UserProfileService;

@Component("ShowProfile")
public class ShowProfileAction extends BaseAction {
	@Autowired
	UserProfileService service;

	@Override
	public void _run(UserInput input) {
		System.out.println("Profile coming");
		System.out.println(service.getUser(input.getUserId()));		
	}
}

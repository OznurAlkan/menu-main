package ie.com.chatbot.service;

import org.springframework.stereotype.Component;

import ie.com.chatbot.domain.User;

@Component
public class UserProfileService extends BaseBotService{
	
	public User getUser(String userId)  {
		return (User)caller.get("http://localhost:9090/users/"+userId,User.class);		
	}

}

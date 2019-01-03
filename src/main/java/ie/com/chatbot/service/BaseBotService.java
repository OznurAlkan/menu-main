package ie.com.chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseBotService {
	@Autowired
	protected RestCaller caller;
}

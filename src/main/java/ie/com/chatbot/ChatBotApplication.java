package ie.com.chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import ie.com.chatbot.listener.ChatBotCommandListener;

@SpringBootApplication
public class ChatBotApplication {
	@Autowired
	private ChatBotCommandListener chatBotListener;
	
	public static void main(String[] args) {
		SpringApplication.run(ChatBotApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void startChat() {
		
		chatBotListener.startChat(("1"));
	}

}

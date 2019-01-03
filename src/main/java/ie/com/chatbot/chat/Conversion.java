package ie.com.chatbot.chat;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class Conversion {

	private Map<String, ConversationState> chats = new HashMap<>();

	public ConversationState createNewChat(String userId) {
		ConversationState chat = new ConversationState(userId);
		chats.put(userId, chat);
		return chat;
	}

	public void closeChat(ConversationState chat) {
		chats.remove(chat.getUserId());
	}

	public ConversationState getUserCurrentChat(String userId) {
		return chats.get(userId);
	}

}

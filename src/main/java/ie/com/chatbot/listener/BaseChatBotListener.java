package ie.com.chatbot.listener;

import org.springframework.beans.factory.annotation.Autowired;

import ie.com.chatbot.chat.Conversion;
import ie.com.chatbot.tree.TreeBuilder;

public abstract class BaseChatBotListener {
	@Autowired
	protected Conversion conversion;
	@Autowired
	protected TreeBuilder builder;
}

package ie.com.chatbot.listener;

import org.springframework.stereotype.Component;

import ie.com.chatbot.chat.ConversationState;
import ie.com.chatbot.domain.UserInput;
import ie.com.chatbot.tree.Tree;

@Component
public class ChatBotWebListener extends BaseChatBotListener {

	public void startChat(String userId) {
		Tree tree = builder.testTreeBuild();
		ConversationState chat = conversion.createNewChat(userId);
		chat.setTree(tree);
		tree.processNode(null);
	}

	public void userTyping(UserInput input, String userId) {
		Tree tree = conversion.getUserCurrentChat(userId).getTree();
		if (tree.validateInput(input)) {
			tree.nextNode(input.getChoice());
		}

	}

}

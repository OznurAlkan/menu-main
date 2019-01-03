package ie.com.chatbot.listener;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ie.com.chatbot.ShutdownManager;
import ie.com.chatbot.chat.ConversationState;
import ie.com.chatbot.domain.UserInput;
import ie.com.chatbot.tree.Tree;

@Component
public class ChatBotCommandListener extends BaseChatBotListener {
	@Autowired
	private ShutdownManager shutdownManager;
	private Scanner scanner;

	@PostConstruct
	public void initialize() {
		scanner = new Scanner(System.in);
	}

	public void startChat(String userId) {
		UserInput input = new UserInput(userId);
		Tree tree = builder.testTreeBuild();
		ConversationState chat = conversion.createNewChat(userId);
		chat.setTree(tree);
		keepTalking(input);
	}

	public void keepTalking(UserInput input) {
		Tree tree = conversion.getUserCurrentChat(input.getUserId()).getTree();
		tree.processNode(input);
		boolean validation = false;
		while (!validation) {
			String userResponse = scanner.next();
			String[] inputText = StringUtils.split(userResponse, "-");
			input.setChoice(inputText[0]);
			if (inputText.length > 1) {	
				List<String> params = Arrays.asList(inputText);							
				input.setParemeters(params.subList(1, inputText.length));
			}
			validation = tree.validateInput(input);
		}
		tree.nextNode(input.getChoice());
		if (input.getChoice().equals("03")) {
			shutdownManager.initiateShutdown(-1);
		} else {
			keepTalking(input);
		}
	}

}

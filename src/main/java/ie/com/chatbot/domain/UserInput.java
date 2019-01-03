package ie.com.chatbot.domain;

import java.util.List;

public class UserInput {

	private String userId;
	private String choice;
	private List<String> paremeters;

	public UserInput(String userId) {
		this.userId = userId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public List<String> getParemeters() {
		return paremeters;
	}

	public void setParemeters(List<String> paremeters) {
		this.paremeters = paremeters;
	}
}

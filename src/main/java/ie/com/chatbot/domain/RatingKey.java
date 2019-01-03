package ie.com.chatbot.domain;

import java.io.Serializable;

public class RatingKey implements Serializable {
	private String userId;
	private Item item;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "RatingKey [item=" + item + "]";
	}

	
}

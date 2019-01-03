package ie.com.chatbot.domain;

import java.util.List;
import java.util.stream.Collectors;

public class User {

	private String id;

	private List<Rating> ratings;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", ratings=" + ratings.stream().map(Rating::toString).collect(Collectors.joining(","))
				+ "]";
	}
}

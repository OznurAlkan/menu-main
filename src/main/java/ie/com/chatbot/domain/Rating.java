package ie.com.chatbot.domain;


public class Rating {
	
	private RatingKey key;

	private double rating;

	public RatingKey getKey() {
		return key;
	}

	public void setKey(RatingKey key) {
		this.key = key;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [key=" + key + ", rating=" + rating + "]";
	}

}

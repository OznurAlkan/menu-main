package ie.com.chatbot.service.myca;

public class MycaRecommenderStatus {
	private boolean running;
	private boolean ready;
	public boolean isRunning() {
		return running;
	}
	public void setRunning(boolean running) {
		this.running = running;
	}
	public boolean isReady() {
		return ready;
	}
	public void setReady(boolean ready) {
		this.ready = ready;
	}
	
}

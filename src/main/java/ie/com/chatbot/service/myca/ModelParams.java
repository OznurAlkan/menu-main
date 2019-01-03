package ie.com.chatbot.service.myca;

import java.util.HashMap;
import java.util.Map;

public class ModelParams {
	private String id;
	private String kind;
	private String inputPersonsFile;
	private String inputJobsFile;
	private boolean deriveSkillsFromJobs;
	private Map<String, Double> weights;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public String getInputPersonsFile() {
		return inputPersonsFile;
	}
	public void setInputPersonsFile(String inputPersonsFile) {
		this.inputPersonsFile = inputPersonsFile;
	}
	public String getInputJobsFile() {
		return inputJobsFile;
	}
	public void setInputJobsFile(String inputJobsFile) {
		this.inputJobsFile = inputJobsFile;
	}
	public boolean isDeriveSkillsFromJobs() {
		return deriveSkillsFromJobs;
	}
	public void setDeriveSkillsFromJobs(boolean deriveSkillsFromJobs) {
		this.deriveSkillsFromJobs = deriveSkillsFromJobs;
	}
	public Map<String, Double> getWeights() {
		return weights;
	}
	public void setWeights(Map<String, Double> weights) {
		this.weights = weights;
	}
	public ModelParams(String id, String kind, String inputPersonsFile, String inputJobsFile,
			boolean deriveSkillsFromJobs, Map<String, Double> weights) {
		super();
		this.id = id;
		this.kind = kind;
		this.inputPersonsFile = inputPersonsFile;
		this.inputJobsFile = inputJobsFile;
		this.deriveSkillsFromJobs = deriveSkillsFromJobs;
		this.weights = weights;
	}

}

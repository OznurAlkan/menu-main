package ie.com.chatbot.service.myca;

import java.util.HashMap;

public class MycaModelParams {
	private static String id = MycaGoalRecommender.modelId;
	public static String kind = "maxsp";
	public static String inputPersonsFile = MycaGoalRecConstants.datasetPath + MycaGoalRecConstants.trainingSubDataset;
	public static String inputJobsFile = MycaGoalRecConstants.datasetPath + MycaGoalRecConstants.jobsData;
	public static boolean deriveSkillsFromJobs = true;
	public static HashMap<String, Double> weights;

	public static void initializeWeights() {
		weights = new HashMap<String, Double>();
		weights.put("pattern_skills", 1.0);
		weights.put("pattern_attributes", 1.0);
		weights.put("pattern_concepts", 1.0);
		weights.put("pattern_jobs", 1.0);
		weights.put("pattern_support", 1.0);
		weights.put("goal_patterns", 1.0);
		weights.put("goal_proficiency", 0.00051);
	}
	
	
	public static ModelParams createMycaModelConstants() {
		return new ModelParams(id, kind, inputPersonsFile, inputJobsFile, deriveSkillsFromJobs, weights);
	}
}

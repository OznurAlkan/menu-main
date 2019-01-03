package ie.com.chatbot.service.myca;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import recommender.myca.model.GoalRecPerson;
import recommender.myca.model.GoalRecTestPerson;
import recommender.myca.model.JobId;
import recommender.myca.model.Person;
import recommender.myca.model.Recommendation;
import recommender.myca.model.RecommendationEvaluator;
import recommender.myca.model.SkillProficiencyEvaluator;
import util.Constants;
*/

public class MycaGoalRecommender {

	private static String APIURL = "http://localhost:8081/";
	public static String modelIdKaggle = "kaggle";
	public static String modelIdIbm = "ibm";
	public static String modelId = "modelIdIbm";

	public static String getResponseStringFromConn(HttpURLConnection conn) throws IOException {
		StringBuilder response = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			response.append(line);
		}
		return response.toString();
	}

	public void deleteModel() {
		// title = URLEncoder.encode(title, "ISO-8859-1");
		String query = APIURL + "models/" + modelId;
		HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) new URL(query).openConnection();
			conn.setRequestMethod("DELETE");
			String response = getResponseStringFromConn(conn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	public void buildModel() {
		// title = URLEncoder.encode(title, "ISO-8859-1");
		String url = APIURL + modelId + "/trainer/start";
		HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("GET");
			String response = getResponseStringFromConn(conn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	/*	
	 * 
	public MycaRecommenderStatus askStatus() {
		// title = URLEncoder.encode(title, "ISO-8859-1");
		String url = APIURL + modelId + "/trainer/status";
		HttpURLConnection conn;
		MycaRecommenderStatus status = null;
		try {
			conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("GET");
			String response = getResponseStringFromConn(conn);
			status = new Gson().fromJson(response, new TypeToken<MycaRecommenderStatus>() {
			}.getType());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return status;
	}

	public void rebuildModel() {
		deleteModel();
		createModel();
		buildModel();
	}

	public void createModel() {
		String query = APIURL + "models";
		HttpURLConnection conn;
		try {
			conn = (HttpURLConnection) new URL(query).openConnection();
			String jsonObject = new Gson().toJson(MycaModelParams.createMycaModelConstants());
			byte[] postData = jsonObject.getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setUseCaches(false);
			try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
				wr.write(postData);
			}

			String response = getResponseStringFromConn(conn);
			// System.out.print(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	public void getRecommendations() {
		// title = URLEncoder.encode(title, "ISO-8859-1");
		String query = APIURL + modelId + "recommend";
		HttpURLConnection conn;
		try {
			
			
			 * { "attributes": [ ], "skills":{
			 * "tbf3030":{"value":"tbf3030","proficiency":1.0}, "i0970":
			 * {"value":"i0970","proficiency":1.0}, "tbf1000":
			 * {"value":"tbf1000","proficiency":1.0}, "i0960":
			 * {"value":"i0960","proficiency":1.0}, "tbf0110":
			 * {"value":"tbf0110","proficiency":1.0} }, "jobs": [ "SLS630" ] }
			 * 
			 
			GoalRecPerson person = new GoalRecPerson();
			Map<String,SkillProficiencyEvaluator> skills= new HashMap<String,SkillProficiencyEvaluator>();
			skills.put("i0970", new SkillProficiencyEvaluator("i0970", 1.0));
			skills.put("tbf3030", new SkillProficiencyEvaluator("tbf3030", 1.0));
			skills.put("i0960", new SkillProficiencyEvaluator("i0960", 1.0));
			skills.put("tbf0110", new SkillProficiencyEvaluator("tbf0110", 1.0));
			person.setSkills(skills);
			List<JobId> jobs = new ArrayList<>();
			jobs.add(new JobId("SLS630"));
			person.setJobs(jobs);
			
			conn = (HttpURLConnection) new URL(query).openConnection();
			String jsonObject = new Gson().toJson(person);
			byte[] postData = jsonObject.getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setUseCaches(false);
			try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
				wr.write(postData);
			}

			String response = getResponseStringFromConn(conn);
			//System.out.print(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	public RecommendationEvaluator getRecommendations (GoalRecTestPerson testUser) {
		String query = APIURL + modelId + "/recommend?limit=" + Constants.topN;
		HttpURLConnection conn;
		Recommendation recommendation = null;
		try {
			if(testUser.getEarliestStage() != null) {
				query += "&earliestStage=" + testUser.getEarliestStage();
				query += "&latestStage=" + testUser.getLatestStage();
			}
			conn = (HttpURLConnection) new URL(query).openConnection();
			testUser.getGoalRecPerson().setJobs(testUser.getJobsTrain().stream().collect(Collectors.toList()));
			String jsonObject = new Gson().toJson(new Person(testUser.getGoalRecPerson()));
			byte[] postData = jsonObject.getBytes(StandardCharsets.UTF_8);
			int postDataLength = postData.length;
			conn.setDoOutput(true);
			conn.setInstanceFollowRedirects(false);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("charset", "utf-8");
			conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
			conn.setUseCaches(false);
			try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
				wr.write(postData);
			}
			String response = getResponseStringFromConn(conn);
			//System.out.println(response);
			recommendation = new Gson().fromJson(response, new TypeToken<Recommendation>() {}.getType());
			return new RecommendationEvaluator(recommendation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return null;
	}*/
}

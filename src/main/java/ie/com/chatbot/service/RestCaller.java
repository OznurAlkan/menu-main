package ie.com.chatbot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;

@Service
public class RestCaller {
	public Object get(String query,Class clazz) {
		try {
			HttpURLConnection conn = (HttpURLConnection) new URL(query).openConnection();
			conn.setRequestMethod("GET");
			String response = getResponseStringFromConn(conn);
			return new Gson().fromJson(response, clazz);			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String getResponseStringFromConn(HttpURLConnection conn) throws IOException {
		StringBuilder response = new StringBuilder();

		BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			response.append(line);
		}

		return response.toString();
	}
}

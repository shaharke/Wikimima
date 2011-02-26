package com.wikimima.wiki.comm;

import java.io.IOException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.stereotype.Component;

@Component
public class WikipediaHttpGateway implements WikipediaFacade {
	
	@Override
	public String getRandomTitle() throws IOException {
		HttpClient client = new DefaultHttpClient();
		HttpGet httpget = new HttpGet("http://en.wikipedia.org/w/api.php?action=query&list=random&rnnamespace=0&rnlimit=1&format=json");
		httpget.addHeader("User-Agent", "Wikimima/0.0.1; shahar@gmail.com");
		String responseBody = client.execute(httpget, new BasicResponseHandler());
		JSONObject jsonObject = JSONObject.fromObject(responseBody);
		JSONArray titles = jsonObject.getJSONObject("query").getJSONArray("random");
		return titles.getJSONObject(0).getString("title");
	}
	
	

}

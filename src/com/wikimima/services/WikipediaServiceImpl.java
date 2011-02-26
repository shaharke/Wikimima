package com.wikimima.services;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wikimima.utils.WikiPageParser;

@Service
public class WikipediaServiceImpl implements WikipediaService {
	
	@Autowired
	private WikiPageParser parser;

	@Override
	public String getRandomTitle() throws TitleRetreivalException {
		String title = null;
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet httpget = new HttpGet("http://en.wikipedia.org/wiki/Special:Random");
			String responseBody = client.execute(httpget, new BasicResponseHandler());
			title = parser.getCleanTitle(responseBody);
		} catch (ClientProtocolException e) {
		} catch (IOException e) {
			throw new TitleRetreivalException("Failed to retreive random title from Wikipedia: " + e.getMessage() , e);
		}
		if (title == null) {
			throw new TitleRetreivalException("NULL title.");
		}
		return title;
	}

}

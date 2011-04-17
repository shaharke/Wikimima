package com.wikimima.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wikimima.wiki.comm.WikipediaFacade;

@Service("WikipediaService")
public class WikipediaTitleService implements TitleGenerationService {
	
	@Autowired
	private WikipediaFacade wikiApi; 

	@Override
	public String getRandomTitle() throws TitleRetreivalException {
		String title = null;
		try {
			title = wikiApi.getRandomTitle();
		} catch (IOException e) {
			throw new TitleRetreivalException("Failed to retreive random title from Wikipedia: " + e.getMessage() , e);
		}
		return title; 
	}

}

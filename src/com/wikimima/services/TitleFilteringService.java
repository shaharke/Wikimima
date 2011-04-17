package com.wikimima.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wikimima.logic.Filter;

@Service("TitleService")
public class TitleFilteringService implements TitleGenerationService {
	
	private TitleGenerationService service;
	
	private Filter titleFilter;
	
	@Autowired
	public TitleFilteringService(@Qualifier("WikipediaService")TitleGenerationService service, @Qualifier("FilterChain")Filter titleFilter) {
		this.service = service;
		this.titleFilter = titleFilter;
	}

	@Override
	public String getRandomTitle() throws TitleRetreivalException {
		String randomTitle = service.getRandomTitle();
		if (titleFilter.filter(randomTitle)) {
			return randomTitle;
		}
		return getRandomTitle();
	}
	
}

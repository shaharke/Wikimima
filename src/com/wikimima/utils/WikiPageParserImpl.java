package com.wikimima.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class WikiPageParserImpl implements WikiPageParser {
	
	private static final Pattern titlePattern = Pattern.compile("<title>(.+) - Wikipedia.+</title>");

	@Override
	public String getCleanTitle(String page) {
		String title = null;
		Matcher matcher = titlePattern.matcher(page);
		if (matcher.find()) {
			title = matcher.group(1);
		}
		return title;
	}

}

package com.wikimima.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class NumericTitleFilter implements Filter {
	
	private static final Pattern wordCharacterMatcher = Pattern.compile("[a-zA-Z]+");

	@Override
	public boolean filter(String title) {
		Matcher match = wordCharacterMatcher.matcher(title);
		if (match.find()) {
			return true;
		}
		return false;
	}

}

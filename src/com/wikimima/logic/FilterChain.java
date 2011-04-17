package com.wikimima.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("FilterChain")
public class FilterChain implements Filter {
	
	private List<Filter> filters;
	
	@Autowired
	public FilterChain(List<Filter> filters) {
		this.filters = filters;
	}

	@Override
	public boolean filter(String title) {
		for (Filter filter : filters) {
			if (!filter.filter(title)) {
				return false;
			}
		}
		return true;
	}

}

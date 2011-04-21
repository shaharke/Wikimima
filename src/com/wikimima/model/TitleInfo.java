package com.wikimima.model;

import java.util.concurrent.atomic.AtomicInteger;

public class TitleInfo {
	
	private int id;
	
	private String title;
	
	private AtomicInteger skipCount = new AtomicInteger();
	
	private AtomicInteger selectionCount = new AtomicInteger();;
	
	public TitleInfo(String title) {
		this.title = title;
	}
	
	public TitleInfo(int id, String title, int skipCount, int selectionCount) {
		this.id = id;
		this.title = title;
		this.skipCount.set(skipCount);
		this.selectionCount.set(selectionCount);
	}
	
	public int skip() {
		return skipCount.addAndGet(1);
	}
	
	public int select() {
		return selectionCount.addAndGet(1);
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getSelectionCount() {
		return selectionCount.get();
	}
	
	public int getSkipCount() {
		return skipCount.get();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
}

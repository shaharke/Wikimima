package com.wikimima.dal;

import java.util.List;

import com.wikimima.model.TitleInfo;

public interface TitlesDao {
	
	public TitleInfo save(TitleInfo info);
	
	public TitleInfo load(int id);
	
	public List<TitleInfo> loadAll();
	
	public void update(TitleInfo info);
	
	public void delete(TitleInfo info);
	
	public TitleInfo find(String title);

}

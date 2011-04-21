package com.wikimima.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.wikimima.model.TitleInfo;

@Repository
public class TitlesJdbcDao extends GenericDao implements TitlesDao {
	
	@PostConstruct
	public void init() {
		getJdbcInsert().setGeneratedKeyName("id");
		getJdbcInsert().setTableName("titles");
	}
	
	@Override
	public TitleInfo save(TitleInfo info) {
		Map<String, Object> fields = new HashMap<String, Object>();
		fields.put("title", info.getTitle());
		fields.put("skipCount", info.getSkipCount());
		fields.put("selectionCount", info.getSelectionCount());
		Number id = getJdbcInsert().executeAndReturnKey(fields);
		info.setId(id.intValue());
		return info;
	}

	@Override
	public TitleInfo load(int id) {
		return getJdbcTemplate().queryForObject("SELECT * FROM titles WHERE id=?", new BeanPropertyRowMapper<TitleInfo>(), id);
	}

	@Override
	public List<TitleInfo> loadAll() {
		return getJdbcTemplate().query("SELECT * FROM titles", new TitleInfoRowMapper(), Collections.emptyMap());
	}

	@Override
	public void update(TitleInfo info) {
		getJdbcTemplate().update("UPDATE titles SET skipCount=?, selectionCount=? WHERE id=? ", info.getSkipCount(), info.getSelectionCount(), info.getId());
	}

	@Override
	public void delete(TitleInfo info) {
		getJdbcTemplate().update("DELETE * FROM titles WHERE id=?", info.getId());
	}
	
	@Override
	public TitleInfo find(String title) {
		try {
			List<TitleInfo> titles = getJdbcTemplate().query("SELECT * FROM titles WHERE title=?", new TitleInfoRowMapper(), title);
			if (titles.isEmpty()) {
				return null;
			}
			return titles.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public class TitleInfoRowMapper implements RowMapper<TitleInfo> {

		@Override
		public TitleInfo mapRow(ResultSet rs, int rowCount) throws SQLException {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			int skipCount = rs.getInt("skipCount");
			int selectionCount = rs.getInt("selectionCount");
			return new TitleInfo(id, title, skipCount, selectionCount);
		}
		
	}
	
}

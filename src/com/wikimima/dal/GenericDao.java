package com.wikimima.dal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public abstract class GenericDao {
	
	private SimpleJdbcTemplate jdbcTemplate;
	private SimpleJdbcInsert jdbcInsert;

	@Autowired
	@Required
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
		this.jdbcInsert = new SimpleJdbcInsert(dataSource);
	}
	
	public SimpleJdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	public SimpleJdbcInsert getJdbcInsert() {
		return jdbcInsert;
	}

}

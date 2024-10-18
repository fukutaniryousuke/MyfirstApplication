package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entiry.Servey;

@Repository // DBを操作するクラスということをDIコンテナ(Spring Boot)に示す
public class ServeyDaoImpl implements ServeyDao {

	//DBを操作する用のクラスの初期化
	private final JdbcTemplate jdbcTemplate;

	@Autowired //JdbcTemplateを読み込む
	public ServeyDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertServey(Servey servey) {
		jdbcTemplate.update("INSERT INTO servey(age, satisfaction, comment, created) VALUES(?, ?, ?, ?)",
				servey.getAge(), servey.getSatisfaction(), servey.getComment(), servey.getCreated());

	}

	@Override
	public List<Servey> getAll() {
		String sql = "SELECT id, age, satisfaction, comment, created";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Servey> list = new ArrayList<Servey>();
		for (Map<String, Object> result : resultList) {
			Servey servey = new Servey();
			servey.setId((int) result.get("id"));
			servey.setAge((int) result.get("age"));
			servey.setSatisfaction((int) result.get("satisfaction"));
			servey.setComment((String) result.get("comment"));
			servey.setCreated(((Timestamp) result.get("creaated")).toLocalDateTime());
			list.add(servey);
		}
		return list;
	}

}

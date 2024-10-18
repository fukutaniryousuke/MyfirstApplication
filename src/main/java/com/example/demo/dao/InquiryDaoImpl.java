package com.example.demo.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entiry.Inquiry;

@Repository // DBを操作するクラスということをDIコンテナ(Spring Boot)に示す
public class InquiryDaoImpl implements InquiryDao {

	//DBを操作する用のクラス
	private final JdbcTemplate jdbcTemplate;

	//JdbcTemplateを読み込む
	@Autowired
	public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insertInquiry(Inquiry inquiry) {
		jdbcTemplate.update("INSERT INTO inquiry(name, email, contents, created) VALUES(?, ?, ?, ?)",
				inquiry.getName(), inquiry.getEmail(), inquiry.getContents(), inquiry.getCreated());

	}

	@Override
	public List<Inquiry> getAll() {
		String sql = "SELECT id, name, email, contents, created FROM inquiry";
		List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);
		List<Inquiry> list = new ArrayList<Inquiry>();
		for (Map<String, Object> result : resultList) {
			Inquiry inquiry = new Inquiry();
			inquiry.setId((int) result.get("id"));
			inquiry.setName((String) result.get("name"));
			inquiry.setEmail((String) result.get("email"));
			inquiry.setContents((String) result.get("contents"));
			//Timestamp型で送られてくる。toLocalDateTime()でLocalDateTime型に戻す
			inquiry.setCreated(((Timestamp) result.get("created")).toLocalDateTime());
			list.add(inquiry);
		}
		return list;
	}

}

package com.example.demo.dao;

import java.util.List;

import com.example.demo.entiry.Servey;

public interface ServeyDao {
	
	void insertServey(Servey servey);
	
	List<Servey> getAll();

}

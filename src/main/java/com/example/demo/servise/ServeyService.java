package com.example.demo.servise;

import java.util.List;

import com.example.demo.entiry.Servey;

public interface ServeyService {

	void save(Servey servey);
	
	List<Servey> getAll();
}

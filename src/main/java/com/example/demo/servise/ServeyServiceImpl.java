package com.example.demo.servise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ServeyDao;
import com.example.demo.entiry.Servey;

@Service
public class ServeyServiceImpl implements ServeyService {
	
	//Daoの初期化
	private final ServeyDao dao;
	
	@Autowired
	public ServeyServiceImpl(ServeyDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Servey servey) {
		dao.insertServey(servey);

	}

	@Override
	public List<Servey> getAll() {
		return dao.getAll();
	}

}

package com.example.demo.servise;

import java.util.List;

import com.example.demo.entiry.Inquiry;

public interface InquiryService {

	void save(Inquiry inquiry);
	
	List<Inquiry> getAll();
}

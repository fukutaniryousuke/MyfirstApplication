package com.example.demo.servise;

public class InquiryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public InquiryNotFoundException(String messae) {
		super(messae);
	}

}

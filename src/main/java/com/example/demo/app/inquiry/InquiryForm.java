package com.example.demo.app.inquiry;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class InquiryForm {

	@NotBlank(message = "{name.notblank}")
	@Size(min = 1, max = 20, message = "{name.size}")
	private String name;

	@NotBlank(message = "{email.notblank}")
	@Email(message = "{email.invalid}")
	private String email;

	@NotBlank(message = "{contents.notblank}")
	private String contents;

	public InquiryForm() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}

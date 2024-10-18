package com.example.demo.app.servey;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ServeyForm {

	//int型は@Notblankと@Sizeが使用できない
	@Min(value=0, message="{age.size}")
	@Max(value=150, message="{age.size}")
	private int age;
	
	@Min(value=1, message="{satisfaction.size}")
	@Max(value=5, message="{satisfaction.size}")
	private int satisfaction;
	
	@Size(min=1, max= 200, message="{comment.size}")
	@NotBlank(message="{comment.notblank}")
	private String comment;
	
	public ServeyForm() {}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSatisfaction() {
		return satisfaction;
	}

	public void setSatisfaction(int satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}

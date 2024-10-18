package com.example.demo.entiry;

import java.time.LocalDateTime;

public class Servey {

	//データ
	private int id;
	private int age;
	private int satisfaction;
	private String comment;
	private LocalDateTime created;

	//デフォルトコンストラクタ
	public Servey() {
	}

	//ゲッター・セッター
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

}

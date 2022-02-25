package com.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Answer {

	@Id
	private int answer_id;
	private String description;

	public int getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Answer [answer_id=" + answer_id + ", description=" + description + "]";
	}

}

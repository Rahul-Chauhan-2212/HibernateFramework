package com.hibernate.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Question {

	@Id
	private int question_id;
	private String description;

	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "answer_id") private Answer answer;
	 */
	@OneToMany(mappedBy = "question")
	private List<Answer> answer;

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public Answer getAnswer() { return answer; }
	 * 
	 * public void setAnswer(Answer answer) { this.answer = answer; }
	 */
	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [question_id=" + question_id + ", description=" + description + ", answer=" + answer + "]";
	}

}

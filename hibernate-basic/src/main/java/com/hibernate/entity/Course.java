package com.hibernate.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Course {

	private String course_name;
	private String duration;

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Course [course_name=" + course_name + ", duration=" + duration + "]";
	}

}

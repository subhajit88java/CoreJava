package com.subhajit.model;

public class StudentMarks {
	
	private Integer id;
	private Integer marks;
	
	public StudentMarks(Integer id, Integer marks) {
		super();
		this.id = id;
		this.marks = marks;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "StudentMarks [id=" + id + ", marks=" + marks + "]";
	}

}

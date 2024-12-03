package com.subhajit.model;

public class TeacherSql {
	
	private Integer teacherId;
	private String teacherName;
	private String teacherCity;
	private Long teacherSalary;
	
	public TeacherSql(Integer teacherId, String teacherName, String teacherCity, Long teacherSalary) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherCity = teacherCity;
		this.teacherSalary = teacherSalary;
	}
	
	public Integer getTeacherId() {
		return teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public String getTeacherCity() {
		return teacherCity;
	}

	public Long getTeacherSalary() {
		return teacherSalary;
	}

	@Override
	public String toString() {
		return "TeacherSql [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherCity=" + teacherCity
				+ ", teacherSalary=" + teacherSalary + "]";
	}
	
	
}

package com.example.feignClient.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentModel 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String studentName;
	private String studentCity;
	private String studentMail;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentCity() {
		return studentCity;
	}
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}
	public String getStudentMail() {
		return studentMail;
	}
	public void setStudentMail(String studentMail) {
		this.studentMail = studentMail;
	}
	public StudentModel(long id, String studentName, String studentCity, String studentMail) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.studentCity = studentCity;
		this.studentMail = studentMail;
	}
	public StudentModel() {
		super();
	}
	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", studentName=" + studentName + ", studentCity=" + studentCity
				+ ", studentMail=" + studentMail + "]";
	}
}

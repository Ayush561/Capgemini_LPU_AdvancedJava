package com.practice.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //To make the class as table we use '@Entity' annotation.
@Table(name="Student_Info")
public class Student {
	
	@Id //To make id as primary key - '@Id' is the annotation.
	@Column(name="Student_id")
	private int sid;
	@Column(name="Student_name")
	private String sname;
	@Column(name="Student_Percentage")
	private double percentage;
	@Column(name="Student_DOB")
	private String dob;
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", percentage=" + percentage + ", dob=" + dob + "]";
	}
	
	
}

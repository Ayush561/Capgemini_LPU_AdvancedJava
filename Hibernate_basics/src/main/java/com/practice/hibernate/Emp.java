package com.practice.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Emp {
	
	private String ename;
	@Id
	private int eid;
	private double sal;
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	
	

}

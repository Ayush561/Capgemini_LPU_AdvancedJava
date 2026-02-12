package com.prac;

import java.util.ArrayList;

public class Emp_Assignment {
	private int id;
	private String name;
	private double sal;
	private int age;
	private String doj;
	private String branch;
	
	public Emp_Assignment(int id, String name, double sal, int age, String doj, String branch) {
		this.id = id;
		this.name = name;
		this.sal = sal;
		this.age = age;
		this.doj = doj;
		this.branch = branch;
	}
	
	public Emp_Assignment() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDOJ() {
		return doj;
	}
	public void setDOJ(String doj) {
		doj = doj;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Emp_Assignment [id=" + id + ", name=" + name + ", sal=" + sal + ", age=" + age + ", DOJ=" + doj
				+ ", branch=" + branch + "]";
	}
	
	
	
	public boolean listIsEmplty(ArrayList<Emp_Assignment> al) {
		if(al.isEmpty()) {
			return true;
		}
		return false;
		
	}
	
	
	public boolean isValidAge() {
		if(age<18) {
			return false;
		}
		return true;
		
	}
	
	
	public boolean validSize(ArrayList<Emp_Assignment> al) {
		if(al.size()<5) {
			return false;
		}
		return true;
	}

}

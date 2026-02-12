package com.practice.hibernate;

import javax.persistence.Persistence;

public class Emp_Driver {
	public static void main(String[] args) {
		Persistence.createEntityManagerFactory("postgres");
	}

}

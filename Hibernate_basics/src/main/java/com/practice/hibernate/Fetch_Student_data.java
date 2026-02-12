package com.practice.hibernate;

import javax.persistence.Persistence;
import javax.persistence.*;

public class Fetch_Student_data {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		//To fetch we have a method find in EntityManager
		
		Student s = em.find(Student.class,1);
		
		//System.out.println(s);//This will give reference of the object as we haven't override the toString()
		//or
		System.out.println(s.getSid()+" "+s.getSname()+" "+s.getDob()+" "+s.getPercentage());
		
	}

}

package com.practice.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Delete_StudentData {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		//To delete a row we have remove method in EntityManager but we have to use it with find method
		//Using find method we will search the row and pass it inside remove function.
		
		Student s = em.find(Student.class, 2);
		
		et.begin();
		em.remove(s);
		et.commit();
		
		//Delete is a CRUD operation that's why we need to commit it.
		
	}

}

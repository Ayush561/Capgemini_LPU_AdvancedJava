package com.practice.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Update_Student_info {
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Student s = em.find(Student.class,1);
		
		if(s!=null) {
			s.setDob("15-04-2001");
			et.begin();
			em.merge(s);
			et.commit();
			emf.close();
		}
		
	}

}

package com.practice.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Insert_StudentData_Using_Hibernate {
	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres"); //We have to give the persistence_unit name which was 'postgres' in the persistence.xml file.
		
		EntityManager em=emf.createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		Student s = new Student();
		s.setSid(1);
		s.setPercentage(80);
		s.setSname("Virat");
		s.setDob("01-11-2003");
		
		et.begin();
		em.persist(s);
		et.commit();
		
		Student s2 = new Student();
		s2.setSid(2);
		s2.setSname("Rohit");
		s2.setPercentage(83.45);
		s2.setDob("15-10-2002");
		
		et.begin();
		em.persist(s2);
		et.commit();
		
		emf.close();
		
	}

}

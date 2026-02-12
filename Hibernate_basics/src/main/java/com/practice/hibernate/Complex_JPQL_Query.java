package com.practice.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Complex_JPQL_Query {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public static void updateData(double newprice,double old_price) {
		String jpql = "update Product_Assignment p set p.price=?1 where p.price=?2";
		et.begin();
		
		Query q = em.createQuery(jpql);
		q.setParameter(1, newprice);
		q.setParameter(2, old_price);
		
		q.executeUpdate();
		et.commit();
		em.close();
		emf.close();
		
	}
	public static void main(String[] args) {
		updateData(80.0, 120.0);
		
	}
}

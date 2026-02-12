package com.practice.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Product_Assignment_ComplexQuery {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	
	static EntityManager em = emf.createEntityManager();
	
	static EntityTransaction et = em.getTransaction();
	
	public static void main(String[] args) {
		String jpql = "select p from Product_Assignment p where p.price>?1";
		
		Query query = em.createQuery(jpql);
		query.setParameter(1,100.0);
		
		List<Product_Assignment> list = query.getResultList();
		list.forEach(i->System.out.println("Name of the Products: "+i.getName()));
		
		String jpql2 = "select p from Product_Assignment p where p.name=?1";
		
		Query query2 = em.createQuery(jpql2);
		query2.setParameter(1,"pencil");
		
		List<Product_Assignment> list2 = query.getResultList();
		list.forEach(System.out::println);
		
		String j3 = "select p from Product_Assignment p where p.price>= ?1 and p.quantity>?2 ";
		
		Query q3 = em.createQuery(j3);
		q3.setParameter(1,50.0);
		q3.setParameter(2, 8);
		
		List<Product_Assignment> list3 = q3.getResultList();
		list3.forEach(System.out::println);
		
		
		//Variable Parameter
		String j4 = "select p from Product_Assignment p where p.price>= :a and p.quantity> :b";
		Query q4 = em.createQuery(j4);
		
		q4.setParameter("a",50.0);
		q4.setParameter("b",7);
		
		List<Product_Assignment> list4 = q4.getResultList();
		list4.forEach(System.out::println);
	}
	

}

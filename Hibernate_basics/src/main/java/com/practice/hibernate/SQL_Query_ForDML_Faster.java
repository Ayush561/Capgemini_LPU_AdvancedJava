package com.practice.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SQL_Query_ForDML_Faster {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String sql = "select * from product";
		Query q = em.createNativeQuery(sql);
		
		List<Product_Assignment> list = q.getResultList();
		System.out.println(list);   //This will give the address
		//as it will return Product_Assignment reference
		//That's why we don't use DQL in select in java.
		
		//We only use DML queries in SQL as it is faster in SQL than JPQL
		
		String sql2 = "update product set price=?1 where price>=?2";
		et.begin();
		Query q2 = em.createNativeQuery(sql2);
		q2.setParameter(1, 15.0);
		q2.setParameter(2,75);
		
		q2.executeUpdate();
		et.commit();
		
		
		
		
	}

}

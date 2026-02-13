package Mockito_Implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	
	public static void insertData(int id,String name,double balance) {
		Users u = em.find(Users.class, id);
		if(u==null) {
		Users u1 = new Users();
		u1.setId(id);
		u1.setName(name);
		u1.setBalance(balance);
		et.begin();
		em.persist(u1);
		et.commit();
		System.out.println("Data inserted...");
	}
		else {
			System.out.println("Data already existed");
		}
		
	}
	
	public static Users findById(int id) {
		Users u = em.find(Users.class, id);
		if(u!=null) {
			return u;
		}
		else {
			return null;
		}
	}
}

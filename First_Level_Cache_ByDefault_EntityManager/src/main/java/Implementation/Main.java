package Implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Main {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
//		Product p1 = new Product();
//		p1.setId(1);
//		p1.setName("Lux");
//		
//		Product p2 = new Product();
//		p2.setId(2);
//		p2.setName("Santoor");
//		
//		et.begin();
//		em.persist(p1);
//		em.persist(p2);
//		et.commit();
		
		read();
		
	}
	
	public static void read() {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
//		EntityManager em1 = emf.createEntityManager();
//		EntityTransaction et = em1.getTransaction();
//		
//		System.out.println("==========First Cache==========");
//		
//		Product p1 = em1.find(Product.class, 1);
//		
//		System.out.println(p1.getName());
//		
//		
//		Product p2 = em1.find(Product.class, 1);  //We are using same Entity Manager here so it will go to the em1 cache
//												  //and if 1 is present in that cache it will return otherwise it will
//												  //search in the main DB.
		//Here select will run only once.
//		System.out.println(p2.getName());
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em1 = emf.createEntityManager();
		EntityManager em2 = emf.createEntityManager();
		
		System.out.println("First Cache");
		Product p1 = em1.find(Product.class,1);
		System.out.println(p1.getName());
	
		System.out.println("Second Cache");
		Product p2 = em2.find(Product.class, 1);
		System.out.println(p2.getName());
		
		//Here select will run 2 times as we are creating different EntityManager so it will have different Cache memory
		
		
	}
}

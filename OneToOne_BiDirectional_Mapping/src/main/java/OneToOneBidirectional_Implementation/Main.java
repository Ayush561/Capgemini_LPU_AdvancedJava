package OneToOneBidirectional_Implementation;

//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;

//public class Main {
//	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
//		EntityManager em = emf.createEntityManager();
//		EntityTransaction et = em.getTransaction();
//		
//		Person p1 = new Person();
//		p1.setId(1);
//		p1.setName("Renu");
//		p1.setEmail("Renu@gmail.com");
//		p1.setPhoneNo("123456789");
//	
//		
//		Passport pp1 = new Passport();
//		pp1.setPass_id(101);
//		pp1.setName("Renusree");
//		pp1.setDob("10-MAR");
//		pp1.setCitizen("Indian");
//		pp1.setP(p1);
//		p1.setPp(pp1);
//		
//		et.begin();
//		//em.persist(pp1);//Cascading Passport in Person, so no need to persist it
//		em.persist(p1);
//		et.commit();
//	}
//
//}

public class Main {
    public static void main(String[] args) {

        Person p1 = new Person();
        p1.setId(1);
        p1.setName("Renu");
        p1.setEmail("Renu@gmail.com");
        p1.setPhoneNo("123456789");

        Passport pp1 = new Passport();
        pp1.setPass_id(101);
        pp1.setName("Renusree");
        pp1.setDob("10-MAR");
        pp1.setCitizen("Indian");

        p1.setPp(pp1);
        pp1.setP(p1);

        // CREATE
        PersonPassportDAO.insertPerson(p1);

        // READ
        System.out.println(PersonPassportDAO.findPersonById(1));

        // UPDATE (SQL)
        PersonPassportDAO.updatePersonUsingSQL(1, "Renu S", "9999999999", "renu@gmail.com");
        PersonPassportDAO.updatePassportUsingSQL(101, "Renusree S", "12-MAR", "Indian");

        // DELETE (SQL)
        // PersonPassportDAO.deletePersonUsingSQL(1);
        // PersonPassportDAO.deletePassportUsingSQL(101);
    }
}

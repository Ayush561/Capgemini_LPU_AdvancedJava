package OneToOneBidirectional_Implementation;

import javax.persistence.*;

public class PersonPassportDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction et = em.getTransaction();

   
    public static void insertPerson(Person p) {
        et.begin();
        em.persist(p);
        et.commit();
        System.out.println("Person & Passport inserted");
    }

    public static Person findPersonById(int id) {
        return em.find(Person.class, id);
    }

    
    public static Passport findPassportById(int id) {
        return em.find(Passport.class, id);
    }

    
    public static void updatePersonUsingSQL(int id, String newName, String newPhone, String newEmail) {

        String sql = "update person set name = ?1, phoneno = ?2, email = ?3 where id = ?4";
        Query q = em.createNativeQuery(sql);

        q.setParameter(1, newName);
        q.setParameter(2, newPhone);
        q.setParameter(3, newEmail);
        q.setParameter(4, id);

        et.begin();
        int rows = q.executeUpdate();
        et.commit();

        if (rows > 0) {
            System.out.println("Person updated using SQL");
        } else {
            System.out.println("Person not found");
        }
    }

    
    public static void updatePassportUsingSQL(int passId, String newName, String newDob, String newCitizen) {

        String sql = "update passport set name = ?1, dob = ?2, citizen = ?3 where pass_id = ?4";
        Query q = em.createNativeQuery(sql);

        q.setParameter(1, newName);
        q.setParameter(2, newDob);
        q.setParameter(3, newCitizen);
        q.setParameter(4, passId);

        et.begin();
        int rows = q.executeUpdate();
        et.commit();

        if (rows > 0) {
            System.out.println("Passport updated using SQL");
        } else {
            System.out.println("Passport not found");
        }
    }

    
    public static void deletePersonUsingSQL(int id) {

        // If person table has FK to passport, delete person first
        String sql1 = "update person set pp_pass_id = null where id = ?1";
        String sql2 = "delete from person where id = ?1";

        Query q1 = em.createNativeQuery(sql1);
        Query q2 = em.createNativeQuery(sql2);

        q1.setParameter(1, id);
        q2.setParameter(1, id);

        et.begin();
        q1.executeUpdate();  
        int rows = q2.executeUpdate();  // delete person
        et.commit();

        if (rows > 0) {
            System.out.println("Person deleted using SQL");
        } else {
            System.out.println("Person not found");
        }
    }

    public static void deletePassportUsingSQL(int passId) {

        String sql1 = "update person set pp_pass_id = null where pp_pass_id = ?1";
        String sql2 = "delete from passport where pass_id = ?1";

        Query q1 = em.createNativeQuery(sql1);
        Query q2 = em.createNativeQuery(sql2);

        q1.setParameter(1, passId);
        q2.setParameter(1, passId);

        et.begin();
        q1.executeUpdate();   // break relation
        int rows = q2.executeUpdate();  // delete passport
        et.commit();

        if (rows > 0) {
            System.out.println("Passport deleted using SQL");
        } else {
            System.out.println("Passport not found");
        }
    }
}

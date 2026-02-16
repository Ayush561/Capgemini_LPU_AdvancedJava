package OneToMany_ManyToOne_BiDirectional_Implementation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Create College
        College c1 = new College();
        c1.setId(1);
        c1.setName("ABC College");
        c1.setLocation("Delhi");
        c1.setPincode("110001");

        // Create Students
        Student s1 = new Student();
        s1.setSid(101);
        s1.setName("Ravi");
        s1.setBranch("CSE");

        Student s2 = new Student();
        s2.setSid(102);
        s2.setName("Neha");
        s2.setBranch("IT");

        // Link students to college (ManyToOne side)
        s1.setCollege(c1);
        s2.setCollege(c1);

        // Add students to college list (OneToMany side)
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        c1.setS(list);

        // Persist (parent first, then children)
        et.begin();
        em.persist(c1);
        em.persist(s1);
        em.persist(s2);
        et.commit();

        System.out.println("College and Students inserted successfully");
    }
}

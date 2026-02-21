package ManyToMany_Bidirectional_Implementation;

import javax.persistence.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        
        Student s1 = new Student();
        s1.setName("AYUSH");
        s1.setBranch("CSE");

        Student s2 = new Student();
        s2.setName("Himani");
        s2.setBranch("MEC");

        Student s3 = new Student();
        s3.setName("Dhruv");
        s3.setBranch("CSE");

       
        Subject sub1 = new Subject();
        sub1.setId(101);
        sub1.setName("MATHS");
        sub1.setNoOfDays(3);

        Subject sub2 = new Subject();
        sub2.setId(102);
        sub2.setName("Science");
        sub2.setNoOfDays(3);

        
        Set<Student> stuSet1 = new HashSet<>();
        stuSet1.add(s1);
        stuSet1.add(s2);
        sub1.setStudent(stuSet1);

        Set<Student> stuSet2 = new HashSet<>();
        stuSet2.add(s2);
        stuSet2.add(s3);
        sub2.setStudent(stuSet2);

   
        Set<Subject> subSet1 = new HashSet<>();
        subSet1.add(sub1);
        s1.setSubject(subSet1);

        Set<Subject> subSet2 = new HashSet<>();
        subSet2.add(sub1);
        subSet2.add(sub2);
        s2.setSubject(subSet2);

        Set<Subject> subSet3 = new HashSet<>();
        subSet3.add(sub2);
        s3.setSubject(subSet3);

        
        et.begin();
        em.persist(s1);
        em.persist(s2);
        em.persist(s3);
        em.persist(sub1);
        em.persist(sub2);
        et.commit();

        em.close();
        emf.close();
    }
}
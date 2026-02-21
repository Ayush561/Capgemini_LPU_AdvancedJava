package One_To_Many_ByDefault_Lazy_To_Eager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StudentCollegeDAO {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    static EntityManager em = emf.createEntityManager();
    static EntityTransaction et = em.getTransaction();

    // Insert Student
    public static void insertStudent(Student s) {
        et.begin();
        em.persist(s);
        et.commit();
    }

    // Insert College
    public static void insertCollege(College c) {
        et.begin();
        em.persist(c);
        et.commit();
    }

    // Find Student by Id
    public static Student findStudentById(int id) {
        return em.find(Student.class, id);
    }

    // Find College by Id
    public static College findCollegeById(int id) {
        return em.find(College.class, id);
    }

    // Update Student
    public static boolean updateStudent(int id, String newName, String newBranch) {
        Student s = em.find(Student.class, id);
        if (s != null) {
            et.begin();
            s.setName(newName);
            s.setBranch(newBranch);
            et.commit();
            return true;
        }
        return false;
    }

   
 // Delete Student by Id (also remove mapping table entry)
    public static void deleteStudentById(int id) {
        String sql1 = "delete from college_student where s_sid=?1";
        String sql2 = "delete from student where sid=?1";

        Query q1 = em.createNativeQuery(sql1);
        Query q2 = em.createNativeQuery(sql2);

        q1.setParameter(1, id);
        q2.setParameter(1, id);

        et.begin();
        q1.executeUpdate();
        q2.executeUpdate();
        et.commit();

        System.out.println("Student data deleted..");
    }


    // Add existing student to college
    public static boolean addStudentToCollege(int studentId, int collegeId) {
        Student s = em.find(Student.class, studentId);
        College c = em.find(College.class, collegeId);

        if (s != null && c != null) {
            List<Student> list = c.getS();
            list.add(s);
            c.setS(list);

            et.begin();
            em.merge(c);
            et.commit();
            return true;
        }
        return false;
    }
    
    
    public static void deleteCollegeById(int id) {
        College c = em.find(College.class, id);
        if (c != null) {
            et.begin();
            em.remove(c);
            et.commit();
            System.out.println("College deleted..");
        }
    }

    
    
}

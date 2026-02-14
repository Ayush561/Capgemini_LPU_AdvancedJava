package OneToManyImplmentation;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.setSid(101);
        s1.setName("Rohit");
        s1.setBranch("CSE");

        Student s2 = new Student();
        s2.setSid(102);
        s2.setBranch("ECE");
        s2.setName("Miller");

        Student s3 = new Student();
        s3.setSid(103);
        s3.setBranch("MEC");
        s3.setName("John");

        College c1 = new College();
        c1.setId(1);
        c1.setName("ABC");
        c1.setLocation("Delhi");
        c1.setPincode("0001");

        List<Student> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);
        c1.setS(list1);

        College c2 = new College();
        c2.setId(2);
        c2.setName("XYZ");
        c2.setLocation("Banglore");
        c2.setPincode("0987");

        List<Student> list2 = new ArrayList<>();
        list2.add(s3);
        c2.setS(list2);

        StudentCollegeDAO.insertStudent(s1);
        StudentCollegeDAO.insertStudent(s2);
        StudentCollegeDAO.insertStudent(s3);

        StudentCollegeDAO.insertCollege(c1);
        StudentCollegeDAO.insertCollege(c2);

        //Creating another student and adding it to college
        Student s4 = new Student();
        s4.setSid(104);
        s4.setBranch("CSE");
        s4.setName("Ally");

        //Adding to the Student table
        StudentCollegeDAO.insertStudent(s4);

        //Adding it to College 1
        StudentCollegeDAO.addStudentToCollege(104, 1);

        
        //To delete a student by his id
        StudentCollegeDAO.deleteStudentById(104);
        
        //To delete a college by id
        StudentCollegeDAO.deleteCollegeById(1);

        
 
    }
}

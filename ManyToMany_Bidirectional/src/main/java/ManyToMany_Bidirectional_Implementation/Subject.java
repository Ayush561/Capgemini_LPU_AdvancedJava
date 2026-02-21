package ManyToMany_Bidirectional_Implementation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import java.util.*;

@Entity
public class Subject {
	@Id
	private int id;
	private String name;
	private int noOfDays;
	@ManyToMany(mappedBy = "subject")
	Set<Student> student;
	public Set<Student> getStudent() {
		return student;
	}
	public void setStudent(Set<Student> student) {
		this.student = student;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", noOfDays=" + noOfDays + "]";
	}
	
	

}

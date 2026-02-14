package ManyToOneImplementation;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {
	@Id
	private int id;
	private String name;
	private int numberEmp;
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
	public int getNumberEmp() {
		return numberEmp;
	}
	public void setNumberEmp(int numberEmp) {
		this.numberEmp = numberEmp;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", numberEmp=" + numberEmp + "]";
	}
	

}

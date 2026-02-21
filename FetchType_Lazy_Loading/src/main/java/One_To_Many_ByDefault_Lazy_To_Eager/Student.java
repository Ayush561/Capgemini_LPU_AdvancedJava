package One_To_Many_ByDefault_Lazy_To_Eager;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Student {
	@Id
	int sid;
	String name;
	String branch;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", branch=" + branch + "]";
	}
	
	
	
	
	

}


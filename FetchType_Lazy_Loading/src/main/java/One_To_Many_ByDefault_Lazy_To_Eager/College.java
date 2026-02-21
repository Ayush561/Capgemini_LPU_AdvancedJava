package One_To_Many_ByDefault_Lazy_To_Eager;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class College {
	@Id
	int id;
	String name;
	String location;
	String pincode;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@OneToMany(fetch=FetchType.EAGER)
	List<Student> s;
	public List<Student> getS() {
		return s;
	}
	public void setS(List<Student> s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return "College [id=" + id + ", name=" + name + ", location=" + location + ", pincode=" + pincode + ", s=" + s
				+ "]";
	}
	
	
	
	

}

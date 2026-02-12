package One_To_One_Mapping;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {
	
	@Id
	private int id;
	private String brand;
	private String mode;;
	private String modelYear;
	private double price;
	
	//Foreign key
	@OneToOne //It will go to engine class and it will take the primary key of Engine(id) and make that as a column in Car table.
	private Engine engine; //
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getModelYear() {
		return modelYear;
	}
	public void setModelYear(String modelYear) {
		this.modelYear = modelYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", mode=" + mode + ", modelYear=" + modelYear + ", price=" + price
				+ "]";
	}
	
	
	

}

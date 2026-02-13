package Mockito_Implementation;

//Business Logic
public class UserService {
	
	UserDao dao;  //Null value
	
	public UserService(UserDao dao) {
		this.dao=dao;  //To get all the data present inside Dao we will fetch it using constructor.
	}
	
	public String typeOfUser(int id) {
		Users user=dao.findById(id);
		if(user.getBalance()>0 && user.getBalance()<=10000) {
			return "New User";
		}
		else if(user.getBalance()>10000 && user.getBalance()<=40000) {
			return "Regular User";
		}
		else {
			return "Premium user";
		}
		
	}
	
	
	
	

}

package UserTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Mockito_Implementation.UserDao;
import Mockito_Implementation.UserService;

public class UserServiceTest {
	
	@Test
	public void testGetTypeOfCustomer() {
		UserDao userDao = new UserDao();  //Because service layer is using UserDao object reference
		UserService userService = new UserService(userDao);
		String actualRes = userService.typeOfUser(1);
		
		assertEquals("Premium user", actualRes);
	}

}

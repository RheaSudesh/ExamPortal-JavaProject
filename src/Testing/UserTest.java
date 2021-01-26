package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import Model.User;


public class UserTest {
	
  User user = new User ("rhea", "rheasudesh@gmail.com","Cse@2017",181);
		
		@Test
		public void testSetterGetter() {
			user.setEmail("rheasudesh@gmail.com");
			user.setPassword("Cse@2017");
			/*assertEquals("rheasudesh@gmail.com",user.getEmail());
			assertEquals("Cse@2017",user.getPassword());*/
			assertEquals(181,user.getRollNo());
			try {
				user.setRollNo(0);
				user.setEmail(null);
				user.setPassword(null);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}


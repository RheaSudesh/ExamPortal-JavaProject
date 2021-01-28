package Testing;

import static org.junit.Assert.*;
import org.junit.Test;

import Model.*;
import Validation.*;


public class UserTest {
	
  User user = new User ("rhea", "rheasudesh@gmail.com","Cse@2017",181);
		
		@Test
		public void testSetterGetter() {
			user.setEmail("rheasudesh@gmail.com");
			user.setPassword("Cse@2017");
			assertEquals("rheasudesh@gmail.com",user.getEmail());
			assertEquals("Cse@2017",user.getPassword());
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


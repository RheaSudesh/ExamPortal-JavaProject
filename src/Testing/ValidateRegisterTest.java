package Testing;

import static org.junit.Assert.*;
import org.junit.Test;
import Validation.ValidateRegister;

public class  ValidateRegisterTest{
	ValidateRegister rv = new ValidateRegister();
	
	@Test
	public void testCheckUserDetails() {
		
		assertEquals(true, rv.checkUserDetails("Rhea Sudesh",100,"rhea@gmail.com", "Rheapass@123", "Rheapass@123"));
		assertEquals(false, rv.checkUserDetails("Rhea Sudesh",100,"rheagmail.com", "Rhea@556", "Rhea@556"));
		assertEquals(false, rv.checkUserDetails("Rhea Sudesh",0,"rhea@gmail.com", "Rhea@556", "Rhea@556"));
		assertEquals(false, rv.checkUserDetails("Rhea",100,"rhea@gmail.com", "Rhea@556", "Rhea@556"));
		assertEquals(false, rv.checkUserDetails("Rhea Sudesh",100,"rhea@gmail.com", "Rhea@55", "Rhea@556"));
		assertEquals(false, rv.checkUserDetails("Rhea Sudesh",100,"rhea@gmail.com", "Rhea@rhea", "Rhea@rhea"));

		
		try {
			rv.checkUserDetails(null,0,null, null, null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	
}

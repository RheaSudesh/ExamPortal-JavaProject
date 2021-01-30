package Testing;

import static org.junit.Assert.*;
import org.junit.Test;

import Validation.ValidateLogin;

public class ValidateLoginTest {
	ValidateLogin vu = new ValidateLogin();
	
	@Test
	public void testValidate() {
		assertEquals(false,vu.adminValidation("Amin@gmail.com","Amin@556"));
		assertEquals(false,vu.adminValidation("admin", "admin1"));
		assertEquals(false,vu.adminValidation("admin1", "admin"));
		assertEquals(true,vu.adminValidation("Admin", "admin123"));
		try {
			vu.adminValidation(null, null);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}


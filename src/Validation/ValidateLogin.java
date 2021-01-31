package Validation;

public class ValidateLogin {
	
	public boolean adminValidation(String name, String pass){
		
		if(name.equals("Admin")&& pass.equals("admin123")) {
			return true;
		}
		else
		{
			System.out.println("Invalid login credentials");
			return false;
		}
		
	}
}

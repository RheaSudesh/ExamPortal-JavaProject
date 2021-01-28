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
	
	public boolean studentValidation(String name, String pass) {

		if(ValidateRegister.usermap.containsKey(name) && pass.equals(ValidateRegister.usermap.get(name))) {
			return true;
		}return false;
	}


}

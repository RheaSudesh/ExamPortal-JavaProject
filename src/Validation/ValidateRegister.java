package Validation;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateRegister {
	static Map<String, String> usermap = new TreeMap<String, String>(); 
	Set<String> emailset = new TreeSet<String>();
	String email,password,confirmpassword;	
		
		public boolean checkUserDetails(String name,int rollNo,String email, String password, String confirmPassword) 
		{
			if(validEmail(email) && validPassword(password,confirmPassword) && validName(name) && validRollNo(rollNo))
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
	
	
		private boolean validPassword(String password, String confirmpassword) {
	    	
	        String regex = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"  + "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$"; 
	        Pattern p = Pattern.compile(regex); 
	        Matcher m = p.matcher(password); 
	        if(m.matches())
	        {
	        	return true;
	        }
	        if (password.matches(confirmpassword)==false) 
	        { 
	        	System.out.println("Password does not match");
	            return false; 
	        } 
	        else
	        {
	        	System.out.println("In Password Please have atleast One UpperCase, One LowerCase, One digit and One special character.\n Try Again");
	        	return false;
	        }
	 
	    }
	    

	    private boolean validEmail(String email) {
	    	if(email!=null && email.contains("@"))
	    	{
		    	String[] email1=email.split("@");	
			    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+  "[a-zA-Z0-9_+&*-]+)*@" +  "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
			                  
				Pattern pat = Pattern.compile(emailRegex); 
				if (email1 == null) 
				{
					System.out.println("EmailId should not be null and be in proper format. Retry Registration");
					return false;
				}
				return pat.matcher(email).matches();
	    	}
	    	else
	    	{
	    		System.out.println("Should contain symbol @ and should not be null");
	    		return false;
	    	}
		    
	    }
	    
	    private boolean validName(String name)
	    {
	    	String regexName = "\\p{Upper}(\\p{Lower}+\\s?)";
	        String patternName = "(" + regexName + "){2,3}";
	        if( name.matches(patternName) )
	          return true;
	        else
	          {
	        	System.out.println("Invalid Name, Please include lastname and use Pascal Casing");
	        	return false;
	          }

	    }
	    
	    private boolean validRollNo(int rollNo)
	    {
	    	if(rollNo>0)
	          return true;
	        else
	          {
	        	System.out.println("Invalid RollNo");
	        	return false;
	          }

	    }


}

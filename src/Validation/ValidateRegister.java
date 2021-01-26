package Validation;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Model.User;


public class ValidateRegister {
	static Map<String, String> usermap = new TreeMap<String, String>(); 
	Set<String> emailset = new TreeSet<String>();
	String email,password,confirmpassword;
	
	
	public static void main(String args[]) {
		
		ArrayList<User> StudentList=new ArrayList<User>();
		Scanner sc=new Scanner(System.in);
		
		int choice=1;
		while(choice!=0)
		{
		System.out.println("_____________________________________\n");
		System.out.println("ONLINE EXAMINATION PORTAL");
		System.out.println("Menu");
		System.out.println("1. Login as Admin");
		System.out.println("2. Login as Student");
		System.out.println("3. Register as new Student");
		System.out.println("4. View Logged in Student Role");
		System.out.println("5. Exit");	
		System.out.println("\n Please choice your choice = ");
		choice=sc.nextInt();
		System.out.println("_____________________________________\n");
		sc.nextLine();
		
		String name,email,password,confirmPassword;
		int rollNo;
		
		switch(choice)
		{	
			case 1: 
				System.out.print("Enter Admin id = ");
				email=sc.nextLine();
				System.out.print("Enter a Admin password = ");
				password=sc.nextLine();
				ValidateLogin validateAdmin = new ValidateLogin();
				boolean flag1=validateAdmin.adminValidation(email,password);
				if(flag1==true) System.out.println("Successfully Logined as Admin");
				else System.out.println("Invalid Admin Credentials...Try again!\n");
				break;

			case 2:
				System.out.println("Enter Student Email id = ");
				email=sc.nextLine();
				System.out.println("Enter Student password = ");
				password=sc.nextLine();
				ValidateLogin validateUser = new ValidateLogin();
				boolean flag2=validateUser.studentValidation(email,password);
				if(flag2==true) System.out.println("Successfully Logined as Admin");
				else System.out.println("Invalid Student Credentials...Try again!\n");
				break;
			
			
			case 3: 
				System.out.println("Enter your Name = ");
				name=sc.nextLine();
				System.out.println("Enter your Email ID = ");
				email=sc.nextLine();
				System.out.println("Enter your Roll Number = ");
				rollNo=sc.nextInt();sc.nextLine();
				System.out.println("Enter a password = ");
				password=sc.nextLine();
				System.out.println("ReEnter the password = ");
				confirmPassword=sc.nextLine();
				User user2 = new User(name, email,password,rollNo);
				ValidateRegister validateRegistration=new ValidateRegister();
				Boolean flag3=validateRegistration.checkUserDetails(user2.getName(),user2.getRollNo(),user2.getEmail(),user2.getPassword(),confirmPassword);
				if(flag3==true)
				{
					StudentList.add(user2);
					System.out.println("Successfully Registered as "+user2.getName());
				}
				else System.out.println("Error in Registration...try again!\n");
				break;
			
			case 4: 
				System.out.println("________________________________________________");
				System.out.println(String.format("%20s : %20s","Student Roll Number","Student Name"));
				System.out.println("________________________________________________");
				for (User item:StudentList)
			        System.out.println(String.format("%20s : %20s",item.getRollNo(),item.getName()));
				System.out.println("________________________________________________");
				break;
			
			case 5:
				System.out.print("\nExiting from Exam Portal ...\n"); break;
				
			default: System.out.print("Please ReEnter valid choice!\n");		    
		}
		
	
	   }
		
		
	}	
		
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
	    	
	    	
			String pass1=password;
	    	String confirmpass=confirmpassword;
	        String regex = "^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"  + "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$"; 
	        Pattern p = Pattern.compile(regex); 
	        if (pass1.matches(confirmpass)==false) 
	        { 
	        	System.out.println("Password does not match");
	            return false; 
	        } 
	        else if(pass1==null)
	        {
	        	System.out.println("Password should not be null");
	            return false; 
	        }
	 
	        Matcher m = p.matcher(pass1); 
	        return m.matches(); 
	    }
	    

	    private boolean validEmail(String email) {
	    	String[] email1=email.split("@");	
		    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+  "[a-zA-Z0-9_+&*-]+)*@" +  "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$"; 
		                  
			Pattern pat = Pattern.compile(emailRegex); 
			if (email1 == null) 
			{
				System.out.println("EmailId should not be null");
				return false;
			}
			return pat.matcher(email).matches();
		    
	    }	
	    
	    private boolean validName(String name)
	    {
	    	String regexName = "\\p{Upper}(\\p{Lower}+\\s?)";
	        String patternName = "(" + regexName + "){2,3}";
	        if( name.matches(patternName) )
	          return true;
	        else
	          {
	        	System.out.println("Invalid Name");
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

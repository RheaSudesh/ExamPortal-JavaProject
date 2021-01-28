package Controller;
import java.util.*;
import Model.*;
import Validation.*;

public class Main {
	
	public static Map<String,HashMap> namelist1 = new HashMap<String,HashMap>();
	public static ArrayList<User> StudentList=new ArrayList<User>();
	public static HashMap<Questions, String> questions;
	static Scanner sc=new Scanner(System.in);
	public static void adminFunctionality()
	{	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of courses = ");		
		int noofcourses=sc.nextInt();
				
		for(int courseNo=0;courseNo<noofcourses;courseNo++) 
		{
			sc.nextLine();
			System.out.println("Enter course name=");
			String courseName = sc.nextLine();		
			QuestionBank AnswerKey=new QuestionBank();
			questions=(HashMap)AnswerKey.setQuestions();
			namelist1.put(courseName, questions);
		}
							
	}
	
	
	public static void studentFunctionality(User examinee)
	{
			int marks=0;
			
			System.out.println("_________________________________");
			System.out.println("These are the  courses");
			for(String CourseName :namelist1.keySet() ) 
			{
				System.out.println("->" +CourseName);
			}
			System.out.println("_________________________________");
			System.out.print("Enter name of the chossen course = ");
			String finalchoice= sc.nextLine() ;
			
			if(namelist1.containsKey(finalchoice))
			{
				QuestionBank objques = new QuestionBank();
				int QuestionNumber=0;
				objques.display(questions);	
				
				System.out.println("_________________________________");
				System.out.println("Answer Paper");
				System.out.println("Instructions \n1. Write the correct option in the prompt\n2. Do make sure you rewrite the option correctly ");
				
				for(Questions item : questions.keySet()) 
				{
					QuestionNumber+=1;
					System.out.println("Enter the answer for question "+QuestionNumber+" = ");
					String optionchoosen=sc.nextLine();
					if(questions.get(item).equals(optionchoosen)) 
					{
						objques.correctcount+=1;			
					}
				}
				System.out.println("Do you want to see your marks?  <yes/no> =");
				String option=sc.nextLine();
				if(option.equalsIgnoreCase("yes"))
					System.out.println("Score : "+objques.correctcount);
			}
			
			examinee.setGoldPoints(marks);
		 
	}
	
	
	public static void main(String args[])
	{
		
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
				if(flag1==true) 
				{
					System.out.println("Successfully Logined as Admin");
					System.out.println("_____________________________________\n");
					adminFunctionality();
				}
				else System.out.println("Please Try again\n");
				break;

			case 2:
				System.out.println("Enter Student Email id = ");
				email=sc.nextLine();
				System.out.println("Enter Student password = ");
				password=sc.nextLine();
				ValidateLogin validateUser = new ValidateLogin();
				boolean flag2=validateUser.studentValidation(email,password);
				if(flag2==true)
				{
					for (User item:StudentList)
					{
						if(item.getEmail()==email)
						{
							System.out.println("Successfully Logined as Admin");
							studentFunctionality(item);
						}
					}
				}
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
					studentFunctionality(user2);
				}
				else System.out.println("Error in Registration...try again!\n");
				break;
			
			case 4: 
				System.out.println(String.format("%20s : %20s : %20s","Student Roll Number","Student Name","Gold Points"));
				System.out.println("________________________________________________");
				for (User item:StudentList)
			        System.out.println(String.format("%20s : %20s : %20d",item.getRollNo(),item.getName(),item.getGoldPoints()));
				break;
			
			case 5:
				System.out.print("\nExiting from Exam Portal ...\n"); break;
				
			default: System.out.print("Please ReEnter valid choice!\n");		    
		}
		
	
	   }
	}

}

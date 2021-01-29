package Controller;
import java.util.*;
import Model.*;
import Validation.*;

public class Main {
	
	
	public static Map<String,HashMap> courseList = new HashMap<String,HashMap>(); //course , <Questions, string>
	public static ArrayList<User> StudentList=new ArrayList<User>();
	//public static HashMap<Questions, String> questions;
	public static int noofcourses=0;
	static Scanner sc=new Scanner(System.in);
	
	public static void adminFunctionality()
	{	
		int choice=1;
		while(choice!=8)
		{
			System.out.println("_____________________________________\n");
			System.out.println("ADMIN FUCNTIONALITIES \n");
			System.out.println("Menu:");
			System.out.println("1. Add a Course");
			System.out.println("2. Delete a Course");
			System.out.println("3. Rename a Course");
			System.out.println("4. Display Courses");
			System.out.println("5. Add Question in a Course");
			System.out.println("6. Delete Question in a Course");
			System.out.println("7. Modify Question in a Course");
			System.out.println("8. Exit as Admin");
			System.out.println("_____________________________________\n");
			System.out.println(" Enter a Choice = ");
			choice=sc.nextInt();
			System.out.println("_____________________________________\n");
			sc.nextLine();
			
			switch(choice)
			{
				case 1:
					System.out.println("Enter the number of courses = ");		
					noofcourses=sc.nextInt();
					sc.nextLine();
					for(int courseNo=0;courseNo<noofcourses;courseNo++) 
					{
						System.out.println("--------SetQuestions --------");
						
						System.out.println("Enter course name=");
						String courseName = sc.nextLine(); 
						HashMap<Questions, String> questions;
						QuestionBank AnswerKey=new QuestionBank();
						questions=(HashMap)AnswerKey.setQuestions();
						courseList.put(courseName, questions);
					}
					break;
					
				case 2:
					System.out.println("These are the Courses");
					for(String courseName:courseList.keySet())
					{
						System.out.println("->"+courseName);
					}
					System.out.print("\nEnter name of the Course to be deleted = ");
					String CourseNameToBeDeleted=sc.nextLine();
					courseList.remove(CourseNameToBeDeleted);
					System.out.println("Course Deleted Successfully");
					break;
					
				case 3:
					System.out.println("These are the Courses");
					for(String courseName:courseList.keySet())
					{
						System.out.println("->"+courseName);
					}
					System.out.print("\nEnter name of the Course to be renamed = ");
					String oldCourseName=sc.nextLine();
					System.out.print("\nEnter the new name of that Course= ");
					String newCourseName=sc.nextLine();
					courseList.put(newCourseName, courseList.get(oldCourseName));
					courseList.remove(oldCourseName);
					System.out.println("Course Renamed successfully");
					break;
					
					
				case 4:
					System.out.println("Print the Courses");
					for(String courseName:courseList.keySet())
					{
						System.out.println("->"+courseName);
					}
					break;
				
				case 5:
					System.out.println("Print the Courses");
					for(String courseName:courseList.keySet())
					{
						System.out.println("->"+courseName);
					}
					System.out.println("Enter which course = ");
					String courseNameToAdded=sc.nextLine();
					QuestionBank AnswerKey2=new QuestionBank();
					HashMap<Questions, String> questions=(HashMap)AnswerKey2.addQuestion(courseList.get(courseNameToAdded));
					courseList.put(courseNameToAdded, questions);
					break;
				
				case 6:
					System.out.println("Print the Courses");
					for(String courseName:courseList.keySet())
					{
						System.out.println("->"+courseName);
					}
					System.out.println("Enter which course = ");
					String courseNameToDelete=sc.nextLine();
					System.out.print("Enter question to be deleted = ");
					String ques = sc.nextLine();
					QuestionBank AnswerKey3=new QuestionBank();
					//questions=(HashMap)AnswerKey3.deleteQuestions(questions,ques);
					HashMap<Questions, String> questions2=(HashMap)AnswerKey3.deleteQuestions(courseList.get(courseNameToDelete),ques);
					courseList.put(courseNameToDelete, questions2);
					break;
				
				case 7:
					System.out.println("Print the Courses");
					for(String courseName:courseList.keySet())
					{
						System.out.println("->"+courseName);
					}
					System.out.println("Enter which course = ");
					String courseNameToModified=sc.nextLine();
					QuestionBank AnswerKey4=new QuestionBank();
					//questions=(HashMap)AnswerKey4.modifyQuestion(questions);
					HashMap<Questions, String> questions3=(HashMap)AnswerKey4.modifyQuestion(courseList.get(courseNameToModified));
					courseList.put(courseNameToModified, questions3);
					break;
					
				case 8: 
					System.out.println("Exiting as Admin...");
					break;
				
				default: System.out.println("Invalid choice! Try Again");break;
					
			
			}
		}
	
							
	}
	
	
	public static void studentFunctionality(User examinee)
	{
			int marks=0;
			
			System.out.println("These are the  courses");
			for(String CourseName :courseList.keySet() ) 
			{
				System.out.println("->" +CourseName);
			}
			System.out.println("_________________________________");
			System.out.print("Enter name of the chossen course = ");
			String finalchoice= sc.nextLine() ;
			System.out.println("_________________________________");
			System.out.println("Question Paper");

			
			if(courseList.containsKey(finalchoice))
			{
				QuestionBank objques = new QuestionBank();
				int QuestionNumber=0;
				objques.display(courseList.get(finalchoice));	
				
				System.out.println("__________________________________________");
				System.out.println("Instructions \n1. Write the correct option in the prompt\n2. Do make sure you rewrite the option correctly ");
				System.out.println("__________________________________________");
				System.out.println("Answer Paper");
				System.out.println("__________________________________________");

				HashMap<Questions,String> questions = new HashMap<>(courseList.get(finalchoice));   
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
				{	System.out.println("Score : "+objques.correctcount);
					marks=objques.correctcount;
				}
				
				
				
			}
			
			examinee.setGoldPoints(marks);
		 
	}
	
	
	public static void main(String args[])
	{
		
		int choice=1;
		while(choice!=5)
		{
		System.out.println("_____________________________________\n");
		System.out.println("ONLINE EXAMINATION PORTAL\n");
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
				//admin entry
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
					System.out.println("Welcome Admin\n");
					adminFunctionality();
				}
				else System.out.println("Please Try again\n");
				break;

			case 2:
				//login for user
				System.out.println("Enter Student Email id = ");
				email=sc.nextLine();
				System.out.println("Enter Student password = ");
				password=sc.nextLine();
				ValidateLogin validateUser = new ValidateLogin();
				boolean studentInList=false;
				for (User item:StudentList)
				{
					if(item.getEmail().equals(email) && item.getPassword().equals(password))
					{
						System.out.println("Successfully Logined as Admin");
						studentFunctionality(item);
						studentInList=true;
						break;
					}
				}
				
				if(studentInList==false)
					System.out.println("Invalid Student Credentials...Try again!\n");
				break;
			
			
			case 3: 
				//register for new candidates
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
					System.out.println("________________________________________________");
					System.out.println("Take Examination");
					studentFunctionality(user2);
				}
				else System.out.println("Error in Registration...try again!\n");
				break;
			
			case 4: 
				//printing results
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

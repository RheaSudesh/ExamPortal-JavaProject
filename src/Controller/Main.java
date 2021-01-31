package Controller;
import java.util.*;
import Model.*;
import Validation.*;

public class Main extends QuestionBank{
	
	public static ArrayList<Courses> courseList=new ArrayList<Courses>();
	public static ArrayList<User> StudentList=new ArrayList<User>();  
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
					//adding a course
					System.out.println("Enter the number of courses = ");		
					noofcourses=sc.nextInt();
					sc.nextLine();
					for(int courseNo=0;courseNo<noofcourses;courseNo++) 
					{
						System.out.println("-------- SetQuestions --------\n");
						
						System.out.println("Enter course ID =");
						String courseID=sc.nextLine();
						System.out.println("Enter course name =");
						String courseName = sc.nextLine(); 
						System.out.println("Enter number of questions in this course");
						int noOfQuestions= sc.nextInt();sc.nextLine();
						
						HashMap<Questions, String> questions;
						QuestionBank AnswerKey=new QuestionBank();
						questions=(HashMap)AnswerKey.setQuestions(noOfQuestions);
						
						Courses coursesObj=new Courses(courseID,courseName,noOfQuestions,questions);
						courseList.add(coursesObj);
					}
					break;
					
				case 2:
					//deleting a course
					System.out.println("These are the Courses");
					for(Courses obj : courseList)
					{
						System.out.println(obj.getCourseName());
					}
					System.out.print("\nEnter name of the Course to be deleted = ");
					String CourseNameToBeDeleted=sc.nextLine();
					
					for(Courses courseObj : courseList)
					{
						if(courseObj.getCourseName().equalsIgnoreCase(CourseNameToBeDeleted))
						{
							courseList.remove(courseObj);
						}
					}
					System.out.println("Course Deleted Successfully");
					break;
					
				case 3:
					//renaming a course
					System.out.println("These are the Courses");
					for(Courses courseObj : courseList)
					{
						System.out.println(courseObj.getCourseName());
					}
					System.out.print("\nEnter name of the Course to be renamed = ");
					String oldCourseName=sc.nextLine();
					System.out.print("\nEnter the new name of that Course= ");
					String newCourseName=sc.nextLine();
					for(Courses courseObj : courseList)
					{
						if(courseObj.getCourseName().equalsIgnoreCase(oldCourseName))
						{
							courseObj.setCourseName(newCourseName);
						}
					}
					System.out.println("Course Renamed successfully");
					break;
					
					
				case 4:
					//displaying a course
					System.out.println("Print the Courses");
					for(Courses course : courseList)
					{
						System.out.println(course.getCourseName());
					}
					break;
				
				case 5:
					//adding a question to the course
					System.out.println("Print the Courses");
					for(Courses course : courseList)
					{
						System.out.println(course.getCourseName());
					}
					System.out.println("Enter which course = ");
					String courseNameToAdded=sc.nextLine();
					QuestionBank AnswerKey2=new QuestionBank();
					for(Courses courseObj : courseList)
					{
						if(courseNameToAdded.equalsIgnoreCase(courseObj.getCourseName()))
						{
							HashMap<Questions,String> oldCourseQuestionBank=courseObj.getCourseQuestionBank();
							HashMap<Questions, String> newCourseQuestionBank=(HashMap)AnswerKey2.addQuestion(oldCourseQuestionBank);
							courseObj.setCourseQuestionBank( newCourseQuestionBank);
							courseObj.setNoOfQuestions(courseObj.getNoOfQuestions()+1);
						}
					}
					break;
				
				case 6:
					//deleting a question in the course
					System.out.println("Print the Courses");
					for(Courses course : courseList)
					{
						System.out.println(course.getCourseName());
					}
					System.out.println("Enter which course = ");
					String courseNameToDelete=sc.nextLine();
					System.out.print("Enter question to be deleted = ");
					String ques = sc.nextLine();
					
					QuestionBank AnswerKey3=new QuestionBank();					
					for(Courses courseObj : courseList)
					{
						if(courseNameToDelete.equalsIgnoreCase(courseObj.getCourseName()))
						{
							HashMap<Questions,String> oldCourseQuestionBank=courseObj.getCourseQuestionBank();
							HashMap<Questions, String> newCourseQuestionBank=(HashMap)AnswerKey3.deleteQuestions(oldCourseQuestionBank,ques);
							courseObj.setCourseQuestionBank( newCourseQuestionBank);
							courseObj.setNoOfQuestions(courseObj.getNoOfQuestions()-1);

						}
					}
					break;
				
				case 7:
					//modifying a question in the course
					System.out.println("Print the Courses");
					for(Courses course : courseList)
					{
						System.out.println(course.getCourseName());
					}
					System.out.println("Enter which course = ");
					String courseNameToModified=sc.nextLine();
					QuestionBank AnswerKey4=new QuestionBank();
					for(Courses courseObj : courseList)
					{
						if(courseNameToModified.equalsIgnoreCase(courseObj.getCourseName()))
						{
							HashMap<Questions,String> oldCourseQuestionBank=courseObj.getCourseQuestionBank();
							HashMap<Questions, String> newCourseQuestionBank=(HashMap)AnswerKey4.modifyQuestion(oldCourseQuestionBank);
							courseObj.setCourseQuestionBank( newCourseQuestionBank);
						}
					}
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
			for(Courses course : courseList)
			{
				System.out.println(course.getCourseName());
			}
			System.out.println("_________________________________");
			System.out.print("Enter name of the chossen course = ");
			String finalchoice= sc.nextLine() ;
			System.out.println("_________________________________");
			System.out.println("Question Paper");

			
			for(Courses objCourses : courseList)
			{
				if(objCourses.getCourseName().equalsIgnoreCase(finalchoice))
				{
					QuestionBank objques = new QuestionBank();
					int QuestionNumber=0;
					objques.display(objCourses.getCourseQuestionBank());	
					
					System.out.println("__________________________________________");
					System.out.println("Instructions \n1. Write the correct option in the prompt\n2. Do make sure you rewrite the option correctly ");
					System.out.println("__________________________________________");
					System.out.println("Answer Paper");
					System.out.println("__________________________________________");
	
					HashMap<Questions,String> questionBank = new HashMap<>(objCourses.getCourseQuestionBank());   
					for(Questions question : questionBank.keySet()) 
					{
						QuestionNumber+=1;
						System.out.println("Enter the answer for question "+QuestionNumber+" = ");
						String optionchoosen=sc.nextLine();
						if(questionBank.get(question).equals(optionchoosen)) 
						{
							marks+=1;			
						}
					}
					System.out.println("Do you want to see your marks?  <yes/no> =");
					String option=sc.nextLine();
					if(option.equalsIgnoreCase("yes"))
					{	System.out.println("Score : "+marks);
				
					}
				
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
				//login as an old candidate
				System.out.println("Enter Student Email id = ");
				email=sc.nextLine();
				System.out.println("Enter Student password = ");
				password=sc.nextLine();
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
				//register as a new candidate
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
				System.out.println("_______________________________________________________________________________");
				System.out.println(String.format("%20s : %20s : %20s","Student Roll Number","Student Name","Gold Points"));
				System.out.println("_______________________________________________________________________________");
				for (User item:StudentList)
			        System.out.println(String.format("%20s : %20s : %20d",item.getRollNo(),item.getName(),item.getGoldPoints()));
				System.out.println("_______________________________________________________________________________");
				break;
			
			case 5:
				System.out.print("\nExiting from Exam Portal ...\n"); break;
				
			default: System.out.print("Please ReEnter valid choice!\n");		    
		}
		
	
	   }
	}

}

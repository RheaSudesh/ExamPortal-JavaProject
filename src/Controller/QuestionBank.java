package Controller;
import java.util.*;
import Model.*;


public class QuestionBank implements CourseOrganizer
{

	Scanner sc = new Scanner(System.in);
	
	@Override
	public Map<Questions, String> setQuestions(int noOfQues) {
		// TODO Auto-generated method stub	
		Map<Questions,String> mapques = new HashMap<Questions,String>();
		mapques.clear();
		
		while(noOfQues!=0)
		{
			noOfQues-=1;
			System.out.println("Enter a Question = ");	
			String question = sc.nextLine();
			System.out.println("Enter option 1 =");
			String op1=sc.nextLine();
			System.out.println("Enter option 2 =");
			String op2=sc.nextLine();
			System.out.println("Enter option 3 =");
			String op3=sc.nextLine();
			System.out.println("Enter option 4 =");
			String op4=sc.nextLine();
			System.out.println("Enter the correct answer =");
			String correctOption=sc.nextLine();
			
			Questions obj = new Questions(question, op1, op2, op3, op4);
		    mapques.put(obj, correctOption);
		}
		return mapques;
	}
	

	@Override
	public Map<Questions, String> deleteQuestions(Map<Questions, String> questions,String ques) {
		// TODO Auto-generated method stub	
		int questionNotFound = 0;
		for(Questions item : questions.keySet()) {
			if(item.getQuestion().equals(ques)) 
			{
				questions.remove(item);
				System.out.println("Successfully deleted");
				questionNotFound = 1;
				break;
				
			}
		}
		if(questionNotFound == 0)
			System.out.println("Question not found");
	
		return questions;
	}

	@Override
	public Map<Questions, String> addQuestion(Map<Questions, String> questions) {
		// TODO Auto-generated method stub	
		System.out.println("Enter a Question = ");	
		String question = sc.nextLine();
		System.out.println("Enter option 1 =");
		String op1=sc.nextLine();
		System.out.println("Enter option 2 =");
		String op2=sc.nextLine();
		System.out.println("Enter option 3 =");
		String op3=sc.nextLine();
		System.out.println("Enter option 4 =");
		String op4=sc.nextLine();
		System.out.println("Enter the correct answer =");
		String correctOption=sc.nextLine();
		Questions obj = new Questions(question, op1, op2, op3, op4);
	    questions.put(obj, correctOption);
	    
	    return questions;
		
	}

	@Override
	public Map<Questions, String> modifyQuestion(Map<Questions, String> questions) {
		// TODO Auto-generated method stub	
		System.out.println("Enter the question to be modified =");
		String oldques = sc.nextLine();
		boolean flag = false;
		for(Questions item : questions.keySet()) 
		{
			if( item.getQuestion().equals(oldques)) 
				{
					flag=true;
					questions.remove(item);
					break;
				}
		}
	
		if(flag==true)
		{
			
			System.out.println("Enter a new Question = ");	
			String newQues = sc.nextLine();
			System.out.println("Enter option 1 =");
			String newop1=sc.nextLine();
			System.out.println("Enter option 2 =");
			String newop2=sc.nextLine();
			System.out.println("Enter option 3 =");
			String newop3=sc.nextLine();
			System.out.println("Enter option 4 =");
			String newop4=sc.nextLine();
			System.out.println("Enter the correct answer =");
			String correctOption= sc.nextLine();
			Questions obj;

			obj = new Questions(newQues, newop1, newop2, newop3, newop4);
			questions.put(obj, correctOption);	
			System.out.println("Successfully added Question");				
		}
		else
			System.out.println("No such Questions exists");
			
		return questions;	
			
		
	}
	
	@Override
	public void display(Map<Questions, String> questions) {
		// TODO Auto-generated method stub
		for(Questions item : questions.keySet()) {
			
			System.out.println("Q) "+item.getQuestion());
			System.out.println("-> "+item.getOption1());
			System.out.println("-> "+item.getOption2());
			System.out.println("-> "+item.getOption3());
			System.out.println("-> "+item.getOption4());
			System.out.println("");
			
		}
	}
	
}
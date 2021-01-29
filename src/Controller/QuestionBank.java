package Controller;
import java.util.*;
import Model.*;


public class QuestionBank 
{

	public Map<Questions,String> map = new HashMap<Questions,String>();
	public int correctcount=0;	
	int noOfQues;
	Scanner sc = new Scanner(System.in);
	
	public int getNoOfQues() {
		return noOfQues;
	}
	
	public void setNoOfQues(int noOfQues) {
		this.noOfQues = noOfQues;
	}
	
	
	
	public Map<Questions, String> setQuestions() {
		Map<Questions,String> mapques = new HashMap<Questions,String>();
		mapques.clear();
		System.out.println("Enter number of questions in this course");
		noOfQues= sc.nextInt();sc.nextLine();
		
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
	
	
	
	public Map<Questions, String> deleteQuestions(Map<Questions, String> questions,String ques) {
		
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

	
	public Map<Questions, String> addQuestion(Map<Questions, String> questions) {
		
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

	
	public Map<Questions, String> modifyQuestion(Map<Questions, String> questions) {
		
		System.out.println("Enter the question to be modified =");
		String oldques = sc.nextLine();
		boolean flag = false;
		for(Questions item : questions.keySet()) 
		{
		if( item.getQuestion().equals(oldques)) 
			{
				flag=true;
				questions.remove(item);
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
	
		
	public void display(Map<Questions, String> questions) {
	
		for(Questions item : questions.keySet()) {
			
			System.out.println(item.getQuestion());
			System.out.println(item.getOp1());
			System.out.println(item.getOp2());
			System.out.println(item.getOp3());
			System.out.println(item.getOp4());
			
			/*String optionchoosen = sc.nextLine();
			if(questions.get(item).equals(optionchoosen)) {
				correctcount+=1;
			}*/
		}
	}
	
	
	
}
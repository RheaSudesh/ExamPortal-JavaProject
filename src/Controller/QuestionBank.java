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
		System.out.println("enter no of ques");
	Scanner sc = new Scanner(System.in);
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
		//baby pick the call..i want to see u too
		Questions obj = new Questions(question, op1, op2, op3, op4);
	    mapques.put(obj, correctOption);
		}
		return mapques;
	}
	
	
	
	public void deleteQuestions(Map<Questions, String> questions) {
		System.out.print("Enter question to be deleted");
		String ques = sc.nextLine();
		for(Questions item : questions.keySet()) {
			if(item.getQuestion().equals(ques)) {
				questions.remove(item);
				System.out.println("Successfully deleted");
			}else
				System.out.println("Question not found");
		
		}	
	}

	
	public void addQeus() {
		
		System.out.println("here");
		String ques = sc.nextLine();
		String op1 = sc.nextLine();
		String op2 = sc.nextLine();
		String op3 = sc.nextLine();
		String op4 = sc.nextLine();
		String correctOption=sc.nextLine();
		Questions obj = new Questions(ques, op1, op2, op3, op4);
	    map.put(obj, correctOption);
		
	}

	
	public void updateques(Map<Questions, String> questions) {
		
		String oldques = sc.nextLine();
		boolean flag = false;
		for(Questions item : questions.keySet()) {
			if(item.getQuestion().equals(oldques)) 
			{
				flag=true;
			}
		
		}
		if(flag==false)
			System.out.println("No such Questions exists");
		else {
			
			System.out.println("Enter a Question = ");	
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
			String correctOption=sc.nextLine();
			for(Questions item : questions.keySet()) 
			{
				if(item.getQuestion().equals(oldques)) 
				{
					Questions obj = new Questions(newQues, newop1, newop2, newop3, newop4);
					map.put(obj, correctOption);			
				}
			}
			System.out.println("Successfully added Question");	
		}
			
			
			
		
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
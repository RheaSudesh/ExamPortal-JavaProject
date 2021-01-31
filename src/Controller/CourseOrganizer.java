package Controller;

import java.util.Map;
import Model.Questions;

public interface CourseOrganizer{
	
	 public Map<Questions, String> setQuestions(int noOfQuestions);
	 public Map<Questions, String> deleteQuestions(Map<Questions, String> questions,String ques);
	 public Map<Questions, String> addQuestion(Map<Questions, String> questions);
	 public Map<Questions, String> modifyQuestion(Map<Questions, String> questions);
	 void display(Map<Questions, String> ques);

}

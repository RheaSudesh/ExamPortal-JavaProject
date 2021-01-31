package Testing;
import static org.junit.Assert.*;
import org.junit.Test;

import Model.Questions;

public class QuestionsTest {
	
	Questions question = new Questions("What is Java","option 1","option 2","option 3","option 4");
	
	 @Test
	 public void testSetterGetter() {
		 question.setQuestion("What is Java");
		 question.setOption1("option 1");
		 question.setOption2("option 2");
		 question.setOption3("option 3");
		 question.setOption4("option 4");

		 assertEquals("What is Java",question.getQuestion());
		 assertEquals("option 1",question.getOption1());
		 assertEquals("option 2",question.getOption2());
		 assertEquals("option 3",question.getOption3());
		 assertEquals("option 4",question.getOption4());
		 
		 try {
			 question.setQuestion(null);
			 question.setOption1(null);
			 question.setOption2(null);
			 question.setOption3(null);
			 question.setOption4(null);
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }

}

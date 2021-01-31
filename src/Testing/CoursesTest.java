package Testing;
import static org.junit.Assert.*;

import java.util.HashMap;
import org.junit.Test;
import Model.*;

import Model.Courses;

public class CoursesTest {

	HashMap<Questions,String> questionBank=new HashMap<Questions,String>();
	Courses course = new Courses("CS17","Java",2,questionBank);
	
	
	 @Test
	 public void testSetterGetter() {
		 course.setCourseId("CS17");
		 course.setCourseName("java");
		 
		 assertEquals("CS17",course.getCourseId());
		 assertEquals("java",course.getCourseName());
		 assertEquals(questionBank,course.getCourseQuestionBank());

		 
		 try {
			 course.setCourseId(null);
			 course.setCourseName(null);
			 course.setNoOfQuestions(0);
			 course.setCourseQuestionBank(null);
			 
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
	 }

}


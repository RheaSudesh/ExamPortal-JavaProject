package Model;

import java.util.HashMap;

public class Courses {
	
	String courseId;
	String courseName;
	int noOfQuestions;
	HashMap<Questions,String> courseQuestionBank;
	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getNoOfQuestions() {
		return noOfQuestions;
	}
	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}
	public HashMap<Questions, String> getCourseQuestionBank() {
		return courseQuestionBank;
	}
	public void setCourseQuestionBank(HashMap<Questions, String> map) {
		this.courseQuestionBank = map;
	}
	public Courses(String courseId, String courseName, int noOfQuestions, HashMap<Questions, String> courseQuestionBank) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.noOfQuestions = noOfQuestions;
		this.courseQuestionBank = courseQuestionBank;
	}
	
	
	

}

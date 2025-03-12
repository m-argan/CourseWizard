package schedulingWizard;

import java.util.ArrayList;

public class Course
{
	String courseName; // ex. Software Design
	String courseCode; // ex. CSC 360
	ArrayList<String> genEdTags; // ex. D3
	String room; // ex. 201
	String term; // ex. Spr2025
	String professor; // ex. Dr. Bradshaw
	String departmentName; // ex. Computer Science
	//ArrayList<CourseConstraint> courseConstraints;
	int actualCapacity; // ex. 10
	int falseCapacity; // ex. 5
	String startTime; // ex. 8:00AM
	String endTime; // ex. 9:00AM
	
	
	public Course(String courseName, String courseCode, ArrayList<String> genEdTags,
			String room, String term, String professor, String deptName, String startTime,
			String endTime, int actualCapacity)
	{
		this.courseName = courseName;
		this.courseCode = courseCode;
		this.genEdTags = genEdTags;
		this.room = room;
		this.term = term;
		this.professor = professor;
		this.departmentName = deptName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.actualCapacity = actualCapacity;
		// TODO Auto-generated constructor stub
		
	}
	
	
	public String getCourseName()
	{
		return courseName;
	}
	public String getCourseCode()
	{
		return courseCode;
	}
	public ArrayList<String> getGenEdTags()
	{
		return genEdTags;
	}
	public String getRoom()
	{
		return room;
	}
	public String getTerm()
	{
		return term;
	}
	public String getProfessor()
	{
		return professor;
	}
	public String getDeptName()
	{
		return departmentName;
	}
	public String getStartTime()
	{
		return startTime;
	}
	public String getEndTime()
	{
		return endTime;
	}
	public int getActualCapacity()
	{
		return actualCapacity;
	}
	public int getFalseCapacity()
	{
		return falseCapacity;
	}

}

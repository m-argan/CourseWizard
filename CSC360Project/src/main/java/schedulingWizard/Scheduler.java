package schedulingWizard;

import java.util.ArrayList;

public class Scheduler
{
	ArrayList<Course> schedule;
	boolean isComplete = false;
	String schedulerName;
	String schedulerDept;
	History history = new History();
	ArrayList<CourseConstraint> courseConstraints = new ArrayList<CourseConstraint>();
	
	public Scheduler(String name, String department)
	{
		this.schedulerName = name;
		schedulerDept = department;
	}
	
	public Course addNewCourse(String courseName, String courseCode, ArrayList<String> genEdTags,
			String room, String term, String professor, String deptName, String startTime,
			String endTime, int actualCapacity)
	{
		Course newCourse = null;
		if(schedulerDept.equals(deptName)||schedulerDept.equals("Registrars Office"))//checks that the dept head is editing for correct dept (or is registrar)
		{
			newCourse = new Course(courseName,courseCode,genEdTags,room,term,professor,deptName,startTime,
					endTime,actualCapacity);
			
			ArrayList<Course> scheduleForDept = history.getScheduleForDept(deptName);
			scheduleForDept.add(newCourse);
			//add course to term schedule
		}
		return newCourse;
		
	}
	
	public Course addExistingCourse(String term, String dept, String courseCode)
	{
		Course courseToBeAdded = history.getPastCourse(term, dept, courseCode);
		ArrayList<Course> deptSchedule = history.getScheduleForDept(dept);
		deptSchedule.add(courseToBeAdded);
		return courseToBeAdded;
	}
	//returns list of courseconstraints that have not been met
	public ArrayList<CourseConstraint> checkCourseConstraints()
	{
		ArrayList<CourseConstraint> haveNotBeenMet = new ArrayList<CourseConstraint>();
		for(CourseConstraint constraint : courseConstraints)
		{
			boolean hasBeenMet = constraint.checkConstraint();
			if(hasBeenMet == false)
			{
				haveNotBeenMet.add(constraint);
			}
		}
		return haveNotBeenMet;
	}
	
	public void alterCourseName(Course course, String newName)
	{
		course.courseName = newName;
	}
	
	public void alterCourseCode(Course course, String newCode)
	{
		course.courseCode = newCode;
	}
	
	public void alterGenEdTags(Course course, ArrayList<String> newGenEdTags)
	{
		course.genEdTags = newGenEdTags;
	}
	
	public void alterRoom(Course course, String newRoom)
	{
		course.room = newRoom;
	}
	
	public void alterTerm(Course course, String newTerm)
	{
		course.term = newTerm;
	}
	
	public void alterProf(Course course, String newProf)
	{
		course.professor = newProf;
	}
	
	public void alterDept(Course course, String newDept)
	{
		course.departmentName = newDept;
	}
	
	public void alterStartTime(Course course, String newStartTime)
	{
		course.startTime = newStartTime;
	}
	
	public void alterEndTime(Course course, String newEndTime)
	{
		course.endTime = newEndTime;
	}
	
	public void alterCapacity(Course course, int newCapacity)
	{
		course.actualCapacity = newCapacity;
	}
	
	public void setNewFalseCapacity(Course course, int newFalseCapacity)
	{
		course.falseCapacity = newFalseCapacity;
	}
	
	public void removeCourse(String dept, String courseCode)
	{
		ArrayList<Course> deptSchedule = history.getScheduleForDept(dept);
		Course courseToBeRemoved = null;
		for (Course course : deptSchedule)
		{
			if(course.getCourseCode().equals(courseCode))
			{
				courseToBeRemoved = course;
			}
		}
		if(courseToBeRemoved != null)
		{
			deptSchedule.remove(courseToBeRemoved);
		}
		else
			{
				throw new NullPointerException("Class does not exist");
			}
	}
	
	public CourseConstraint addNewCourseConstraints(String name, String type, ArrayList<Course> coursesInvolved, String term)
	{
		if(type.equals("MustBeOffered"))
		{
			CourseConstraint newMustBeOffered = new MustBeOffered(name, type, coursesInvolved, term);
			courseConstraints.add(newMustBeOffered);
			return newMustBeOffered;
		}
		if(type.equals("MustOverlap"))
		{
			CourseConstraint newMustOverlap = new MustOverlap(name, type, coursesInvolved);
			courseConstraints.add(newMustOverlap);
			return newMustOverlap;
		}
		if(type.equals("MustNotOverlap"))
		{
			CourseConstraint newMustNotOverlap = new MustNotOverlap(name, type, coursesInvolved);
			courseConstraints.add(newMustNotOverlap);
			return newMustNotOverlap;
		}
		else throw new IllegalArgumentException("Course constraint type does not exist yet!");
	}

	public void finalize()
	{
		isComplete = true;
	}
}

package schedulingWizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scheduler
{
	ArrayList<Course> schedule;
	//boolean isComplete = false;
	String schedulerName;
	String schedulerDept;
	History history = new History();
	ArrayList<CourseConstraint> courseConstraints = new ArrayList<CourseConstraint>();
	
	public Scheduler(String name, String department)
	{
		this.schedulerName = name;
		schedulerDept = department;
	}
	
	public boolean checkFinal(String dept)
	{
		//boolean isFinal = false;
		ArrayList<String> finalizedDepts = History.listOfFinalizedDepts;
		for(String finalDept : finalizedDepts)
		{
			if(finalDept.equals(dept))
			{
				//this department has been finalized
				return true;
			}
		}
		return false;
	}
	public Course addNewCourse(String courseName, String courseCode, ArrayList<String> genEdTags,
			String room, String term, String professor, String deptName, String startTime,
			String endTime, int actualCapacity)
	{
		Course newCourse = null;
		boolean isFinal = checkFinal(deptName);
		if(isFinal == false)
		{
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
		else throw new IllegalArgumentException("This department schedule has been finalized");
	}
	
	public Course addExistingCourse(String term, String dept, String courseCode)
	{
		boolean isFinal = checkFinal(dept);
		if(isFinal == false)
		{
			Course courseToBeAdded = history.getPastCourse(term, dept, courseCode);
			ArrayList<Course> deptSchedule = history.getScheduleForDept(dept);
			deptSchedule.add(courseToBeAdded);
			return courseToBeAdded;
		}
		else throw new IllegalArgumentException("This department schedule has been finalized");

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
		if(newFalseCapacity <= course.actualCapacity)
		{
			course.falseCapacity = newFalseCapacity;
		}
		else throw new IllegalArgumentException("Cannot set a false capacity that is greater than the actual capacity");
	}
	
	public void removeCourse(String dept, String courseCode)
	{
		ArrayList<Course> deptSchedule = history.getScheduleForDept(dept);
		Course courseToBeRemoved = null;
		boolean isFinal = checkFinal(dept);
		if(isFinal == false)
		{
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
		else throw new IllegalArgumentException("This department schedule has been finalized");
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

	public Map<Course,Course> checkRoomConflicts(ArrayList<Course> deptSchedule)
	{
		Map<Course, Course> roomConflict = new HashMap<Course, Course>();
		for (int i = 0; i < deptSchedule.size(); i++) {
			  for (int j = i+1; j < deptSchedule.size(); j++) {
			    if((deptSchedule.get(i).room).equals(deptSchedule.get(j).room))
			    {
			    	roomConflict.put(deptSchedule.get(i), deptSchedule.get(j));
			    	//System.out.println("adding: " + deptSchedule.get(i).getCourseCode() + " and " + deptSchedule.get(j).getCourseCode());
			    }
			  }
			}
		return roomConflict;
	}
	
	public Map<Course,Course> checkTimeConflicts(ArrayList<Course> deptSchedule)
	{
		Map<Course, Course> timeConflict = new HashMap<Course, Course>();
		for (int i = 0; i < deptSchedule.size(); i++) {
			  for (int j = i+1; j < deptSchedule.size(); j++) {
			    if((deptSchedule.get(i).startTime).equals(deptSchedule.get(j).startTime))
			    {
			    	timeConflict.put(deptSchedule.get(i), deptSchedule.get(j));
			    	//System.out.println("adding: " + deptSchedule.get(i).getCourseCode() + " and " + deptSchedule.get(j).getCourseCode());
			    }
			  }
			}
		return timeConflict;
	}
	
	public void finalize(String dept)
	{
		boolean noConflicts = true;
		ArrayList<Course> deptSchedule = history.getScheduleForDept(dept);
		Map<Course,Course> roomConflicts = checkRoomConflicts(deptSchedule);
		Map<Course,Course> timeConflicts = checkTimeConflicts(deptSchedule);
		//System.out.println(roomConflicts + "hi" + timeConflicts);
		if(!roomConflicts.isEmpty()||!timeConflicts.isEmpty())
		{
			//System.out.println("made it here");
			noConflicts = false;
		}
		
		if(noConflicts == true)
		{
			if(schedulerDept.equals(dept)||schedulerDept.equals("Registrars Office"))
			{
				
				ArrayList<String> alreadyFinalizedSchedules  = History.listOfFinalizedDepts;
				for(String currDept : alreadyFinalizedSchedules)
				{
					if(currDept.equals(dept))
					{
						//currentDeptisalreadyfinalized
						throw new IllegalArgumentException("Schedule has already been finalized");
					}
				}
				History.listOfFinalizedDepts.add(dept);
			}
			else throw new IllegalArgumentException("You are not authorized to finalize a schedule for another department");
		}
		else throw new IllegalArgumentException("There are some conflicts that need to be resolved before finalizing the schedule");
	}
}

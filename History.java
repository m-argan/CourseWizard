package schedulingWizard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class History
{
	static ArrayList<String> listOfFinalizedDepts = new ArrayList<String>();
	static ArrayList<String> departments;
	static ArrayList<String> rooms;
	static ArrayList<String> professors;
	static ArrayList<String> typesOfConstraints;
	static ArrayList<String> genEdTags;
	static ArrayList<String> allDeptHeads;
	static ArrayList<String> priorTerms;
	static Map<String, String> deptHeads = new HashMap<String, String>();//dept, name of head
	static Map<String, ArrayList<Course>> MasterScheduleForTerm = new HashMap<String, ArrayList<Course>>(); //fill this up Map<Department,list of courses>
	static Map<String, Map<String, ArrayList<Course>>> MegaMasterSchedule = new HashMap<String, Map<String, ArrayList<Course>>>();

	
	//ArrayList<String> CSC360GenEdTags;
	//ArrayList<Course> CSCTermSchedule = new ArrayList<Course>();
	
	public History()
	{
		
	}
	/**
	 * @return the rooms
	 */
	public static ArrayList<String> getRooms()
	{
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public static void setRooms(ArrayList<String> rooms)
	{
		History.rooms = rooms;
	}

	/**
	 * @return the professors
	 */
	public static ArrayList<String> getProfessors()
	{
		return professors;
	}

	/**
	 * @param professors the professors to set
	 */
	public static void setProfessors(ArrayList<String> professors)
	{
		History.professors = professors;
	}

	/**
	 * @return the typesOfConstraints
	 */
	public static ArrayList<String> getTypesOfConstraints()
	{
		return typesOfConstraints;
	}

	/**
	 * @param typesOfConstraints the typesOfConstraints to set
	 */
	public static void setTypesOfConstraints(ArrayList<String> typesOfConstraints)
	{
		History.typesOfConstraints = typesOfConstraints;
	}

	/**
	 * @return the genEdTags
	 */
	public static ArrayList<String> getGenEdTags()
	{
		return genEdTags;
	}

	/**
	 * @param genEdTags the genEdTags to set
	 */
	public static void setGenEdTags(ArrayList<String> genEdTags)
	{
		History.genEdTags = genEdTags;
	}

	/**
	 * @return the allDeptHeads
	 */
	public static ArrayList<String> getAllDeptHeads()
	{
		return allDeptHeads;
	}

	public static ArrayList<String> getDepartments()
	{
		return departments;
	}

	public static void setDepartments(ArrayList<String> departments)
	{
		History.departments = departments;
	}
	/**
	 * @param allDeptHeads the allDeptHeads to set
	 */
	public static void setAllDeptHeads(ArrayList<String> allDeptHeads)
	{
		History.allDeptHeads = allDeptHeads;
	}
	
	public void addToMegaMasterSchedule(String term, Map<String, ArrayList<Course>> masterScheduleForTerm)
	{
		MegaMasterSchedule.put(term, masterScheduleForTerm);
	}

	public ArrayList<Course> getCoursesForDept(String term, String dept)
	{
		for(String currTerm : MegaMasterSchedule.keySet())
		{
			if(currTerm.equals(term))
			{
				Map<String, ArrayList<Course>> theTerm = MegaMasterSchedule.get(currTerm);
				for(String currDept : theTerm.keySet())
				{
					if(currDept.equals(dept))
					{
						return theTerm.get(currDept);
					}
				}
			}
		}
		throw new NullPointerException("Course does not exist");
	}
	
	public void addToDeptHeads(String dept, String nameOfHead)
	{
		deptHeads.put(dept, nameOfHead);
	}
	
	public void addToMasterSchedule(String dept, ArrayList<Course> deptSchedule)
	{
		MasterScheduleForTerm.put(dept, deptSchedule);
	}
	
	public ArrayList<Course> getScheduleForDept(String dept)
	{
		ArrayList<Course> ListForDept = null;
		for(String currDept : MasterScheduleForTerm.keySet())
		{
			if(currDept.equals(dept))
			{
				ListForDept = MasterScheduleForTerm.get(currDept);
				
			}
		}
		return ListForDept;
		
	}
	
	public Course getPastCourse(String term, String dept, String courseCode)
	{
		ArrayList<Course> courseListForDept = getCoursesForDept(term,dept);
		for(Course course : courseListForDept)
		{
			if((course.courseCode).equals(courseCode))
			{
				String newCourseName = course.getCourseName();
				String newCourseCode = course.getCourseCode();
				ArrayList<String> newCourseGenEdTags = course.getGenEdTags();
				String newCourseRoom = course.getRoom();
				String newCourseTerm = course.getTerm();
				String newCourseProf = course.getProfessor();
				String newCourseDept = course.getDeptName();
				String newCourseStartTime = course.getStartTime();
				String newCourseEndTime = course.getEndTime();
				int newCourseCapacity = course.getActualCapacity();
				
				Course newCourse = new Course(newCourseName,newCourseCode,newCourseGenEdTags,newCourseRoom
						,newCourseTerm,newCourseProf,newCourseDept,newCourseStartTime,newCourseEndTime,newCourseCapacity);
				return newCourse;
			}
		}
		throw new NullPointerException("Course does not exist");
	}
	

}

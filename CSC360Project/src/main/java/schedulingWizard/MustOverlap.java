package schedulingWizard;

import java.util.ArrayList;

public class MustOverlap implements CourseConstraint
{
	String name;
	String type;
	ArrayList<Course> coursesInvolved;
	//ArrayList<Course> coursesInvolvedCopy;
	public boolean hasBeenMet;

	public MustOverlap(String name, String type, ArrayList<Course> coursesInvolved)
	{
		this.type = type;
		this.name = name;
		this.coursesInvolved = coursesInvolved;
		
	}

	public String getType()
	{
		return type;
	}
	public String getName()
	{
		return name;
	}
	public ArrayList<Course> getCoursesInvolved()
	{
		return coursesInvolved;
	}
	
	@Override
	public Boolean checkConstraint()
	{

		hasBeenMet = true;
		ArrayList<Course> coursesInvolvedCopy = coursesInvolved;
		boolean hello = check(coursesInvolvedCopy);
		//System.out.println("returning..." + hello);
		return hello;
	}
	
	
	private Boolean check(ArrayList<Course> courseList)
	{
		boolean hasBeenMet = true;
		for(Course course:this.coursesInvolved)
		{
			for(Course course1:this.coursesInvolved)
			{
				if(!course.getStartTime().equals(course1.getStartTime()))
				{
					hasBeenMet = false;
					//System.out.println(course.getCourseName() + " and " + course1.getCourseName() + 
					//		" do not meet the course constraint of type" + getType());
					//break;
				}
			}
		}
		return hasBeenMet;
	}
		
}

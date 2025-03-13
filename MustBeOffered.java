package schedulingWizard;

import java.util.ArrayList;

public class MustBeOffered implements CourseConstraint
{
	String name;
	String type;
	ArrayList<Course> coursesInvolved;
	String term;
	
	public MustBeOffered(String name, String type, ArrayList<Course> coursesInvolved, String term)
	{
		this.type = type;
		this.name = name;
		this.coursesInvolved = coursesInvolved;
		this.term = term;
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
	public String getTerm()
	{
		return term;
	}
	@Override
	public Boolean checkConstraint()
	{
		boolean hasBeenMet = true;
		for(Course course: coursesInvolved)
		{
			if(!course.getTerm().equals(term))
			{
				hasBeenMet = false;
			}
		}
		return hasBeenMet;
	}
}

package schedulingWizard;

import java.util.ArrayList;

public class MustNotOverlap implements CourseConstraint
{
	String name;
	String type;
	ArrayList<Course> coursesInvolved;

	public MustNotOverlap(String name, String type, ArrayList<Course> coursesInvolved)
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
		//arrayList<String>
		boolean hasBeenMet = true;
		for(int i = 0; i < coursesInvolved.size(); i++)
		{
			for(int j = 1; j < coursesInvolved.size(); j++)
			{
				if((coursesInvolved.get(i)).getStartTime().equals((coursesInvolved.get(j)).getStartTime()))
				{
					//System.out.println((coursesInvolved.get(i)).getCourseCode() + " DOES NOT overlaps with " + (coursesInvolved.get(j)).getCourseCode());
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

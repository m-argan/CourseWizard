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
		for(Course course:this.coursesInvolved)
		{
			for(Course course1:this.coursesInvolved)
			{
				if(course.getStartTime().equals(course1.getStartTime()))
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

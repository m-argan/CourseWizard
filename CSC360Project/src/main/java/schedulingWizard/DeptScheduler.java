package schedulingWizard;

import java.util.ArrayList;

public class DeptScheduler extends Scheduler
{
	String name;
	String dept;
	public DeptScheduler(String name, String department)
	{
		super(name, department);
		// TODO Auto-generated constructor stub
	}
	@Override
	public ArrayList<CourseConstraint> checkCourseConstraints() throws IllegalArgumentException
	{
		throw new IllegalArgumentException ("You are not authorized");
	}

}

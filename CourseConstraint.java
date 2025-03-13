package schedulingWizard;

import java.util.ArrayList;

interface CourseConstraint
{
	String getType();
	String getName();
	ArrayList<Course> getCoursesInvolved();
	Boolean checkConstraint();
	
	//Boolean check();

}


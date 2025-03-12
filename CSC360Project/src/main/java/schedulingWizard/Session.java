package schedulingWizard;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Map;

public class Session extends History
{
	//Dictionary<String,ArrayList<String>> masterSchedule;
	String nameOfScheduler;
	String roleOfScheduler;
	String deptOfScheduler;
	History history = new History();
	
	public Session(String name, String role, String dept)
	{
		nameOfScheduler = name;
		roleOfScheduler = role;
		deptOfScheduler = dept;
	}
	public void startNewTerm()
	{
		for(String depts : History.departments)
		{
			ArrayList<Course> newDeptSchedule= new ArrayList<Course>();
			history.addToMasterSchedule(depts, newDeptSchedule);
			System.out.println("Added" + depts + "to schedule");
		}
	}
	public Scheduler validate()
	{
		Map<String, String> deptHeads1 = History.deptHeads;
		//System.out.println("deptheads within session:" + deptHeads1);
		for(String currDept : deptHeads1.keySet()) {
			//System.out.println("currDept" + currDept);
			//System.out.println("deptofScheduler" + deptOfScheduler);
			if(currDept.equals(deptOfScheduler))
			{
				if((deptHeads1.get(currDept)).equals(nameOfScheduler))
				{
					if(deptOfScheduler.equals("Registrars Office"))
					{
						
						RegistrarScheduler regScheduler = new RegistrarScheduler(nameOfScheduler, deptOfScheduler);
						System.out.println("returning.." + regScheduler);
						return regScheduler;
					}
					else
					{
						DeptScheduler deptScheduler = new DeptScheduler(nameOfScheduler, deptOfScheduler);
						System.out.println("returning.." + deptScheduler);
						return deptScheduler;
					}
						
				}
			}
		}
		throw new IllegalArgumentException("You do not have permission to access the scheduler");
		//throw exception?
	}

}

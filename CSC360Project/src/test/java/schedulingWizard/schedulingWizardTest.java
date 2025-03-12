package schedulingWizard;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class schedulingWizardTest
{
	History history = new History();
	Map<String, ArrayList<Course>> MasterScheduleForSpr21 = new HashMap<String, ArrayList<Course>>();
	Map<String, ArrayList<Course>> MasterScheduleForSpr20 = new HashMap<String, ArrayList<Course>>();
	ArrayList<Course> HistorySchedule = new ArrayList<Course>();
	ArrayList<Course> MathSchedule = new ArrayList<Course>();
	@BeforeEach
	void setUp() throws Exception
	{
		
		history.addToDeptHeads("Registrars Office", "Jacob Johnson");
		history.addToDeptHeads("Computer Science", "Dr. Bradshaw");
		
		ArrayList<String> depts = new ArrayList<String>(Arrays.asList("History", "Computer Science", "Music", "Math", "Axe Throwing"));
		History.setDepartments(depts);
		/*
		ArrayList<String> rooms = new ArrayList<String>(Arrays.asList("Olin203", "JVAC110", "JVAC120", "Young110", "Young120"));
		History.setRooms(rooms);
		
		ArrayList<String> professors = new ArrayList<String>(Arrays.asList("Toth", "Dr. B", "Dr. Brown", "Prof"));
		History.setProfessors(professors);
		
		ArrayList<String> typesOfConstraints = new ArrayList<String>(Arrays.asList("MustNotOverLap", "Dr. B", "Dr. Brown", "Prof"));
		History.setTypesOfConstraints(typesOfConstraints);*/
		
		//creating an example CSC Master schedule
		ArrayList<String> CSC270GenEdTags = new ArrayList<String> (Arrays.asList("D3"));
		Course CSC270 = new Course("Data Structures", "CSC270", CSC270GenEdTags, 
				"Olin203", "Spr25", "Toth", "Computer Science","9:00AM", "10:00AM",10);
		ArrayList<Course> CSCMasterSchedule = new ArrayList<Course> (Arrays.asList(CSC270));
		history.addToMasterSchedule("Computer Science", CSCMasterSchedule);
		
		//creating an example ARS Master Schedule
		ArrayList<String> ARS210GenEdTags = new ArrayList<String> (Arrays.asList("D1", "Arts Exploration"));
		Course ARS210 = new Course("Intro to Oil Painting", "ARS210", ARS210GenEdTags, 
				"JVAC110", "Spr25", "Brown", "Studio Art","9:00AM", "10:00AM", 10);
		ArrayList<String> ARS220GenEdTags = new ArrayList<String> (Arrays.asList("D1"));
		Course ARS220 = new Course("Advanced Oil Painting", "ARS210", ARS220GenEdTags, 
				"JVAC120", "Spr25", "Brown", "Studio Art","9:00AM", "10:00AM", 10);
		ArrayList<Course> ARSMasterSchedule = new ArrayList<Course> (Arrays.asList(ARS210,ARS220));
		history.addToMasterSchedule("Studio Art", ARSMasterSchedule);
		
		
		//example past schedule
		ArrayList<String> HIS210GenEdTags = new ArrayList<String> (Arrays.asList("D2"));
		Course HIS210 = new Course("History of Cool Stuff", "HIS210", HIS210GenEdTags, 
				"Young110", "Spr20", "Prof", "History","9:00AM", "10:00AM", 10);
		ArrayList<String> HIS300GenEdTags = new ArrayList<String> (Arrays.asList("D2"));
		Course HIS300 = new Course("History of Even Cooler Stuff", "HIS300", HIS300GenEdTags, 
				"Young120", "Spr20", "Prof", "History","9:00AM", "10:00AM", 10);
		ArrayList<String> HIS100GenEdTags = new ArrayList<String> (Arrays.asList("D2"));
		Course HIS100 = new Course("History for Dummies", "HIS100", HIS100GenEdTags, 
				"Young120", "Spr20", "Prof", "History","9:00AM", "10:00AM", 10);
		ArrayList<String> HIS001GenEdTags = new ArrayList<String> (Arrays.asList(""));
		Course HIS001 = new Course("History for Even Dummer Dummies", "HIS001", HIS001GenEdTags, 
				"Young120", "Spr20", "Prof", "History","9:00AM", "10:00AM", 10);
		//ArrayList<Course> HistorySchedule = new ArrayList<Course> (Arrays.asList(HIS210, HIS300, HIS100, HIS001));
		HistorySchedule.add(HIS210);
		HistorySchedule.add(HIS300);
		HistorySchedule.add(HIS100);
		HistorySchedule.add(HIS001);
		
		ArrayList<String> MAT001GenEdTags = new ArrayList<String> (Arrays.asList("D1"));
		Course MAT001 = new Course("Adding Class", "MAT100", MAT001GenEdTags, 
				"Olin110", "Spr20", "Prof", "Math","9:00AM", "10:00AM", 10);
		ArrayList<String> MAT002GenEdTags = new ArrayList<String> (Arrays.asList("D1"));
		Course MAT002 = new Course("Subtracting Class", "MAT002", MAT002GenEdTags, 
				"Olin110", "Spr20", "Prof", "Math","9:00AM", "10:00AM", 10);
		ArrayList<String> MAT003GenEdTags = new ArrayList<String> (Arrays.asList("D1"));
		Course MAT003 = new Course("We're Doing Division Now", "MAT003", MAT003GenEdTags, 
				"Olin110", "Spr20", "Prof", "Math","9:00AM", "10:00AM", 10);
		ArrayList<String> MAT400GenEdTags = new ArrayList<String> (Arrays.asList("D1"));
		Course MAT400 = new Course("Rocket Science", "MAT400", MAT400GenEdTags, 
				"Olin110", "Spr20", "Prof", "Math","9:00AM", "10:00AM", 10);
		MathSchedule.add(MAT001);
		MathSchedule.add(MAT002); 
		MathSchedule.add(MAT003);
		MathSchedule.add(MAT400);
		
		MasterScheduleForSpr20.put("History", HistorySchedule);
		MasterScheduleForSpr20.put("Math", MathSchedule);

		ArrayList<String> MUS100GenEdTags = new ArrayList<String> (Arrays.asList("D1"));
		Course MUS100 = new Course("Music 101", "MUS100", MUS100GenEdTags, 
				"Grant Basement", "Spr21", "Prof", "Music","9:00AM", "10:00AM", 10);
		ArrayList<String> MUS200GenEdTags = new ArrayList<String> (Arrays.asList("D1"));
		Course MUS200 = new Course("Intro to Drums", "MUS200", MUS200GenEdTags, 
				"Grant Basement", "Spr21", "Prof", "Music","9:00AM", "10:00AM", 10);
		ArrayList<String> MUS300GenEdTags = new ArrayList<String> (Arrays.asList("D1"));
		Course MUS300 = new Course("Intro to Rock Music", "MUS300", MUS300GenEdTags, 
				"Grant Basement", "Spr21", "Prof", "Music","9:00AM", "10:00AM", 10);
		ArrayList<String> MUS400GenEdTags = new ArrayList<String> (Arrays.asList("D1"));
		Course MUS400 = new Course("Selling Out Venues", "MUS400", MUS400GenEdTags, 
				"Grant Basement", "Spr21", "Prof", "Music","9:00AM", "10:00AM", 10);

		ArrayList<Course> MusicSchedule = new ArrayList<Course> (Arrays.asList(MUS100, MUS200, MUS300, MUS400));
		
		ArrayList<String> AXE100GenEdTags = new ArrayList<String> (Arrays.asList("D2"));
		Course AXE100 = new Course("Intro to Axe Throwing", "AXE100", AXE100GenEdTags, 
				"My Backyard", "Spr21", "Viking Man", "Axe Throwing","9:00AM", "10:00AM", 10);
		ArrayList<String> AXE101GenEdTags = new ArrayList<String> (Arrays.asList("D2"));
		Course AXE101 = new Course("Weapons 101", "AXE101", AXE101GenEdTags, 
				"My Backyard", "Spr21", "Viking Man", "Axe Throwing","9:00AM", "10:00AM", 10);
		ArrayList<String> AXE200GenEdTags = new ArrayList<String> (Arrays.asList("D2"));
		Course AXE200 = new Course("Axe Throwing 200", "AXE200", AXE200GenEdTags, 
				"My Backyard", "Spr21", "Viking Man", "Axe Throwing","9:00AM", "10:00AM", 10);
		ArrayList<String> AXE300GenEdTags = new ArrayList<String> (Arrays.asList("D2"));
		Course AXE300 = new Course("Expert Axe Throwing", "AXE300", AXE300GenEdTags, 
				"My Backyard", "Spr21", "Viking Man", "Axe Throwing","9:00AM", "10:00AM", 10);
		
		ArrayList<Course> AxeThrowingSchedule = new ArrayList<Course> (Arrays.asList(AXE100, AXE101, AXE200, AXE300));
		
		MasterScheduleForSpr21.put("Music", MusicSchedule);
		MasterScheduleForSpr21.put("Axe Throwing", AxeThrowingSchedule);
		
		history.addToMegaMasterSchedule("Spr20", MasterScheduleForSpr20);
		history.addToMegaMasterSchedule("Spr21", MasterScheduleForSpr21);
		
	}

	@Test
	void testValidate()
	{
		//test session for registrar
		ArrayList<String> ARS3000GenEdTags = new ArrayList<String>();
		ARS3000GenEdTags.add("D1");
		Session registrarSession = new Session("Jacob Johnson", "Registrar", "Registrars Office");
		Scheduler registrar = registrarSession.validate();
		Course courseAdded1 = registrar.addNewCourse("Expert Oil Painting", "ARS3000", ARS3000GenEdTags, "JVAC200", "Spr25", "Brown", "Studio Art", "10:00AM", "11:00AM", 10);
		assertTrue((courseAdded1.getCourseCode().equals("ARS3000")));
				
		//test session for rando
		ArrayList<String> AXE900GenEdTags = new ArrayList<String>();
		AXE900GenEdTags.add("DLMIII");
		Session randoSession = new Session("Viking Man", "Dept Head", "Axe Throwing");
				
		assertThrows(IllegalArgumentException.class, () -> {
			randoSession.validate();
		});
					
				//test session for sneaky rando
		Session sneakyRandoSession = new Session("Dr. B Impersonator", "Dept Head", "Computer Science");
					
		assertThrows(IllegalArgumentException.class, () -> {
			sneakyRandoSession.validate();
		});
	}
	
	@Test
	void testCourseBuilder()
	{
		ArrayList<String> CSC360GenEdTags = new ArrayList<String>();
		CSC360GenEdTags.add("D3");
		Course CSC360 = new Course("Software Design", "CSC360", CSC360GenEdTags, 
				"Olin201", "Spr25", "Bradshaw", "Computer Science","8:00AM", "9:00AM",10);
		assertEquals(CSC360.getCourseName(),"Software Design");
		assertEquals(CSC360.getCourseCode(),"CSC360");
		assertEquals(CSC360.getGenEdTags(),CSC360GenEdTags);
		assertEquals(CSC360.getRoom(),"Olin201");
		assertEquals(CSC360.getTerm(),"Spr25");
		assertEquals(CSC360.getProfessor(),"Bradshaw");
		assertEquals(CSC360.getDeptName(), "Computer Science");
		assertEquals(CSC360.getStartTime(),"8:00AM");
		assertEquals(CSC360.getEndTime(),"9:00AM");
		assertEquals(CSC360.getActualCapacity(), 10);
		

	}
	
	@Test
	void testAddAndRemoveCourse()
	{
		//test session for department head
		ArrayList<String> CSC180GenEdTags = new ArrayList<String>();
		CSC180GenEdTags.add("D3");
		Session deptHeadSession = new Session("Dr. Bradshaw", "Dept Head", "Computer Science");
		Scheduler deptHead = deptHeadSession.validate();
		
		deptHeadSession.startNewTerm();
		ArrayList<Course> emptyArray = new ArrayList<Course>();
		assertEquals(history.getScheduleForDept("History"),emptyArray);
		
		//adding new courses
		Course courseAdded = deptHead.addNewCourse("Systems Programming", "CSC180", CSC180GenEdTags, "Olin201", "Spr25", "Toth", "Computer Science", "8:00AM", "9:00AM", 10);
		ArrayList<Course> exDeptArray = new ArrayList<Course>();
		exDeptArray.add(courseAdded);
		assertTrue((courseAdded.getCourseCode()).equals("CSC180"));
		assertEquals(history.getScheduleForDept("Computer Science"), exDeptArray);
		
		//adding already existing courses
		Course courseRetrieved = deptHead.addExistingCourse("Spr20", "Math", "MAT100");
		ArrayList<Course> exDeptArray1 = new ArrayList<Course>();
		exDeptArray1.add(courseRetrieved);
		assertTrue((courseRetrieved.getCourseCode()).equals("MAT100"));
		assertEquals(history.getScheduleForDept("Math"), exDeptArray1);
		
		//trying to add a course that doesn't exist
		assertThrows(NullPointerException.class, () -> {
			deptHead.addExistingCourse("Spr20", "Made up Dept", "MUC300");
	    });
			
		//removing course
		deptHead.removeCourse("Math", "MAT100");
		ArrayList<Course> exDeptArray2 = new ArrayList<Course>();
		exDeptArray2.remove(courseRetrieved);
		assertEquals(history.getScheduleForDept("Math"), exDeptArray2);
		
		
	}
	
	@Test
	void testAlter()
	{
		ArrayList<String> CSC360GenEdTags = new ArrayList<String>(Arrays.asList("D3"));
		Session session = new Session("Jacob Johnson", "Registrar", "Registrars Office");
		Scheduler scheduler = session.validate();
		Course course = scheduler.addNewCourse("Software Design", "CSC360", CSC360GenEdTags, "Olin201", "Spr25", "Bradshaw", "Computer Science", "8:00AM", "9:00AM", 10);
		//test alter room
		scheduler.alterRoom(course, "My Room");
		assertEquals(course.room,"My Room");
		//test alter course code
		scheduler.alterCourseCode(course, "Sleep101");
		assertEquals(course.courseCode,"Sleep101");
		//test alter course name
		scheduler.alterCourseName(course, "How to Sleep");
		assertEquals(course.courseName,"How to Sleep");
		//test alter genEdTags
		ArrayList<String> genEdTags = new ArrayList<String>(Arrays.asList("DLMIII"));
		scheduler.alterGenEdTags(course, genEdTags);
		assertEquals(course.genEdTags,genEdTags);
		//test alter term
		scheduler.alterTerm(course, "Spr26");
		assertEquals(course.term,"Spr26");
		//test alter prof
		scheduler.alterProf(course, "Me");
		assertEquals(course.professor, "Me");
		//test alter dept
		scheduler.alterDept(course, "Sleep");
		assertEquals(course.departmentName, "Sleep");
		//test alter start time
		scheduler.alterStartTime(course, "12:44PM");
		assertEquals(course.startTime, "12:44PM");
		//test alter end time
		scheduler.alterEndTime(course, "8:00AM");
		assertEquals(course.endTime, "8:00AM");
		//test alter capacity
		scheduler.alterCapacity(course, 100);
		assertEquals(course.actualCapacity, 100);
	}
	
	@Test
	void testgetSchedule()
	{
		ArrayList<Course> courseListMath = history.getCoursesForDept("Spr20", "Math");
		assertEquals(courseListMath,MathSchedule);
		
		ArrayList<Course> courseListHistory = history.getCoursesForDept("Spr20", "History");
		assertEquals(courseListHistory,HistorySchedule);
		
		
		assertThrows(NullPointerException.class, () -> {
			history.getCoursesForDept("Spr20", "Bunjee Jumping");
		});
	}	
	
	
	@Test
	void testMustNotOverlapCourseConstraints()
	{
		ArrayList<String> CSC360GenEdTags = new ArrayList<String>();
		CSC360GenEdTags.add("D3");
		
		Course CSC360 = new Course("Software Design", "CSC360", CSC360GenEdTags, 
				"Olin201", "Spr25", "Bradshaw", "Computer Science","8:00AM", "9:00AM",10);
		Course CSC180 = new Course("Systems Programming", "CSC180", CSC360GenEdTags, 
				"Olin202", "Spr25", "Toth", "Computer Science","8:00AM", "9:00AM",10);
		Course CSC270 = new Course("Data Structures", "CSC270", CSC360GenEdTags, 
				"Olin203", "Spr25", "Toth", "Computer Science","9:00AM", "10:00AM",10);
		
		ArrayList<Course> CoursesInvolvedCon1 = new ArrayList<Course>();
		CoursesInvolvedCon1.add(CSC360);
		CoursesInvolvedCon1.add(CSC180);
		
		CourseConstraint MustNotOverlap360and180 = new MustNotOverlap("MustNotOverlap360and180", 
				"MustNotOverlap", CoursesInvolvedCon1);
		
		ArrayList<Course> CoursesInvolvedCon2 = new ArrayList<Course>();
		CoursesInvolvedCon1.add(CSC360);
		CoursesInvolvedCon1.add(CSC270);
		
		CourseConstraint MustNotOverlap360and270 = new MustNotOverlap("MustNotOverlap360and270", 
				"MustNotOverlap", CoursesInvolvedCon2);
		
		assertFalse(MustNotOverlap360and180.checkConstraint());
		assertTrue(MustNotOverlap360and270.checkConstraint());
	}
	
	@Test
	void testMustOverlapCourseConstraints()
	{
		ArrayList<String> CSC360GenEdTags = new ArrayList<String>();
		CSC360GenEdTags.add("D3");
		
		Course CSC360 = new Course("Software Design", "CSC360", CSC360GenEdTags, 
				"Olin201", "Spr25", "Bradshaw", "Computer Science","8:00AM", "9:00AM",10);
		Course CSC180 = new Course("Systems Programming", "CSC180", CSC360GenEdTags, 
				"Olin202", "Spr25", "Toth", "Computer Science","8:00AM", "9:00AM",10);
		Course CSC270 = new Course("Data Structures", "CSC270", CSC360GenEdTags, 
				"Olin203", "Spr25", "Toth", "Computer Science","9:00AM", "10:00AM",10);
		
		ArrayList<Course> CoursesInvolvedCon1 = new ArrayList<Course>();
		CoursesInvolvedCon1.add(CSC360);
		CoursesInvolvedCon1.add(CSC180);
		
		CourseConstraint GottaOverlap360and180 = new MustOverlap("GottaOverlap360and180", 
				"MustOverlap", CoursesInvolvedCon1);
		
		
		ArrayList<Course> CoursesInvolvedCon2 = new ArrayList<Course>();
		CoursesInvolvedCon2.add(CSC360);
		CoursesInvolvedCon2.add(CSC270);
		
		CourseConstraint GottaOverlap360and270 = new MustOverlap("GottaOverlap360and270", 
				"MustOverlap", CoursesInvolvedCon2);
		
		ArrayList<Course> CoursesInvolvedCon3 = new ArrayList<Course>();
		CoursesInvolvedCon3.add(CSC180);
		CoursesInvolvedCon3.add(CSC270);
		CoursesInvolvedCon3.add(CSC360);
		
		
		CourseConstraint GottaOverlapAll = new MustOverlap("GottaOverlap360and270and180", 
				"MustOverlap", CoursesInvolvedCon3);
		
		assertTrue(GottaOverlap360and180.checkConstraint());
		assertFalse(GottaOverlap360and270.checkConstraint());
		assertFalse(GottaOverlapAll.checkConstraint());
	}
	
	@Test
	void testMustBeOfferedCourseConstraint()
	{
		ArrayList<String> CSC360GenEdTags = new ArrayList<String>();
		CSC360GenEdTags.add("D3");
		Course CSC360 = new Course("Software Design", "CSC360", CSC360GenEdTags, 
				"Olin201", "Spr25", "Bradshaw", "Computer Science","8:00AM", "9:00AM",10);
		Course CSC180 = new Course("Systems Programming", "CSC180", CSC360GenEdTags, 
				"Olin202", "Spr25", "Toth", "Computer Science","8:00AM", "9:00AM",10);
		Course CSC270 = new Course("Data Structures", "CSC270", CSC360GenEdTags, 
				"Olin203", "Spr25", "Toth", "Computer Science","9:00AM", "10:00AM",10);
		
		ArrayList<Course> mustBeOfferedSpr25 = new ArrayList<Course>();
		mustBeOfferedSpr25.add(CSC360);
		mustBeOfferedSpr25.add(CSC180);
		
		CourseConstraint CSC360andCSC180MustBeOfferedSPR25 = new MustBeOffered("180and360mustbeofferedspring2025", 
				"MustBeOffered", mustBeOfferedSpr25, "Spr25");
		
		ArrayList<Course> mustBeOfferedFa25 = new ArrayList<Course>();
		mustBeOfferedFa25.add(CSC270);
		
		CourseConstraint CSC270MustBeOfferedFa25 = new MustBeOffered("270mustbeofferedfall2025", 
				"MustBeOffered", mustBeOfferedSpr25, "Fa25");
		
		assertTrue(CSC360andCSC180MustBeOfferedSPR25.checkConstraint());
		assertFalse(CSC270MustBeOfferedFa25.checkConstraint());
		
	}
	
	
	

}

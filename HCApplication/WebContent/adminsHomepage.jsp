<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">Welcome "ADMIN"</div>
		<div class="panel-body">
		<div class="list-group">
	<a href="#" class="list-group-item">Create, update, list, or disable a course</a>
	<a href="#" class="list-group-item">Create, update, list, or disable a classroom</a>
	<a href="#" class="list-group-item">Create, update, list, or disable a department</a>	
	<a href="#" class="list-group-item">Create, update, list, or disable a major</a>
	<a href="#" class="list-group-item">Add class to schedule for current or later semester</a>
	<a href="#" class="list-group-item">Remove class to schedule for current or later semester</a>
	<a href="#" class="list-group-item">Change a new users type to (student, instructor, advisor, or administrator)</a>
	<a href="#" class="list-group-item">Override maximum enrollment hold</a>
	<a href="advisorsCourseServlet" class="list-group-item">View all courses</a>
	<a href="#" class="list-group-item">View all classes by an instructor</a>
	<a href="#" class="list-group-item">View all classes by a student</a>
	<a href="#" class="list-group-item">View a list of all students taught by an instructor</a>
	<a href="#" class="list-group-item">View a list of all instructors that have taught a class</a>
	<a href="#" class="list-group-item">View a list of all classes that an instructor has taught</a>
	<a href="#" class="list-group-item">View a list of all classes of a course</a>
	<a href="#" class="list-group-item">View a list of all classrooms used by a course</a>
	<a href="#" class="list-group-item">View a list of all classrooms used by an instructor</a>
	<a href="#" class="list-group-item">View a list of all classrooms used by a student</a>
	
	<a href="AllClassesCurrSem" class="list-group-item">View all classes in current semester</a>
	<a href="AllClassesInSubjCurrSem" class="list-group-item">View all classes in a subject in current semester</a>
  	<a href="AllClassesByInstructorCurrSem" class="list-group-item">View all classes by an instructor in a current semester</a>
  	<a href="AllClassesAtTimeCurrSem" class="list-group-item">View all classes at a certain time in the current semester</a>
  	
  	<a href="departmentCoursesServlet" class="list-group-item">View all courses in a department</a>
  	<a href="departmentClassServlet" class="list-group-item">View all current classes in a department</a>
  	<a href="DepartmentMajorsServlet" class="list-group-item">View all majors in a department</a>

</div>
		
 
		</div>
		</div>
<%@ include file="footer.jsp"%>
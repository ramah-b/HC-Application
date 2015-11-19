<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">Welcome <c:out value="${empUser.name }" /></div>
		<div class="panel-body">
		<div class="list-group">
	<a href="courseServlet?action=list" class="list-group-item">Create, Update, List, or Disable a Course</a>
	<a href="classroomServlet?action=list" class="list-group-item">Create, Update, List, or Disable a Classroom</a>
	<a href="departmentServlet?action=list" class="list-group-item">Create, Update, List, or Disable a Department</a>	
	<a href="majorServlet?action=list" class="list-group-item">Create, Update, List, or Disable a Major</a>
	<a href="#" class="list-group-item">Add Class to Schedule for Current or Later Semester</a>
	<a href="#" class="list-group-item">Remove Class to Schedule for Current or Later Semester</a>
	<a href="StudentRoleChangeServlet" class="list-group-item">Change a Student's Role to (Instructor, Advisor, or Administrator)</a>
	<a href="EmployeeRoleChangeServlet" class="list-group-item">Change an Employee's role to (Student, Instructor, Advisor, or Administrator)</a>
	<a href="#" class="list-group-item">Override maximum enrollment hold</a>
	<a href="advisorsCourseServlet" class="list-group-item">View All Courses</a>
	<a href="adminViewServlet?action=listInstructorsClasses" class="list-group-item">View All Classes by an Instructor</a>
	<a href="adminViewServlet?action=listStudents" class="list-group-item">View All Classes by a Student</a>
	<a href="adminViewServlet?action=listInstructors" class="list-group-item">View a List of All Students Taught by an Instructor</a>
	<a href="#" class="list-group-item">View a list of all instructors that have taught a class</a>
	<a href="#" class="list-group-item">View a list of all classes of a course</a>
	<a href="#" class="list-group-item">View a list of all classrooms used by a course</a>
	<a href="#" class="list-group-item">View a list of all classrooms used by an instructor</a>
	<a href="#" class="list-group-item">View a list of all classrooms used by a student</a>
	<a href="AllClassesCurrSem" class="list-group-item">View all classes in current semester</a>
	<a href="selectSubjectToViewClasses" class="list-group-item">View all classes in a subject in current semester</a>
  	<a href="selectInstructorToViewClasses" class="list-group-item">View all classes by an instructor in a current semester</a>
  	<a href="selectTimetoViewClasses.jsp" class="list-group-item">View all classes at a certain time in the current semester</a>
  	<a href="departmentCoursesServlet" class="list-group-item">View all courses in a department</a>
  	<a href="departmentClassServlet" class="list-group-item">View all current classes in a department</a>
  	<a href="DepartmentMajorsServlet" class="list-group-item">View all majors in a department</a>

</div>
		
 
		</div>
		</div>
<%@ include file="footer.jsp"%>
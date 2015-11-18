<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">Welcome "Instructor"</div>
		<div class="panel-body">
		<div class="list-group">
  <a href="#" class="list-group-item">view your classes for the current semester</a>
  <a href="#" class="list-group-item">get roster of students for past or present semesters</a>
  <a href="#" class="list-group-item">assign grades</a>
  <a href="#" class="list-group-item">view grade sheets from previous semesters</a>
  <a href="advisorsCourseServlet" class="list-group-item">view all courses</a>
  <a href="AllClassesCurrSem" class="list-group-item">view all classes in current semester</a>
  <a href="selectSubjectToViewClasses" class="list-group-item">view all classes in a subject in current semester</a>
  <a href="selectInstructorToViewClasses" class="list-group-item">view all classes by an instructor in a current semester</a>
  <a href="selectTimetoViewClasses.jsp" class="list-group-item">view all classes at a certain time in the current semester</a>
  <a href="departmentCoursesServlet" class="list-group-item">View all courses in a department</a>
  <a href="departmentClassServlet" class="list-group-item">View all current classes in a department</a>
  <a href="DepartmentMajorsServlet" class="list-group-item">View all majors in a department</a>

</div>
		
 
		</div>
		</div>
<%@ include file="footer.jsp"%>
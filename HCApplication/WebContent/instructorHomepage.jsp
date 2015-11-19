<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">Welcome <c:out value="${instructor.name }" /></div>
		<div class="panel-body">
		<div class="list-group">
  <a href="viewClassesServlet?action=currentClasses" class="list-group-item">View Your Classes for the Current Semester</a>
  <a href="selectSemesterForm.jsp" class="list-group-item">Get Roster of Students for Past or Present Semesters</a>
  <a href="studentRelatedServlet?action=grade" class="list-group-item">Assign Grades</a>
  <a href="selectSemesterFormForGrades.jsp" class="list-group-item">View Grade Sheets From Previous Semesters</a>
  <a href="viewServlet?action=courses" class="list-group-item">View All Courses</a>
  <a href="AllClassesCurrSem" class="list-group-item">View All Classes in Current Semester</a>
  <a href="selectSubjectToViewClasses" class="list-group-item">View All Classes in a Subject in Current Semester</a>
  <a href="selectInstructorToViewClasses" class="list-group-item">View All Classes by an Instructor in a Current Semester</a>
  <a href="selectTimetoViewClasses.jsp" class="list-group-item">View All Classes at a Certain Time in the Current Semester</a>
  <a href="departmentCoursesServlet" class="list-group-item">View All Classes in a Department</a>
  <a href="departmentClassServlet" class="list-group-item">View All Current Classes in a Department</a>
  <a href="DepartmentMajorsServlet" class="list-group-item">View All Majors in a Department</a>

</div>
		
 
		</div>
		</div>
<%@ include file="footer.jsp"%>
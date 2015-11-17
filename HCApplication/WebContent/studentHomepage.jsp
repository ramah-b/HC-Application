<%@ include file="header.jsp"%>
<div class="panel panel-default">
	<div class="panel panel-heading">Welcome <c:out value="${student.name }" /></div>
	<div class="panel-body">
		<div class="list-group">
		  <a href="enrollClass?action=enrollJSP" class="list-group-item">Enroll in a Class</a>
		  <a href="dropClass?action=dropJSP" class="list-group-item">Drop a Class</a>
		  <a href="transcriptServlet?action=unofficial" class="list-group-item">View Unofficial Transcript</a>
		  <a href="transcriptServlet?action=official" class="list-group-item">Buy an Official Transcript ($5)</a>
		  <a href="viewServlet?action=courses" class="list-group-item">View All Courses</a>
		  <a href="#" class="list-group-item">view all classes in current semester</a>
		  <a href="#" class="list-group-item">view all classes in a subject in current semester</a>
		  <a href="#" class="list-group-item">view all classes by an instructor in a current semester</a>
		  <a href="#" class="list-group-item">view all classes at a certain time in the current semester</a>
		  <a href="viewServlet?action=departments" class="list-group-item">View All Courses in a Department</a>
		  <a href="departmentClassServlet" class="list-group-item">View All Current Classes in a Department</a>
		  <a href="DepartmentMajorsServlet" class="list-group-item">View All Majors in a Department</a>
		</div>
	<div>
</div>
<%@ include file="footer.jsp"%>
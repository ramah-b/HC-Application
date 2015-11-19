<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">List of Classes</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		<h3>Current Classes for this Department</h3>
		<table class="table table-hover">
		
		<tr>
		<th>Classes</th>
		<th>Course Number</th>
		<th>Credits</th>
		<th>Day of the Week</th>
		<th>Semester</th>
		
		</tr>
		<c:forEach var="courses" items="${courses}">
		<c:forEach var="food" items="${courses.hcClasses}">
		<tr>
		<td>${courses.name}</td>
		<td>${courses.courseNumber}</td>
		<td>${courses.credits}</td>
		<td>${food.day}</td>
		<td>${food.semester}</td>
		</tr>
		</c:forEach>

		</c:forEach>
		
		</table>
		
		
		
  
</div>
		
 
		</div>
		</div>
		<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
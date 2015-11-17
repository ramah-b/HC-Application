<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">List of Classes</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		<h3>Classes for this Department</h3>
		<table class="table table-hover">
		
		<tr>
		<th>Classes</th>
		<th>Course Number</th>
		<th>Credits</th>
		<th>Day of the Week</th>
		<th>Semester</th>
		
		</tr>
		<c:forEach var="courses" items="${courses}">
		<tr>
		<td>${courses.name}</td>
		<td>${courses.courseNumber}</td>
		<td>${courses.credits}</td>
		<td>${courses.hcClasses[i].day}</td>
		<td>${courses.hcClasses[i].semester}</td>
		</tr>
		</c:forEach>
		
		</table>
		
		
		
  
</div>
		
 
		</div>
		</div>
<%@ include file="footer.jsp"%>
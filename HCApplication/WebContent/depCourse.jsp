<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">List of Courses</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		<h3>Courses for this Department</h3>
		<table class="table table-hover">
		
		<tr>
		<th>Courses</th>
		
		</tr>
		<c:forEach var="course" items="${course}">
		<tr>
		<td>${course.name}</td>
		</tr>
		</c:forEach>
		
		</table>
		
		
		
  
</div>
		
 
		</div>
		</div>
		<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
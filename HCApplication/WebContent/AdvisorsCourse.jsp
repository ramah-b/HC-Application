<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">List of Courses</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		
		<table class="table table-hover">
		
		<tr>
		<th>Name</th>
		<th>Description</th>
		</tr>
		<c:forEach var="course" items="${course}">
		<tr>
		<td>${course.name}</td>
		<td>${course.description}</td>
		</tr>
		</c:forEach>
		
		</table>
		
		<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
		
  
</div>
		
 
		</div>
		</div>
<%@ include file="footer.jsp"%>
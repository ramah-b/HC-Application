<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">List of Students</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		<h3>Click The Student You Would Like to Change Roles For</h3>
		<table class="table table-hover">
		
		<tr>
		<th>Students</th>
		<th>Current Role</th>
		
		
		
		</tr>
		<c:forEach var="student" items="${student}">
		
		<tr>
		<td><a href="RoleChangeStudentServlet?personId=${student.hcPerson.personId}">${student.name}</a></td>
		<td>${student.hcPerson.hcRole.description}</td>
		</tr>
		</c:forEach>
		
		
		</table>
		
		
		
  
</div>
		
 
		</div>
		</div>
		<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
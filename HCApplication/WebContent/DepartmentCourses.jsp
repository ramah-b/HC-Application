<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">List of Departments</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		<h4>Click The Department You Would Like to See</h4>
		<table class="table table-hover">
		
		<tr>
		<th>Departments</th>
		
		</tr>
		<c:forEach var="department" items="${department}">
		<tr>
		<td><a href="findCourseDepartmentServlet?name=${department.name}">${department.name}</a></td>
		</tr>
		</c:forEach>
		
		</table>
		
		
		
  
</div>
		
 
		</div>
		</div>
		<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
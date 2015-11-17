<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">List of Departments</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		<h3>Click The Department You Would Like to See The Classes For</h3>
		<table class="table table-hover">
		
		<tr>
		<th>Departments</th>
		
		</tr>
		<c:forEach var="department" items="${department}">
		<tr>
		<td><a href="findDepartmentClassServlet?name=${department.name}">${department.name}</a></td>
		</tr>
		</c:forEach>
		
		</table>
		
		
		
  
</div>
		
 
		</div>
		</div>
<%@ include file="footer.jsp"%>
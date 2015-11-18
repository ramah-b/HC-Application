<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">List of Employees</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		<h3>Click The Employee You Would Like to Change Roles For</h3>
		<table class="table table-hover">
		
		<tr>
		<th>Employees</th>
		<th>Current Role</th>		
		
		</tr>
		<c:forEach var="employee" items="${employee}">
				
		<tr>
		<td><a href="RoleChangeEmployeeServlet?personId=${employee.hcPerson.personId}">${employee.name}</a></td>
		<td>${employee.hcPerson.hcRole.description}</td>
		</tr>
		</c:forEach>
		
		
		</table>
		
		
		
  
</div>
		
 
		</div>
		</div>
<%@ include file="footer.jsp"%>
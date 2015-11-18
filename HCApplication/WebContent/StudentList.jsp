<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">List of Students</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		<h3>Click The Student You Would Like to Change Roles For</h3>
		<table class="table table-hover">
		
		<tr>
		<th>Students</th>
		
		
		
		</tr>
		<c:forEach var="person" items="${person}">
		
		<tr>
		<td><a href="RoleChangeStudent.jsp?name=${person.name}">${person.name}</a></td>
		
		</tr>
		</c:forEach>
		
		
		</table>
		
		
		
  
</div>
		
 
		</div>
		</div>
<%@ include file="footer.jsp"%>
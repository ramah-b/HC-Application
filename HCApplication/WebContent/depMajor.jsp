<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">List of Majors</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		<h3>Majors for this Department</h3>
		<table class="table table-hover">
		
		<tr>
		<th>Majors</th>
		
		</tr>
		<c:forEach var="majors" items="${majors}">
		<tr>
		<td>${majors.name}</td>
		</tr>
		</c:forEach>
		
		</table>
		
		
		
  
</div>
		
 
		</div>
		</div>
<%@ include file="footer.jsp"%>
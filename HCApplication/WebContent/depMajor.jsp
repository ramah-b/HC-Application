<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">List of Majors</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		<h4>Majors for this Department</h4>
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
		<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
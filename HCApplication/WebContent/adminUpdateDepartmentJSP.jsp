<%@ include file="header.jsp"%>
<form action="departmentServlet?action=update" method="POST">
	<div class="panel panel-default">
		<div class="panel panel-heading">Update a Department</div>

		<div class="panel-body">
		<c:if test="${message != null }">
							<h4 style = "color: #780000"><c:out value="${message}" /></h4>
						</c:if>
		<input type="hidden" name="department_id"
						value="<c:out value="${department_id}" />" />
			<div class="form-group">
				<input type="name" class="form-control" name="name"
					id="exampleInputUser1" placeholder="Department Name" required>
			</div>
			
			<button type="submit" class="btn btn-warning">Update Department</button>
		</div>
	</div>
</form>
<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
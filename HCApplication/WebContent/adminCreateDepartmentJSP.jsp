<%@ include file="header.jsp"%>
<form action="departmentServlet?action=create" method="post">
	<div class="panel panel-default">
		<div class="panel panel-heading">Create a New Department</div>

		<div class="panel-body">
				<c:if test="${message != null }">
							<h4 style = "color: #780000"><c:out value="${message}" /></h4>
						</c:if>
			<div class="form-group">
				<input type="name" class="form-control" name="name"
					id="exampleInputname" placeholder="Department Name" required>
			</div>
			

			<button type="submit" class="btn btn-warning">Add Department</button>
		</div>
	</div>
</form>
<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
<%@ include file="header.jsp"%>
<form action="majorServlet?action=create" method="post">
	<div class="panel panel-default">
		<div class="panel panel-heading">Create a New Major</div>

		<div class="panel-body">
				<c:if test="${message != null }">
							<h4 style = "color: #780000"><c:out value="${message}" /></h4>
						</c:if>
			<div class="form-group">
				<input type="name" class="form-control" name="name"
					id="exampleInputname" placeholder="Major Name" required>
			</div>
			
			<div class="form-group">
								<select class="form-control" name="department_id" required>
									<option value="">Select</option>
									<c:forEach var="department" items="${departments }">
									<option value="${department.departmentId }">${department.name }</option>
									</c:forEach>
								</select>
							</div>
			<button type="submit" class="btn btn-warning">Add Major</button>
		</div>
	</div>
</form>
<a class="btn btn-warning" href="#">Back</a>
<%@ include file="footer.jsp"%>
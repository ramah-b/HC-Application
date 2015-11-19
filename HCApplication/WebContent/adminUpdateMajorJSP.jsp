<%@ include file="header.jsp"%>
<form action="majorServlet?action=update" method="POST">
	<div class="panel panel-default">
		<div class="panel panel-heading">Update a Course</div>

		<div class="panel-body">
			
				
					<input type="hidden" name="major_id"
						value="<c:out value="${major_id}" />" />
			
			
			<div class="form-group">
				<input type="name" class="form-control" name="name"
					id="exampleInputUser1" placeholder="Major Name" required>
			</div>
			
			<div class="form-group">
				<select class="form-control" name="department_id">
					<option value="">Select</option>
					<c:forEach var="department" items="${departments }">
						<option value="${department.departmentId }">${department.name }</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-warning">Update Major</button>
		</div>
	</div>
</form>
<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>>
<%@ include file="footer.jsp"%>
<%@ include file="header.jsp"%>
<form action="classroomServlet?action=create" method="post">
	<div class="panel panel-default">
		<div class="panel panel-heading">Create a New Classroom</div>

		<div class="panel-body">
				<c:if test="${message != null }">
							<h4 style = "color: #780000"><c:out value="${message}" /></h4>
						</c:if>
			<div class="form-group">
				<input type="name" class="form-control" name="bldg_name"
					id="exampleInputname" placeholder="Building Name" required>
			</div>
			<div class="form-group">
				<input type="name" class="form-control" name="classroom_number"
					id="exampleInputUser1" placeholder="Classroom Number" required>
			</div>

			<div class="form-group">
				<input type="name" class="form-control" name="max_capacity"
					id="exampleInputUser1" placeholder="Maximum Capacity" required>
			</div>

			<button type="submit" class="btn btn-warning">Add Classroom</button>
		</div>
	</div>
</form>
<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
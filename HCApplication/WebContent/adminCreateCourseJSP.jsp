<%@ include file="header.jsp"%>
<form action="courseServlet?action=create" method="post">
	<div class="panel panel-default">
		<div class="panel panel-heading">Create a New Course</div>

		<div class="panel-body">
				<c:if test="${message != null }">
							<h4 style = "color: #780000"><c:out value="${message}" /></h4>
						</c:if>
			<div class="form-group">
				<input type="name" class="form-control" name="course_number"
					id="exampleInputname" placeholder="Course Number" required>
			</div>
			<div class="form-group">
				<input type="name" class="form-control" name="subject_code"
					id="exampleInputUser1" placeholder="Subject Code" required>
			</div>
			<div class="form-group">
				<input type="name" class="form-control" name="name"
					id="exampleInputUser1" placeholder="Name">
			</div>
			<div class="form-group">
				<input type="name" class="form-control" name="description"
					id="exampleInputUser1" placeholder="Description">
			</div>
			<div class="form-group">
				<input type="name" class="form-control" name="credits"
					id="exampleInputUser1" placeholder="Credits" required>
			</div>
			<div class="form-group">
								<select class="form-control" name="department_id" required>
									<option value="">Select</option>
									<c:forEach var="department" items="${departments }">
									<option value="${department.departmentId }">${department.name }</option>
									</c:forEach>
								</select>
							</div>
			<button type="submit" class="btn btn-warning">Add Course</button>
		</div>
	</div>
</form>
<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
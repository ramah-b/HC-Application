<%@ include file="header.jsp"%>
<form action="courseServlet?action=create" method="post">
	<div class="panel panel-default">
		<div class="panel panel-heading">Create a New Course</div>

		<div class="panel-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">Course Number</label>
				<div class="col-sm-10">
					<p class="form-control-static">
						<c:out value="${course_number }" />
					</p>
					<input type="hidden" name="course_number"
						value="<c:out value="${course.courseNumber}" />" />
				</div>

			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Subject Code</label>
				<div class="col-sm-10">
					<p class="form-control-static">
						<c:out value="${subject_code }" />
					</p>
					<input type="hidden" name="subject_code"
						value="<c:out value="${course.subjectcode}" />" />
				</div>

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
			<button type="submit" class="btn btn-warning">Update Course</button>
		</div>
	</div>
</form>
<a class="btn btn-warning" href="#">Back</a>
<%@ include file="footer.jsp"%>
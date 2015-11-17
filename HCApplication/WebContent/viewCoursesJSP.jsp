<%@ include file="header.jsp"%>
<div class="panel panel-default">
	<div class="panel panel-heading">Available Courses</div>
	<div class="panel-body">
		<div class="list-group">
		<table class="table">
			<thead>
				<th>Course</th>
				<th>Name</th>
				<th>Description</th>
				<th>Credits</th>
				<th>Department</th>
			</thead>
			<tbody>
				<c:forEach var="course" items="${avail_courses}">
					<tr><td>${course.courseNumber} ${course.subjectcode }</td>
						<td>${course.name}</td>
						<td>${course.description}</td>
						<td>${course.credits}</td>
						<td>${course.hcDepartment.name}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
</div>
<a class="btn btn-warning" href="generalServlet?action=homepage">Back</a>
<%@ include file="footer.jsp"%>
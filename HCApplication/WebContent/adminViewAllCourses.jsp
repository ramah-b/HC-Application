<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<c:choose>
		<c:when test="${not empty courses}">
			<div class="panel panel-heading">Courses List</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<th>Course Number</th>
						<th>Subject Code</th>
						<th>Name</th>
						<th>Description</th>
						<th>Credits</th>
						<th>Department Name</th>
						<th>Is Enabled</th>
						<th>Enable/Disable</th>
						<th>Update</th>
					</thead>

					<tbody>
						<c:forEach var="course" items="${courses}">
							<tr>
								<td>${course.courseNumber}</td>
								<td>${course.subjectcode }</td>
								<td>${course.name }</td>
								<td>${course.description }</td>
								<td>${course.credits }</td>
								<td>${course.hcDepartment.name }</td>
								<form action="courseServlet?action=disable" method="POST">
									<input type="hidden" name="course_number"
										value="<c:out value="${course.courseNumber}" />" /> <input
										type="hidden" name="subject_code"
										value="<c:out value="${course.subjectcode}" />" />
								<td><c:choose>
										<c:when test="${course.existsFlag == 1 }">Yes</c:when>
										<c:otherwise>No</c:otherwise>
									</c:choose></td>
								<td><button class="btn" name="crn"
										value="${a_class.hcClass.crn }">Change</button></td>
								</form>
								<form action="courseServlet?action=updateJSP" method="POST">
									<input type="hidden" name="course_number"
										value="<c:out value="${course.courseNumber}" />" /> <input
										type="hidden" name="subject_code"
										value="<c:out value="${course.subjectcode}" />" />
										<td><button class="btn" name="crn"
										value="${a_class.hcClass.crn }">Update</button></td>
								</form>
								</form>
							</tr>
						</c:forEach>

					</tbody>


				</table>


			</div>
		</c:when>
		<c:otherwise>
			<div class="panel panel-heading">No Classes Found.</div>
			<div class="panel-body"></div>
		</c:otherwise>
	</c:choose>
</div>
<a class="btn btn-warning" href="courseServlet?action=createJSP">Create
	Course</a>
<a class="btn btn-warning" href="#">Back</a>
<%@ include file="footer.jsp"%>
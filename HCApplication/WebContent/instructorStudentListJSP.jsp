<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<div class="panel panel-heading">
		List of Students
	</div>
	<c:choose>
		<c:when test="${not empty class_list}">

			<c:forEach var="a_class" items="${class_list}">
				<c:choose>
					<c:when test="${not empty a_class.hcGrades}">
					<div class="panel-body">
						<h4>Class ${a_class.crn } -
							${a_class.hcCours.courseNumber}${a_class.hcCours.subjectcode }</h4>
						
							<table class="table">
								<thead>
									<th>Student Name</th>
									<th>Major</th>

								</thead>

								<tbody>
									<c:forEach var="student"
										items="${a_class.hcGrades}">
										<tr>
											<td>${student.hcPerson.hcStudent.name }</td>
											<td>${student.hcPerson.hcStudent.major}</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					</c:when>
					<c:otherwise>
						<p>no students</p>
					</c:otherwise>
				</c:choose>
			</c:forEach>

		</c:when>
		<c:otherwise>

			<div class="panel-body">
				<p>No Classes Found.</p>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
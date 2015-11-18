<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<div class="panel panel-heading">
		List of Students for
		<c:out value="${semester }" />
		<c:out value="${year }" />
	</div>
	<c:choose>
		<c:when test="${not empty class_list}">

			<c:forEach var="a_class" items="${class_list}">
				<c:choose>
					<c:when test="${not empty a_class.hcGrades}">
						<div class="panel panel-heading">Class ${a_class.crn } -
							${a_class.hcCours.courseNumber}${a_class.hcCours.subjectcode }</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<th>Student Name</th>
									<th>Major</th>

								</thead>

								<tbody>
									<c:forEach var="student"
										items="${a_class.hcGrades.hcPerson.hcStudent}">
										<tr>
											<td>${student.name }</td>
											<td>${student.major}</td>
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
				<p>Classes Found.</p>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<a class="btn btn-warning" href="#">Back</a>
<%@ include file="footer.jsp"%>
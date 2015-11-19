<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<div class="panel panel-heading">
		Classes for Selected Student
	</div>
	<c:choose>
		<c:when test="${not empty grade_list}">

			<c:forEach var="grade" items="${grade_list}">
				
						
						<div class="panel-body">
							<table class="table">
								<thead>
									<th>CRN</th>
									<th>Course Number</th>
									<th>Subject Code</th>
									<th>Semester</th>
									<th>Year</th>

								</thead>

								<tbody>
									<c:forEach var="class"
										items="${grade.hcClass}">
										<tr>
											<td>${class.crn }</td>
											<td>${class.hcCours.courseNumber}</td>
											<td>${class.hcCours.subjectCode}</td>
											<td>${class.semester}</td>
											<td>${class.year}</td>
										</tr>
									</c:forEach>

								</tbody>
							</table>
						</div>
					
			</c:forEach>

		</c:when>
		<c:otherwise>

			<div class="panel-body">
				<p>No Classes Found.</p>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<a class="btn btn-warning" href="#">Back</a>
<%@ include file="footer.jsp"%>
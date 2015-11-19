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
									
										<tr>
											<td>${grade.hcClass.crn }</td>
											<td>${grade.hcClass.hcCours.courseNumber}</td>
											<td>${grade.hcClass.hcCours.subjectcode}</td>
											<td>${grade.hcClass.semester}</td>
											<td>${grade.hcClass.year}</td>
										</tr>
									

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

<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
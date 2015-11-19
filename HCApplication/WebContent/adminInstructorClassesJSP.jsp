<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<div class="panel panel-heading">
		List of Classes
	</div>
	<c:choose>
		<c:when test="${not empty class_list}">

			<c:forEach var="a_class" items="${class_list}">
				
						<div class="panel panel-heading">Class ${a_class.crn } -
							${a_class.hcCours.courseNumber}${a_class.hcCours.subjectcode }</div>
						<div class="panel-body">
							<table class="table">
								<thead>
									<th>Year</th>
									<th>Semester</th>

								</thead>

								<tbody>
									
										<tr>
											<td>${a_class.year}</td>
											<td>${a_class.semester}</td>
										</tr>
									

								</tbody>
							</table>
						</div>
					
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
<%@ include file="header.jsp"%>
<div class="panel panel-default">

	<div class="panel panel-heading">Unofficial Transcript</div>
	<div class="panel-body">
	<c:out value="${studnet.name }" />
		<table class="table">
			<thead>
				<th>CRN</th>
				<th>Course</th>
				<th>Credits</th>
				<th>Year</th>
				<th>Semester</th>
				<th>Day & Time</th>
				<th>Grade</th>
			</thead>

			<tbody>

				<c:forEach var="grade" items="${transcript}">
					<tr>
						<td>${grade.hcClass.crn}</td>
						<td>${grade.hcClass.hcCours.courseNumber}
							${grade.hcClass.hcCours.subjectcode }</td>
						<td>${grade.hcClass.hcCours.credits }</td>
						<td>${grade.hcClass.year }</td>
						<td>${grade.hcClass.semester }</td>
						<td>${grade.hcClass.day }${grade.hcClass.time }</td>
						<c:choose>
							<c:when test="${not empty grade.grade }">
								<td>${grade.grade}</td>
							</c:when>
							<c:otherwise>
								<td>NA</td>
							</c:otherwise>
						</c:choose>
					</tr>
				</c:forEach>

			</tbody>


		</table>


	</div>
	</div>
	<a class="btn btn-warning" href="#">Back</a>
	<%@ include file="footer.jsp"%>
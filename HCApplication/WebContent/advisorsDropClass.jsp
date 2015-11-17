<%@ include file="header.jsp"%>
<div class="panel panel-default">
	<c:choose>
		<c:when test="${not empty avail_grade}">
			<div class="panel panel-heading"><c:out value="${student.name}" />Choose a Class from the List
				Below to Drop</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<th>Select</th>
						<th>CRN</th>
						<th>Course</th>
						<th>Credits</th>
						<th>Year</th>
						<th>Semester</th>
						<th>Day & Time</th>
					</thead>

					<tbody>
						<form action="advisorsViewStudentServlet?action=drop" method="POST">
							<input type="hidden" name="student_id"
								value="<c:out value="${student_id}" />" />
							<c:forEach var="a_class" items="${avail_grade}">
								<tr>
									<td><button class="btn" name="crn"
											value="${a_class.hcClass.crn }">drop</button></td>
									<td>${a_class.hcClass.crn}</td>
									<td>${a_class.hcClass.hcCours.courseNumber}
										${a_class.hcClass.hcCours.subjectcode }</td>
									<td>${a_class.hcClass.hcCours.credits }</td>
									<td>${a_class.hcClass.year }</td>
									<td>${a_class.hcClass.semester }</td>
									<td>${a_class.hcClass.day }${a_class.hcClass.time }</td>
								</tr>
							</c:forEach>
						</form>
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
<a class="btn btn-warning" href="#">Back</a>
<%@ include file="footer.jsp"%>
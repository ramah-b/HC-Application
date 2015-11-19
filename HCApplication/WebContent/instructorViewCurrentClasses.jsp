<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<c:choose>
		<c:when test="${not empty class_list}">
			<div class="panel panel-heading">Your Classes for <c:out value="${semester }" /> <c:out value="${year }" /></div>
			<div class="panel-body">
			<c:if test="${message != null }">
							<h4 style = "color: #780000"><c:out value="${message}" /></h4>
						</c:if>
				<table class="table">
					<thead>
						<th>CRN</th>
						<th>Course Number</th>
						<th>Subject Code</th>
						<th>Name</th>
						<th>Description</th>
						<th>Credits</th>
						<th>Department Name</th>
						<th>Classroom Number</th>
					</thead>

					<tbody>
						<c:forEach var="a_class" items="${class_list}">
							<tr>
								<td>${a_class.crn }</td>
								<td>${a_class.hcCours.courseNumber}</td>
								<td>${a_class.hcCours.subjectcode }</td>
								<td>${a_class.hcCours.name }</td>
								<td>${a_class.hcCours.description }</td>
								<td>${a_class.hcCours.credits }</td>
								<td>${a_class.hcCours.hcDepartment.name }</td>
								<td>${a_class.hcClassroom.classroomNumber }</td>
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

<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<c:choose>
		<c:when test="${not empty instructors}">
			<div class="panel panel-heading">Instructors List</div>
			<div class="panel-body">
			<c:if test="${message != null }">
							<h4 style = "color: #780000"><c:out value="${message}" /></h4>
						</c:if>
				<table class="table">
					<thead>
						<th>Name</th>
						<th>Department Name</th>
						<th>View Students</th>
					</thead>

					<tbody>
						<c:forEach var="instructor" items="${instructors}">
							<tr>
								<td>${instructor.name}</td>
								<td>${instructor.hcDepartment.name }</td>
								<td>
								<form action="adminViewServlet?action=viewStudents" method="POST">
									<input type="hidden" name="person_id"
										value="<c:out value="${instructor.personId}" />" /> 
								<button class="btn">View</button>
								</form>
								</td>
							</tr>
						</c:forEach>

					</tbody>


				</table>


			</div>
		</c:when>
		<c:otherwise>
			<div class="panel panel-heading">No Instructors Found.</div>
			<div class="panel-body"></div>
		</c:otherwise>
	</c:choose>
</div>
<a class="btn btn-warning" href="courseServlet?action=createJSP">Create
	Course</a>
<a class="btn btn-warning" href="#">Back</a>
<%@ include file="footer.jsp"%>
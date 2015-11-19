<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<c:choose>
		<c:when test="${not empty students}">
			<div class="panel panel-heading">Students List</div>
			<div class="panel-body">
			<c:if test="${message != null }">
							<h4 style = "color: #780000"><c:out value="${message}" /></h4>
						</c:if>
				<table class="table">
					<thead>
						<th>Name</th>
						<th>Major</th>
						<th>View Classes</th>
					</thead>

					<tbody>
						<c:forEach var="student" items="${students}">
							<tr>
								<td>${student.name}</td>
								<td>${student.major }</td>
								<td>
								<form action="adminViewServlet?action=viewClasses" method="POST">
									<input type="hidden" name="person_id"
										value="<c:out value="${student.personId}" />" /> 
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
			<div class="panel panel-heading">No Students Found.</div>
			<div class="panel-body"></div>
		</c:otherwise>
	</c:choose>
</div>
<a class="btn btn-warning" href="courseServlet?action=createJSP">Create
	Course</a>
<a class="btn btn-warning" href="#">Back</a>
<%@ include file="footer.jsp"%>
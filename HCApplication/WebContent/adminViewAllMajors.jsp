<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<c:choose>
		<c:when test="${not empty majors}">
			<div class="panel panel-heading">Majors List</div>
			<div class="panel-body">
			<c:if test="${message != null }">
							<h4 style = "color: #780000"><c:out value="${message}" /></h4>
						</c:if>
				<table class="table">
					<thead>
						<th>Major Name</th>
						<th>Department Name</th>
						<th>Is Enabled</th>
						<th>Enable/Disable</th>
						<th>Update</th>
					</thead>

					<tbody>
						<c:forEach var="major" items="${majors}">
							<tr>
								<td>${major.name}</td>
								<td>${major.hcDepartment.name }</td>
								<form action="majorServlet?action=disable" method="POST">
									<input type="hidden" name="major_id"
										value="<c:out value="${major.majorId}" />" /> 
								<td><c:choose>
										<c:when test="${major.existsFlag == 1 }">Yes</c:when>
										<c:otherwise>No</c:otherwise>
									</c:choose></td>
								<td><button class="btn">Change</button></td>
								</form>
								<form action="majorServlet?action=updateJSP" method="POST">
									<input type="hidden" name="major_id"
										value="<c:out value="${major.majorId}" />" /> 
										<td><button class="btn">Update</button></td>
								</form>
								</form>
							</tr>
						</c:forEach>

					</tbody>


				</table>


			</div>
		</c:when>
		<c:otherwise>
			<div class="panel panel-heading">No Majors Found.</div>
			<div class="panel-body"></div>
		</c:otherwise>
	</c:choose>
</div>
<a class="btn btn-warning" href="majorServlet?action=createJSP">Create
	Major</a>
<a class="btn btn-warning" href="#">Back</a>
<%@ include file="footer.jsp"%>
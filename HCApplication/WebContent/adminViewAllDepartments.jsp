<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<c:choose>
		<c:when test="${not empty departments}">
			<div class="panel panel-heading">Departments List</div>
			<c:if test="${message != null }">
							<h4 style = "color: #780000"><c:out value="${message}" /></h4>
						</c:if>
			<div class="panel-body">
				<table class="table">
					<thead>
						<th>Department Name</th>
						<th>Is Enabled</th>
						<th>Enable/Disable</th>
						<th>Update</th>
					</thead>

					<tbody>
						<c:forEach var="dept" items="${departments}">
							<tr>
								<td>${dept.name}</td>
								<form action="departmentServlet?action=disable" method="POST">
									<input type="hidden" name="department_id"
										value="<c:out value="${dept.departmentId }" />" /> 
								<td><c:choose>
										<c:when test="${dept.existsFlag == 1 }">Yes</c:when>
										<c:otherwise>No</c:otherwise>
									</c:choose></td>
								<td><button class="btn">Change</button></td>
								</form>
								<form action="departmentServlet?action=updateJSP" method="POST">
									<input type="hidden" name="department_id"
										value="<c:out value="${dept.departmentId }" />" />
										<td><button class="btn">Update</button></td>
								</form>
								
							</tr>
						</c:forEach>

					</tbody>


				</table>


			</div>
		</c:when>
		<c:otherwise>
			<div class="panel panel-heading">No Departments Found.</div>
			<div class="panel-body"></div>
		</c:otherwise>
	</c:choose>
</div>
<a class="btn btn-warning" href="departmentServlet?action=createJSP">Create
	Department</a>
<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
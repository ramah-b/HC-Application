<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<c:choose>
		<c:when test="${not empty classrooms}">
			<div class="panel panel-heading">Classrooms List</div>
			<c:if test="${message != null }">
							<h4 style = "color: #780000"><c:out value="${message}" /></h4>
						</c:if>
			<div class="panel-body">
				<table class="table">
					<thead>
						<th>Building Name</th>
						<th>Classroom Number</th>
						<th>Maximum Capacity</th>
						<th>Is Enabled</th>
						<th>Enable/Disable</th>
						<th>Update</th>
					</thead>

					<tbody>
						<c:forEach var="classroom" items="${classrooms}">
							<tr>
								<td>${classroom.buildingName}</td>
								<td>${classroom.classroomNumber }</td>
								<td>${classroom.maxCapacity}</td>
								<form action="classroomServlet?action=disable" method="POST">
									<input type="hidden" name="classroom_number"
										value="<c:out value="${classroom.classroomNumber }" />" /> <input
										type="hidden" name="bldg_name"
										value="<c:out value="${classroom.buildingName}" />" />
								<td><c:choose>
										<c:when test="${classroom.existsFlag == 1 }">Yes</c:when>
										<c:otherwise>No</c:otherwise>
									</c:choose></td>
								<td><button class="btn">Change</button></td>
								</form>
								<form action="classroomServlet?action=updateJSP" method="POST">
									<input type="hidden" name="classroom_number"
										value="<c:out value="${classroom.classroomNumber}" />" /> <input
										type="hidden" name="bldg_name"
										value="<c:out value="${classroom.buildingName}" />" />
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
			<div class="panel panel-heading">No Classrooms Found.</div>
			<div class="panel-body"></div>
		</c:otherwise>
	</c:choose>
</div>
<a class="btn btn-warning" href="classroomServlet?action=createJSP">Create
	Classroom</a>
<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
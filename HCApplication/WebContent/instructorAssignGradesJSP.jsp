<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<div class="panel panel-heading">List of Students for<c:out value="${semester }" /><c:out value="${year }" /></div>
	<c:choose>
		<c:when test="${not empty class_list}">
			<c:forEach var="a_class" items="${class_list}">
				<div class="panel panel-heading">Class ${a_class.crn } - ${a_class.hcCours.courseNumber}${a_class.hcCours.subjectcode }</div>
				<c:choose>
					<c:when test="${not empty a_class.hcGrades}">
						<div class="panel-body">
							<table class="table">
								<thead>
									<th>Student Name</th>
									<th>Major</th>
								</thead>
								<tbody>
									<c:forEach var="student" items="${a_class.hcGrades}">
										<tr>
											<td>${student.hcPerson.hcStudent.name }</td>
											<td>${student.hcPerson.hcStudent.major}</td>
											<form action="studentRelatedServlet?action=assignGrade" method="POST">
												<input type="hidden" name="person_id" value="${student.hcPerson.personId }" /> 
												<input type="hidden" name="crn" value="${a_class.crn}" />
												<td><c:if test="${not empty student.grade } ">${student.grade}</c:if>
												<div class="form-group">
												<input type="name" class="form-control" name="grade" id="exampleInputUser1" placeholder="Grade" required>
												</div>
												</td>
												<button type="submit" class="btn">Grade!</button>
											</form>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</c:when>
					<c:otherwise><p>No Students</p>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div class="panel-body">
				<p>No Classes Found.</p>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<a class="btn btn-warning" href="#">Back</a>
<%@ include file="footer.jsp"%>
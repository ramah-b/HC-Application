<%@ include file="header.jsp"%>

<div class="panel panel-default">
	<div class="panel panel-heading">Assign Grades Form</div>
	<c:choose>
		<c:when test="${not empty class_list}">
			<c:forEach var="a_class" items="${class_list}">
			<div class="panel-body">
				<h4>Class ${a_class.crn } - ${a_class.hcCours.courseNumber} ${a_class.hcCours.subjectcode }</h4>
				<c:choose>
					<c:when test="${not empty a_class.hcGrades}">
						
							<table class="table">
								<thead>
									<th>Student Name</th>
									<th>Major</th>
									<th>Grade</th>
									<th>Enter Grade</th>
								</thead>
								<tbody>
									<c:forEach var="student" items="${a_class.hcGrades}">
										<tr>
											<td>${student.hcPerson.hcStudent.name }</td>
											<td>${student.hcPerson.hcStudent.major}</td>
											<td><c:choose><c:when test="${not empty student.grade}">${student.grade}</c:when><c:otherwise>No Grade</c:otherwise></c:choose></td>
											<form action="studentRelatedServlet?action=assignGrade" method="POST">
												<input type="hidden" name="person_id" value="${student.hcPerson.personId }" /> 
												<input type="hidden" name="crn" value="${a_class.crn}" />
												<td>
												<div class="form-group">
												<select class="form-control" name="grade" required>
									<option value="">Select</option>
									
									<option value="A">A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="F">F</option>
								</select>
												
												
												<button type="submit" class="btn">Grade!</button>
												</div>
												</td>
												
											</form>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						
					</c:when>
					<c:otherwise><p>No Students </p></c:otherwise>
					
				</c:choose>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div class="panel-body">
				<p>No Classes Found.</p>
			</div>
		</c:otherwise>
	</c:choose>
</div>

<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
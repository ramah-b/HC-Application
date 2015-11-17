<%@ include file="header.jsp"%>
<div class="panel panel-default">
<c:choose>
<c:when test="${not empty avail_class}">
		<div class="panel panel-heading">Choose a Class from the List Below</div>
		<div class="panel-body">
<table class= "table">
<thead>
<th>Select</th>
<th>CRN</th>
<th>Course</th>
<th>Credits</th>
<th>Year</th>
<th>Semester</th>
<th>Day & Time</th>
<th>Instructor</th>
<th>Classroom Number</th>

</thead>

<tbody>
<form action="enrollClass?action=enroll" method="POST">
<c:forEach var="a_class" items="${avail_class}">
<tr>
<td><button class="btn" name="crn" value="${a_class.crn }">Enroll</button></td>
<td>${a_class.crn}</td>
<td>${a_class.hcCours.courseNumber} ${a_class.hcCours.subjectcode }</td>
<td>${a_class.hcCours.credits }</td>
<td>${a_class.year }</td>
<td>${a_class.semester }</td>
<td>${a_class.day } ${a_class.time }</td>
<td>${a_class.hcPerson.hcEmployee.name}</td>
<td>${a_class.hcClassroom.buildingName} ${a_class.hcClassroom.classroomNumber }</td>
</tr>
</c:forEach>
</form>
</tbody>


</table>
		
		</div>
		</c:when>
		<c:otherwise>
		<div class="panel panel-heading">No Enrolled Classes Found.</div>
		<div class="panel-body">
		</div>
		</c:otherwise>
		</c:choose>
		
		</div>
		
		<a class="btn btn-warning" href="generalServlet?action=homepage">Back</a>
<%@ include file="footer.jsp"%>
<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">Employee Role Change</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		<h4>Click the role you would like to change to</h4>
		<div class="container">
		<form action="ModifyStudent">
		<input type="hidden" name="personId" value="<c:out value="${personId}" />" />
		
		<div class="radio">
  <label>
  <c:choose>
  <c:when test="${student.hcPerson.hcRole.roleId != 1}">
    <input type="radio" name="roleId" id="admin" value="1">
    Change to an Administrator
  </c:when>
  <c:otherwise>
   <input type="radio" name="roleId" id="admin" disabled>
   Change to an Administrator
  </c:otherwise>
  </c:choose>
  </label>
</div>



<div class="radio">
  <label>
  <c:choose>
  <c:when test="${student.hcPerson.hcRole.roleId != 2}">
    <input type="radio" name="roleId" id="advisor" value="2">
    Change to an Advisor
  </c:when>
  <c:otherwise>
   <input type="radio" name="roleId" id="advisor" disabled>
   Change to an Advisor
  </c:otherwise>
 </c:choose>
  </label>
  </div>
  
  
 
  <div class="radio">
  <label>
  <c:choose>
  <c:when test="${student.hcPerson.hcRole.roleId != 3}">
    <input type="radio" name="roleId" id="instructor" value="3">
    Change to an Instructor
  </c:when>
  <c:otherwise>
   <input type="radio" name="roleId" id="instructor" disabled>
   Change to an Instructor
  </c:otherwise>
  </c:choose>
  </label>
  
  
  <div class="radio">
  <label>
  <c:choose>
  <c:when test="${student.hcPerson.hcRole.roleId != 4}">
    <input type="radio" name="roleId" id="student" value="4">
    Change to a Student
  </c:when>
  <c:otherwise>
   <input type="radio" name="roleId" id="student" disabled>
   Change to a Student
  </c:otherwise>
  </c:choose>
  </label>
</div>
</div>
</div>
  <br>
  <br>
  <button type="submit" class="btn btn-default">Make Change</button>
  
</div>	
		</form>
		
		</div>
		</div>		
 
<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
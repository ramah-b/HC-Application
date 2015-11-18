<%@ include file="header.jsp"%>
<div class="panel panel-default">
		<div class="panel panel-heading">Employee Role Change</div>
		<div class="panel-body">
		<div class="list-group">
		
		
		<h3>Click the role you would like to change to</h3>
		<div class="container">
		<form>
		<div class="radio">
  <label>
  <c:choose>
  <c:when test="${employee.hcPerson.hcRole.roleId != '1'}">
    <input type="radio" name="##" id="##" value="##">
    Change to an Administrator
  </c:when>
  <c:otherwise>
   <input type="radio" name="##" id="##" value="##" disabled>
   Change to an Administrator
  </c:otherwise>
  </c:choose>
  </label>
</div>



<div class="radio">
  <label>
  <c:choose>
  <c:when test="${employee.hcPerson.hcRole.roleId != '2'}">
    <input type="radio" name="##" id="##" value="##">
    Change to an Advisor
  </c:when>
  <c:otherwise>
   <input type="radio" name="##" id="##" value="##" disabled>
   Change to an Advisor
  </c:otherwise>
 </c:choose>
  </label>
  </div>
  
  
 
  <div class="radio">
  <label>
  <c:choose>
  <c:when test="${employee.hcPerson.hcRole.roleId != '3'}">
    <input type="radio" name="##" id="##" value="##">
    Change to an Instructor
  </c:when>
  <c:otherwise>
   <input type="radio" name="##" id="##" value="##" disabled>
   Change to an Instructor
  </c:otherwise>
  </c:choose>
  </label>
  
  
  <div class="radio">
  <label>
  <c:choose>
  <c:when test="${employee.hcPerson.hcRole.roleId != '4'}">
    <input type="radio" name="##" id="##" value="##">
    Change to a Student
  </c:when>
  <c:otherwise>
   <input type="radio" name="##" id="##" value="##" disabled>
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



<!-- <div class="radio disabled">
  <label>
    <input type="radio" name="optionsRadios" id="optionsRadios3" value="option3" disabled>
    Option three is disabled
  </label>
</div>
 -->	
		
		
		
		
		</form>
		</div>
		</div>
		
 
		</div>
		</div>
<%@ include file="footer.jsp"%>
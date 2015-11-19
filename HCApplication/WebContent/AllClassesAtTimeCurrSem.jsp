<%@ include file="header.jsp"%>




<div class="container">
<div class="panel panel-default">
<div align="center">
<h1>All Classes - ${currSem } ${currYear } at ${time }</h1>
</div>
  <div class="panel-body">
		
		<table class="table table-striped">
<thead>

			<tr>
			    <th>CRN</th>
				<th>Day</th>
				<th>Time</th>
				<th>Instructor</th>
				<th>Course</th>
				<th>Building</th>
				<th>Room</th>
			</tr>
</thead>
<tbody>

${tableinfo }

</tbody>
		</table>
				 
   </div>
   </div>
   </div>
 
   <a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
 
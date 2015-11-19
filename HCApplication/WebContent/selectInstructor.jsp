
<%@ include file="header.jsp"%>

<div class="container">
<div class="panel panel-default">
<div align="center">
<h4>Select Instructor</h4>
</div>
  <div class="panel-body">
		
		<table class="table table-striped">
<thead>
<th>Instructor Name</th>
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
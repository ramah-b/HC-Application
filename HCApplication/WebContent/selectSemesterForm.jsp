<%@ include file="header.jsp"%>

<div class="panel panel-default">
<div class="panel panel-heading">Choose a Semester and Year</div>
			<div class="panel-body">
	<form action="studentRelatedServlet?action=roster" method="POST">
	
	<div class="form-group">
								<select class="form-control" name="semester" required>
									<option value="">Select</option>
									<option value="Fall">Fall</option>
									<option value="Spring">Spring</option>
								
								</select>
							</div>
							<div class="form-group">
				<input type="name" class="form-control" name="year"
					id="exampleInputUser1" placeholder="Year" required >
			</div>
			<a class="btn btn-warning">Search</a>
	</form>
				

			</div>
		
			
	
</div>

<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>

<%@ include file="footer.jsp"%>
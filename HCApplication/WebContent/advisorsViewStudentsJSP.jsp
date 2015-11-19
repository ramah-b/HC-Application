<%@ include file="header.jsp"%>
<form action="advisorsViewStudentServlet?action=dropJSP" method="post">
	<div class="panel panel-default">
		<div class="panel panel-heading">Enter Student's ID</div>

		<div class="panel-body">



			<div class="form-group">
				<input type="name" class="form-control" name="student_id"
					id="exampleInputName" placeholder="Studnet ID">
			</div>


			<button type="submit" class="btn btn-info">Drop a Class</button>
		</div>
	</div>
</form>


<form action="advisorsViewStudentServlet?action=enrollJSP" method="post">
	<div class="panel panel-default">
		<div class="panel panel-heading">Enter Student's ID</div>

		<div class="panel-body">



			<div class="form-group">
				<input type="name" class="form-control" name="student_id"
					id="exampleInputName" placeholder="Studnet ID">
			</div>


			<button type="submit" class="btn btn-info">Enroll in a Class</button>
		</div>
	</div>
</form>


<form action="advisorsViewStudentServlet?action=transcript" method="post">
	<div class="panel panel-default">
		<div class="panel panel-heading">Enter Student's ID </div>

		<div class="panel-body">



			<div class="form-group">
				<input type="name" class="form-control" name="student_id"
					id="exampleInputName" placeholder="Studnet ID">
			</div>


			<button type="submit" class="btn btn-info">View Transcript a Class</button>
		</div>
	</div>
</form>
<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<%@ include file="footer.jsp"%>
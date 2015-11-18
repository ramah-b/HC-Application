<%@ include file="header.jsp"%>
<form action="classroomServlet?action=update" method="POST">
	<div class="panel panel-default">
		<div class="panel panel-heading">Update a Classroom</div>

		<div class="panel-body">
			<div class="form-group">
				<label class="col-sm-2 control-label">Building Name</label>
				<div class="col-sm-10">
					<p class="form-control-static">
						<c:out value="${bldg_name}" />
					</p>
					<input type="hidden" name="bldg_name"
						value="<c:out value="${bldg_name}" />" />
				</div>

			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">Classroom Number</label>
				<div class="col-sm-10">
					<p class="form-control-static">
						<c:out value="${classroom_number }" />
					</p>
					<input type="hidden" name="classroom_number"
						value="<c:out value="${classroom_number}" />" />
				</div>

			</div>
			<div class="form-group">
				<input type="name" class="form-control" name="max_capacity"
					id="exampleInputUser1" placeholder="Maximum Capacity">
			</div>
			
			<button type="submit" class="btn btn-warning">Update Classroom</button>
		</div>
	</div>
</form>
<a class="btn btn-warning" href="#">Back</a>
<%@ include file="footer.jsp"%>
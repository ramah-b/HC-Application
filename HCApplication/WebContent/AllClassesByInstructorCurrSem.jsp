<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Classes</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">

	<jsp:include page="header.jsp"/>
  </head>
  <body>
    

    </br >
<div class="container">
<div class="panel panel-default">
<div align="center">
<h1>All Classes by ${name } - ${currSem } ${currYear }</h1>
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
   
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
		integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
		crossorigin="anonymous"></script>
   
</body>
  <foot>
  <jsp:include page="footer.jsp"/>
  </foot>
</html>
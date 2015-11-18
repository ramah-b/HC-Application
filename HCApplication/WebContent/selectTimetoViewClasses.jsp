<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title></title>

   <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>

	<jsp:include page="header.jsp"/>
  </head>
  <body>
    

    </br >
<div class="container">
<div class="panel panel-default">
<div align="center">
<h1>View Classes at:</h1>
</div>
  <div class="panel-body" align="center">	
  <!-- Single button -->
<div class="btn-group">
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Time <span class="caret"></span>
  </button>
  <ul class="dropdown-menu">
    <li><a href="AllClassesAtTimeCurrSem?time=8am">8:00 am</a></li>
    <li><a href="AllClassesAtTimeCurrSem?time=9am">9:00 am</a></li>
    <li><a href="AllClassesAtTimeCurrSem?time=10am">10:00 am</a></li>
    <li><a href="AllClassesAtTimeCurrSem?time=11am">11:00 am</a></li>
    <li><a href="AllClassesAtTimeCurrSem?time=11am">12:00 pm</a></li>
    <li><a href="AllClassesAtTimeCurrSem?time=1pm">1:00 pm</a></li>
    <li><a href="AllClassesAtTimeCurrSem?time=2pm">2:00 pm</a></li>
    <li><a href="AllClassesAtTimeCurrSem?time=3pm">3:00 pm</a></li>
    <li><a href="AllClassesAtTimeCurrSem?time=4pm">4:00 pm</a></li>
    <li><a href="AllClassesAtTimeCurrSem?time=5pm">5:00 pm</a></li>
    <li><a href="AllClassesAtTimeCurrSem?time=6pm">6:00 pm</a></li>
    <li><a href="AllClassesAtTimeCurrSem?time=7pm">7:00 pm</a></li>
  </ul>
</div>	
				 
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
   
     <jsp:include page="footer.jsp"/>
</body>

</html>
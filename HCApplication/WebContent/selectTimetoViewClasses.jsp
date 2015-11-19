

<%@ include file="header.jsp"%>

	<div class="panel panel-default">
		<div class="panel panel-heading">Select a Time</div>

		<div class="panel-body">

<h4>View Classes at:</h4>

<div class="dropdown">
  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Time <span class="caret"></span>

  </button>
   <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
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
  
   
<a href="generalServlet?action=homepage" class="btn btn-warning">BACK TO HOMEPAGE</a>
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"
		integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ=="
		crossorigin="anonymous"></script>
		
	<%@ include file="footer.jsp"%>
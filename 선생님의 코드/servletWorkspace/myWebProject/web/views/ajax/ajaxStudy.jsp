<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ajax study</title>
<script type="text/javascript" src="/mwp/js/moment.min.js"></script>
<script type="text/javascript" src="/mwp/js/fullcalendar.min.js"></script>
<script type="text/javascript" src="/mwp/js/jquery-3.3.1.min.js"></script>
<link href='/mwp/js/fullcalendar.print.css' rel='stylesheet' />
<link href='/mwp/js/fullcalendar.min.css' rel='stylesheet' />
<style>
#calendar {
    max-width: 900px;
    margin: 0 auto;
  }
</style>
<script>
	$(function() {
		  $('#calendar').fullCalendar({
			  defaultDate: '2018-03-12',
		      editable: true,
		      eventLimit: true, // allow "more" link when too many events
		  })
		});
</script>
</head>
<body>


<div id='calendar'></div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HR COI Administrator</title>
</head>
<body>
<center><FONT SIZE=+1><B>HR COI Administrator</B></FONT></center>
<br /> <br />
	<form method="POST" action="dispatcher">
			Choose an action: 
		 <br /> <input type="radio" name="action" value="loadEmployees">Load Employees from .csv file
		 <br /> <input type="radio" name="action" value="activateEmployees">Activate Employees from .csv file
		 		 <br/> <br/> 
		 <input type="submit" value="Submit" name="upload" id="upload" /> 
		 <br/> <br/> <br/>
	</form>
</body>

</body>
</html>
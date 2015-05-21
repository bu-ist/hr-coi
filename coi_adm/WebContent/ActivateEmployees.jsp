<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>COI-ADM Activate CSV Upload</title>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<center><FONT SIZE=+1><B>HR COI Administrator</B></FONT></center>
<center><FONT SIZE=+1><B>Activate CSV Upload</B></FONT></center>
<br /> <br />
	<form method="POST" action="activateEmployees" enctype="multipart/form-data">
		File: <input type="file" name="file" id="file" accept=".csv" size="80"/> 
		 <br/> <br/> 
		 <input type="submit" value="Upload" name="upload" id="upload" />
		 <br/> <br/> <br/>
	</form>
</body>
</html>
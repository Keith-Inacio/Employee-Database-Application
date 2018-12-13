<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EMPLOYEE LOGIN PAGE</title>
<style type="text/css">
body {
	background-size: 100%;
}

h2 {
	margin-top: 200px;
	color: gold;
	background-color: Blue;
}

form {
	margin-top: 15px;
}
</style>
</head>
<h2 align='center'>EMPLOYEE DATABASE ACCESS</h2>
<body background="image.jpg">
	<form action="Login" method="post">
		<table align='center'>
			<tr>
				<td><font color="white">EMPLOYEE ID</font></td>
				<td><input type="text" name="EmpID"></td>
			</tr>
			<tr>
				<td><font color="white"> PASSWORD </font></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><font color="white">SUBMIT</font></td>
				<td><input type="submit" value="login"></td>
			</tr>
			<tr>
				<td><a href="http://localhost:8080/DBMS/register.jsp"><font
						color="Red">REGISTER</font></a></td>
			</tr>
		</table>
	</form>
</body>
</html>
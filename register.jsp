<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Employee Registration</title>
<style>
body{background-color:AliceBlue;}
h3{color: Navy;};
</style>
</head>
<body>
	<form action="Registration" method="post">
	<h3 align='center'> NEW EMPLOYEE REGISTRATION</h3>
	<table align='center'>
		<tr>
			<th>First Name</th>
			<td><input type="text" name="FirstName"></td>
		</tr>
		<tr>
			<th>Last Name</th>
			<td><input type="text" name="LastName"></td>
		</tr>
		<tr>
			<th>Employee ID</th>
			<td><input type="text" name="EmpID"></td>
		</tr>
		<tr>
			<th>Password</th>
			<td><input type="text" name="password"></td>
		</tr>
		<tr>
			<th>Position</th>
			<td><input type="text" name="Position"></td>
		</tr>
		<tr>
			<th>Salary</th>
			<td><input type="text" name="Salary"></td>
		</tr>
		<tr>
			<th>Telephone</th>
			<td><input type="text" name="Telephone"></td>
		</tr>
		<tr>
			<th>Address</th>
			<td><input type="text" name="Address"></td>
		</tr>
		<tr>
			<th>Email</th>
			<td><input type="text" name="Email"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" name="Register"></td>
		</tr>
	</table>
	</form>
</body>
</html>
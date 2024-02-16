<%@page import="jsp_student.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
</head>
<body>
	<%
	Student student = (Student) request.getAttribute("stud");
	%>
	<fieldset>
	<h2>Edit Profile</h2>
	<form action="edit" method="post">
	Id : <input type="hidden" name="id" value=<%=student.getId()%> readonly="true"><br><br>
	Name : <input type="text" name="name" value=<%=student.getName()%>><br><br>
	Phone : <input type="tel" name="phone" value=<%=student.getPhone()%>><br><br>
	Address : <input type="text" name="address" value=<%=student.getAddress()%>><br><br>
	Email :  <input type="text" name="email" value=<%=student.getEmail()%>><br><br>
	Password : <input type="text" name="password" value=<%=student.getPassword()%>><br><br>
	<button>Edit Profile</button>
	</form>
	</fieldset>
</body>
</html>
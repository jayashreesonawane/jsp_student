<%@page import="jsp_student.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success Page</title>
</head>
<body>
	<%
	List<Student> list = (List) request.getAttribute("list");
	%>
	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Address</th>
			<th>Email</th>
			<th>Password</th>
		</tr>

		<%
		for (Student student : list) {
		%>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getPhone()%></td>
			<td><%=student.getAddress()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getPassword()%></td>
			<td><a href="delete?id=<%=student.getId()%>"><button>Delete</button></a></td>
			<td><a href="update?id=<%=student.getId()%>"><button>Update</button></a></td>
		</tr>
		<%
		}
		%>


	</table>
</body>
</html>
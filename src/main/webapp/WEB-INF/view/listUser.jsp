<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserList</title>
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0"); // Proxies. %>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/files/style.css"></link>
</head>
<body align="center">
	<h4 style="color: red">LIST OF USER INFORMATION</h4>
	<hr color="blue" size="10" noshade>
	<br>
	<a href="${pageContext.request.contextPath}/addUser"><input
		type="button" value="AddUser"
		style="background-color: yellow; color: red; border-color: blue; width: 100px; height: 40px; font-size: 14px"></a>
	<p />
	<%
	String UpdateUrl;
	%>
	<table border="1px" width="1200px" heght="700px" align="center">
		<tr style="color: red">
			<th>S.No</th>
			<th>Name</th>
			<th>Email</th>
			<th>Designation</th>
			<th>Operations</th>
		</tr>
		<c:forEach var="users" items="${user}">
			<tr>
				<td>${users.sno}</td>
				<td>${users.name}</td>
				<td>${users.email}</td>
				<td>${users.designation}</td>


				<td><a href="${pageContext.request.contextPath}/edit?&sno=${users.sno}&name=${users.name}&email=${users.email}&designation=${users.designation}">
						<input type="button" value="Update"	style="background-color: green; color: white; border-color: blue"/></a> 
						|
						 <a href="${pageContext.request.contextPath}/delete?&id=${users.sno}">
						<input type="button" value="Delete"
						style="background-color: red; color: white; border-color: blue">
				</a></td>

			</tr>
		</c:forEach>
	</table>

	<br>
	<br>
	<hr color="blue" size="10" noshade>
</body>
</html>
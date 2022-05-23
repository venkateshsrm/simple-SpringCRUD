<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add User
<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0"); // Proxies. %>
</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/files/style.css"></link>
</head>
<body align="center">
	<h4 style="color: red">Add User Information</h4>
	<hr color="blue" size="10" noshade>
	<br>

	<table align="center">
		<form:form action="addUser" modelAttribute="user">
			<tr>
				<td align="right">Name:</td>
				<td><form:input type="text" path="name" reqired="true" /> <form:errors
						path="name" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td align="right">Email:</td>
				<td><form:input type="text" path="email" reqired="true" /> <form:errors
						path="email" cssStyle="color:red"></form:errors></td>
			<tr>
				<td align="right">Designation:</td>
				<td><form:input type="text" path="designation" reqired="true" />
					<form:errors path="designation" cssStyle="color:red"></form:errors>
				</td>
			<tr>
				<td colspan=2><input type="submit" style="background-color:pink;border-color:blue;width:100px;height:40px;font-size:20px;"></td></tr>
		</form:form>
	</table>
	<br>
	<br>
	<hr color="blue" size="10" noshade>
</body>
</html>
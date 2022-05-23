<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
response.setHeader("Expires", "0"); // Proxies.
%>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/files/style.css"></link>
</head>
<body align="center">
	<h4 style="color: red">Update User Information</h4>
	<hr color="blue" size="10" noshade>
	<br>
	<table align="center">
		<form:form action="update" modelAttribute="updateuser">
			<tr>
				<td align="right">Name:</td>
				<td><input type="text" id="name" name="name"
					value="${param.name}"></td>
			</tr>
			<tr>
				<td align="right">Email Address:</td>
				<td><input type="text" id="email" name="email"
					value="${param.email}"></td>
			</tr>
			<tr>
				<td align="right">Designation:</td>
				<td><input type="text" id="design" name="designation"
					value="${param.designation}"></td>
			</tr>
			<input type="hidden" name="sno" value="${param.sno}">
			<input type="hidden" name="form" value="updateuser">
			<tr></tr>
			<tr>
				<td colspan="2"><button type="submit"
						style="background-color:pink;border-color:blue;width:150px;height:40px;font-size:16px;">Update
						User</button></td>
			</tr>

		</form:form>
	</table>
	<br>
	<br>
	<br>
	<hr color="blue" size="10" noshade>
	<br>
</body>
</html>
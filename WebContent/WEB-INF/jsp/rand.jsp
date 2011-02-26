<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<script type="text/javascript" src="../js/utils.js"></script>
<head>
<title>Select Wikipedia Title</title>
</head>
<body>
<form:form name="titleForm" commandName="SelectTitleCommand">
	<form:hidden path="title" />
	<table align="center"  >
		<tr>
			<td valign="middle">
			<div id="title">${SelectTitleCommand.title}</div>
			<button type="button" value="skip"
				onclick="javascript:submitForm(this.value)">I'll Pass!</button>
			<button type="button" value="play"
				onclick="javascript:submitForm(this.value)">I'm Game!</button>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>



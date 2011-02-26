<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<html>
<script type="text/javascript" src="../js/utils.js"></script>
<head>
<title>Play!</title>
</head>
<body>
<form:form name="playForm">
	<table align="center">
		<tr>
			<td valign="middle">
			<div id="title">${title}</div>
			<button type="button" value="start">Start</button>
			<button type="button" value="stop">Stop</button>
			<button type="button" value="home"
				onclick="javascript:submitForm(this.value)">Take Me Back</button>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>



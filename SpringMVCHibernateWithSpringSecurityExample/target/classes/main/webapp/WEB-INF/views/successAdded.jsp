<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration Confirmation Page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
<div id="mainWrapper">
<%@include file="header.jsp" %>
	<div class="generic-container">
		<div class="alert alert-success lead">
	    <center>${success} <br>
	    <a href="<c:url value='personal-${user.id}' />">Вернуться в кабинет</a></center>
		</div>
		
		
	</div>
</div>	
</body>

</html>
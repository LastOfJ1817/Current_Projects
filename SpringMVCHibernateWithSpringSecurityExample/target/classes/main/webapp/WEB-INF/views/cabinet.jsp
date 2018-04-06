<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Personal area</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

</head>
<body>
	<div id="mainWrapper">
	<%@include file="header.jsp" %>	
		<div class="generic-container">
		
		<div class="panel panel-default" >
		<div style="float: left; width: 50%;">
		<h3 style="padding-left: 13px; ">Настройки профиля</h3>
		
			<a href="<c:url value='/edit-user-${user.ssoId}' />" class="btn">Регистрационные данные</a><br>
			<a href="<c:url value='/show-phone-${user.id}' />" class="btn">Контактные телефоны</a><br>
			<br>
		
		</div>
		
		<div style="float: left;  width: 50%; "> <br>
		<h4 style="float:right;">Добро пожаловать, ${user.firstName}!</h4><br><br><br>
		<h5 style="float:right;"><%
   Date date = new Date();
   out.print( "<p align=\"center\">" +date.toString()+"</p>");
%></h5>


		
		
	
		<center>
			
		</center>
		</div>
		
		
		</center>
		</div>
		<div class="panel panel-default" style="clear:both;" >
		<center><h2>Инструменты</h2></center><br>
		<center>
			<a href="<c:url value='/add-contragent-${user.id}' />" class="btn btn-primary btn-sm">Добавить контрагента</a> 
			<a href="<c:url value='/add-dogovor-${user.id}' />" class="btn btn-primary btn-sm">Добавить договор</a>
			
			<hr>
			<a href="<c:url value='/show-contragents-${user.id}' />" class="btn">Список контрагентов</a>
			<a href="<c:url value='/show-dogovors-${user.id}' />" class="btn">Список договоров</a>  <br/>
			
			<br>
		</center>
		</div>
		
		<%@include file="operations.jsp" %>
		
		
		
		
		
	</div>
	
	
		
		
		</div>
	
</body>
</html>
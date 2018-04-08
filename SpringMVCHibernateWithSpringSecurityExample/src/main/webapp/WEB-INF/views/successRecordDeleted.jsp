<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Personal area</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
<title>Home page</title>
</head>
<body>
	<div id="mainWrapper">
	<%@include file="header.jsp" %>	
		<div class="generic-container">
		
		<div class="panel panel-default" >
		<center><h3>Запись успешно удалена!</h3></center>
		<br>
		<center><h1>Книга учёта по УСН</h1></center>
		<br>
		<center>
			<a href="<c:url value='/add-debit-${user.id}' />" class="btn btn-success">Добавить поступление</a> 
			<a href="<c:url value='/add-credit' />" class="btn btn-danger">Добавить расход</a>
			<br>
			<hr>
			<center><h2>Посмотреть данные за период:</h2></center>
			<form:form method="GET" action="/debits" modelAttribute="debit" class="form-horizontal">
	<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="date">Дата начала</label>
				<div class="col-md-7">
			<form:input type="Date" path="date" class="form-control input-sm"/><br>
				</div>
				<label class="col-md-3 control-lable" for="date">Дата окончания</label>
				<div class="col-md-7">
			<form:input type="Date" path="date" class="form-control input-sm"/>
				</div>
			<p></p>
			
		</div>
	</div>
	<a href="<c:url value='/listOfCredits' />" class="btn">Список расходов</a>
	<a href="<c:url value='/show-debits-${user.id}' />" class="btn">Список доходов</a>
		</form:form></center>
		
		<br>
		</div>
		
		
		
		
	</div>
	
	
		
		
		</div>
	
</body>
</html>
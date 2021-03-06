<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

		<title>Personal area</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
<title> Добавление контрагента</title>
</head>
<body>
	<div id="mainWrapper">
	<%@include file="header.jsp" %>	
		<div class="generic-container">
		
		<div class="panel panel-default" >
		<center><h1>Контрагент</h1></center>
		<br>
		<form:form method="POST" modelAttribute="contragent" class="form-horizontal">
			<c:choose>
				<c:when test="${edit}">
			<form:input type="hidden" path="id" id="id" />
			</c:when>

			</c:choose>
			
			<form:input type="hidden" path="ownerID" value="${ownerID}" id="ownerID"/>
			
			
			
	<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="unp">УНП</label>
					<div class="col-md-7">
					
						<form:input required='INPUT_DATE!' type="number" step="any" path="unp" id="unp" 
							class="form-control input-sm"  />
						
						<div class="has-error">
							<form:errors path="unp" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			
	
	<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="document">Наименование юридического лица</label>
					<div class="col-md-7">
						<form:input required='INPUT_NAME!' type="text" path="name" id="name"
							class="form-control input-sm"  />
						<div class="has-error">
							<form:errors path="name" class="help-inline" />
						</div>
					</div>
				</div>
		</div>
		
		<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="addess">Адрес</label>
					<div class="col-md-7">
						<form:input required='INPUT_NAME!' type="text" path="address" id="address"
							class="form-control input-sm"  />
						<div class="has-error">
							<form:errors path="address" class="help-inline" />
						</div>
					</div>
				</div>
		</div>
		
		<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="phone">Телефон</label>
					<div class="col-md-7">
						<form:input required='INPUT_NAME!' type="text" path="phone" id="phone"
							class="form-control input-sm"  />
						<div class="has-error">
							<form:errors path="phone" class="help-inline" />
						</div>
					</div>
				</div>
		</div>
		
		<div class="row">
				<center><div class="form-actions">
					
					<input type="submit" value="Сохранить" class="btn btn-primary btn-sm" /> или <a
								href="<c:url value='personal-${ownerID}' />">Отменить</a>
								<br> <h4><a href="<c:url value='personal-${user.id}' />">Вернуться в кабинет</a></h4></center>
				</div></center>
			</div>
		
			<br>
		</form:form>
		
		</div>
		
		</div>
		</div>
	
</body>
</html>
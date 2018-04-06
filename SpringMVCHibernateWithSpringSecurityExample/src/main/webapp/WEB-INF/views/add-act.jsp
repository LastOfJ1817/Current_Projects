<%@page import="java.util.Date"%>
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
		<center><h1>Акт</h1></center>
		<br>
		<form:form method="POST" modelAttribute="act" class="form-horizontal">
			<c:choose>
				<c:when test="${edit}">
			<form:input type="hidden" path="actId" id="actId" />
			</c:when>

			</c:choose>
			
			<form:input type="hidden" path="ownerID" value="${ownerID}" id="ownerID"/>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="contragentID">Контрагент</label>
					<div class="col-md-7">
						<form:select path="contragentID" items="${contragents}" multiple="false" itemValue="id" itemLabel="name" class="form-control input-sm" />
						
						<div class="has-error">
							<form:errors path="contragentID" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="dogovorID">Договор</label>
					<div class="col-md-7">
						<form:select path="dogovorID" items="${dogovors}" multiple="false" itemValue="id" itemLabel="number" class="form-control input-sm" />
						
						<div class="has-error">
							<form:errors path="dogovorID" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			
	<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="date">Дата акта</label>
					<div class="col-md-7">
					
						<form:input required='INPUT_DATE!' type="date" path="date" id="date" 
							class="form-control input-sm"  />
						
						<div class="has-error">
							<form:errors path="date" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
		
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="number">Номер акта</label>
					<div class="col-md-7">
						<form:input required='INPUT_ВЩСГЬУТЕ!'  type="text"  path="number" id="number"
							class="form-control input-sm"  />
						<div class="has-error">
							<form:errors path="number" class="help-inline" />
						</div>
					</div>
				</div>
		</div>
		
		<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="summ">Сумма акта</label>
					<div class="col-md-7">
						<form:input required='INPUT_SUM!'  type="number" step="0.01"  path="summ" id="summ"
							class="form-control input-sm"  />
						<div class="has-error">
							<form:errors path="summ" class="help-inline" />
						</div>
					</div>
				</div>
		</div>
		
		
		
		<div class="row">
				<center><div class="form-actions">
					
					<input type="submit" value="Сохранить" class="btn btn-primary btn-sm" /> или <a
								href="<c:url value='personal-${ownerID}' />">Отменить</a><br>
								</center>
						
					
				</div>
			</form:form>
		
		
		</div>
		
	
	
</body>
</html>
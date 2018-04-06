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
<title>Insert title here</title>
<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>
<body>
<div class="panel panel-default" style="clear:both;" >
		<center><h1>Операции</h1></center>
		<br>
		<center>
			<a href="<c:url value='/add-debit-${user.id}' />" class="btn btn-success">Добавить поступление</a> 
			<a href="<c:url value='/add-act-${user.id}' />" class="btn btn-danger">Добавить акт</a>
			<br>
			<p></p>
			<p></p>
			
			
			<div style="float: left;">
			<h2>Поступления за период:</h2><br>
			<form:form method="GET"  modelAttribute="debit" action="listOfDebits-${user.id}" class="form-horizontal" style="float: left;">
			<form:input type="hidden" path="ownerID" id="ownerID" />
		<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="date">Дата начала</label>
				<div class="col-md-7">
			<input type="Date" path="date" id="startDate" name= "startDate" required='required' class="form-control input-sm"/><br>
				</div>
				<label class="col-md-3 control-lable" for="date">Дата окончания</label>
				<div class="col-md-7">
			<input type="Date" path="date" id="endDate"  name= "endDate" required='required' class="form-control input-sm"/>
				</div>
			<p></p>
			
		</div>
	</div>
	<div class="row">
				<center><div class="form-actions">
					<input type="submit" value="Поступления за период" class="btn btn-primary btn-sm" /></center>
				</div>
	<a href="<c:url value='/show-debits-${user.id}' />" class="btn">Список всех поступлений</a>
	</form:form></center>
	
	<div style="margin-top: 5px;">
			<p style="margin-left: 50px;"><h2 > Акты за период:</h2></p><br>
			<form:form method="GET"  modelAttribute="act" action="listOfActs-${user.id}" class="form-horizontal" style="float: left;">
			<form:input type="hidden" path="ownerID" id="ownerID" />
		<div class="row">
		<div class="form-group col-md-12">
			<label class="col-md-3 control-lable" for="date">Дата начала</label>
				<div class="col-md-7">
			<input type="Date" path="date" id="startDate" name= "startDate"  required='required' class="form-control input-sm"/><br>
			<div class="has-error">
							<form:errors path="date" class="help-inline" />
						</div>
				</div>
				<label class="col-md-3 control-lable" for="date">Дата окончания</label>
				<div class="col-md-7">
			<input type="Date" path="date" id="endDate"  name= "endDate" required='required' class="form-control input-sm"/>
			<div class="has-error">
							<form:errors path="date" class="help-inline" />
						</div>
				</div>
			<p></p>
			
		</div>
	</div>
	<div class="row">
				<center><div class="form-actions">
					<input type="submit" value="Акты за период" class="btn btn-primary btn-sm" /></center>
				</div>
	<center><a href="<c:url value='/show-acts-${user.id}' />" class="btn">Список всех актов</a>
	</form:form></center></div>
	
	</center>
	
<center>
		<div style="clear: both;">
		<br>
		</div></center>
		</div>
		
		</div>
		
	
	</center>
		
		<br>
		</div></div>
</div>
</body>
</html>
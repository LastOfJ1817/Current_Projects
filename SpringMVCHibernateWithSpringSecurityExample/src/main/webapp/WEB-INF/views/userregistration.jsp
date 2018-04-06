<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Регистрация нового пользователя</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
	<script>
	function addition() {
		var a = document.getElementById('ssoId').value;
		var c="/"+ a+"-form1.xlsx";
		document.getElementById('path').value = c;
	}
	</script>
</head>

<body>
<div id="mainWrapper">
<%@include file="header.jsp" %>
 	<div class="generic-container">
 	<div class="authbar">
		

		<div class="well lead"><center>Регистрационные данные пользователя</center></div>
	 	<form:form method="POST" modelAttribute="user" class="form-horizontal">
			<form:input type="hidden" path="id" id="id"/>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="firstName">Название организации</label>
					<div class="col-md-7">
						<form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
						<div class="has-error">
							<form:errors path="firstName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="lastName">Адрес</label>
					<div class="col-md-7">
						<form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="lastName" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="ssoId">УНП* <br>(будет использоваться в качестве логина)</label>
					<div class="col-md-7">
						<c:choose>
							<c:when test="${edit}">
								<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" disabled="true"/>
							</c:when>
							<c:otherwise>
								<form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" />
								<div class="has-error">
									<form:errors path="ssoId" class="help-inline"/>
								</div>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</div>
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Пароль</label>
					<div class="col-md-7">
						<form:input type="password" path="password" id="password" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="password" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			<!-- div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="password">Confirm Password</label>
					<div class="col-md-7">
						<form:input type="password" path="password" id="password" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="password" class="help-inline"/>
						</div>
					</div>
				</div>
			</div-->
	
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<form:input type="text" path="email" id="email" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="email" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
				<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="account">Расчетный счет</label>
					<div class="col-md-7">
						<form:input type="text" path="account" id="account" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="account" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="bank">Банк</label>
					<div class="col-md-7">
						<form:input type="text" path="bank" id="bank" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="bank" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					
					<div class="col-md-7">
						<form:input type="hidden" path="path1" itemValue="path1" id="path" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="path1" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
				
					<div class="col-md-7">
						<form:input type="hidden" path="userProfiles" itemValue="id" itemLabel="type" value="1" />
						
						<div class="has-error">
							<form:errors path="userProfiles" class="help-inline"/>
						</div>
					</div>
				</div>
			</div>
	
			<!--  div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="userProfiles">Roles</label>
					<div class="col-md-7">
						<form:select path="userProfiles" items="${roles}" multiple="false" itemValue="id" itemLabel="type" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="userProfiles" class="help-inline"/>
						</div>
					</div>
				</div>
			</div -->
	
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Обновить" class="btn btn-primary btn-sm"/> или <a href="<c:url value='/personal-${user.id}' />">Отменить</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Зарегистрировать" onclick="addition();" class="btn btn-primary btn-sm"/> или <a href="<c:url value='/' />">Отменить</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</form:form>
		</div>
	</div>
	</div>
</body>
</html>
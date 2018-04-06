<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Банк</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
 	<div id="mainWrapper">
	<%@include file="header.jsp" %>	
		<div class="generic-container">	
		<div class="panel panel-default">

		<div class="well lead">Банк </div>
	 	<form:form method="POST" modelAttribute="bank"
			class="form-horizontal">
			<form:input type="hidden" path="id" id="id" />
			


			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="bankName">Название банка</label>
					<div class="col-md-7">
						<form:input required='INPUT_BANKNAME!' type="text" path="bankName" id="bankName"
							class="form-control input-sm"  />
						<div class="has-error">
							<form:errors path="bankName" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="bankAddress">Адрес банка</label>
					<div class="col-md-7">
						<form:input required='INPUT_CODE!' type="text" path="bankAddress" id="bankAddress"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="bankAddress" class="help-inline" />
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="bankCode">БИК</label>
					<div class="col-md-7">
						<form:input required='INPUT_TYPE!' type="text" path="bankCode" id="bankCode"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="bankCode" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-actions floatRight">
					<c:choose>
						<c:when test="${edit}">
							<input type="submit" value="Редактировать"
								class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/personal-${user.id}' />">Отменить</a>
						</c:when>
						<c:otherwise>
							<input type="submit" value="Сохранить" class="btn btn-primary btn-sm" /> or <a
								href="<c:url value='/personal-${user.id}' />">Отменить</a>
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
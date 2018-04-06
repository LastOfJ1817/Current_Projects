<%@page import="java.util.List"%>
<%@page import="com.websystique.springmvc.model.Contragent"%>
<%@page import="com.websystique.springmvc.dao.ContragentDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Список договоров</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
<div id="mainWrapper">
	<%@include file="header.jsp" %>
	<div class="generic-container">
			
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="well lead"><center>
		  	Список договоров пользователя ${user.firstName} ${user.lastName} </center></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Номер</th>
				        <th>Дата</th>
				        <th>Контрагент</th>
					</tr>
					<tr>
				        <th>1</th>
				        <th>2</th>
				        <th>3</th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${dogovors}" var="dogovor">
					<tr>
						<td>${dogovor.number}</td>
						<td>${dogovor.date}</td>
						
						<td>
						<c:forEach items="${contragents}" var="contragent">
							<c:if test = "${contragent.id == dogovor.partnerId}">
        					   ${contragent.name}
      						</c:if>
						</c:forEach>
						</td>
						
					    <sec:authorize access="hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')">
							<td><a href="<c:url value='/edit-dogovor-${dogovor.id}' />" class="btn btn-success custom-width">Редактировать</a></td>
				        </sec:authorize>
				        <sec:authorize access="hasRole('USER')">
							<td><a href="<c:url value='/delete-dogovor-${dogovor.id}' />" class="btn btn-danger custom-width">Удалить</a></td>
        				</sec:authorize>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
		<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
		 	<div class="well">
		 		<a href="<c:url value='/add-dogovor-${ownerID}' />">Добавить договор</a> или <a href="<c:url value='personal-${ownerID}' />">Вернуться в кабинет >></a>
		 	</div>
	 	</sec:authorize>
		<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 		<a href="<c:url value='/newphone-${ownerID}' />">Add New Phone</a> OR <a href="<c:url value='/list' />">List of Users</a>
		 	</div>
	 	</sec:authorize>
	 	
   	</div>
   	</div>
</body>
</html>
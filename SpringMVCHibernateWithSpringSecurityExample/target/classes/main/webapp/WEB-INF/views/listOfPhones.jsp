<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Users List</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>

<body>
	<div id="mainWrapper">
	<%@include file="header.jsp" %>	
		<div class="generic-container">	
		<div class="panel panel-default">
			  <!-- Default panel contents -->
		  	<div class="panel-heading"><span class="lead">Контактные телефоны ${user.firstName} ${user.lastName} </span></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				       
				        <th>КОД СТРАНЫ</th>
				        <th>Телефон (с кодом оператора)</th>
				        <th>Тип</th>
				        <sec:authorize access="hasRole('MANAGER')">
				        	<th width="100"></th>
				        </sec:authorize>
				        <sec:authorize access="hasRole('MANAGER')">
				        	<th width="100"></th>
				        </sec:authorize>
				        
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${phones}" var="phone">
					<tr>
						
						<td>${phone.areaCode}</td>
						<td>${phone.phoneNumber}</td>
						<td>${phone.type}</td>
					    <sec:authorize access="hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')">
							<td><a href="<c:url value='/edit-phone-${phone.id}' />" class="btn btn-success custom-width">редактировать</a></td>
				        </sec:authorize>
				        <sec:authorize access="hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')">
							<td><a href="<c:url value='/delete-phone-${phone.id}' />" class="btn btn-danger custom-width">удалить</a></td>
        				</sec:authorize>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
		<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
		 	<div class="well">
		 		<a href="<c:url value='/newphone-${ownerID}' />">Добавить контактный телефон</a> или <a href="<c:url value='personal-${ownerID}' />">Вернуться в кабинет >></a>
		 	</div>
	 	</sec:authorize>
	 	
	 	<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 		 <a href="<c:url value='/list' />">List of Users</a>
		 	</div>
	 	</sec:authorize>
	 	</div>
	 	
	 	
   	</div>
</body>
</html>
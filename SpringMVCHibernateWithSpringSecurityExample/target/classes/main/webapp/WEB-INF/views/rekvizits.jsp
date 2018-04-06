<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>List of debits</title>
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
		  	Реквизиты пользователя ${user.firstName} ${user.lastName} </center></div>
			<table class="table table-hover">
	    		
	    	<thead>
		      		<tr>
				        <th>УНП</th>
				        <th>Адрес</th>
				        <th>Расчетный счет</th>
				        <th>Банк</th>
				        
					</tr>
					
		    	</thead>
	    		<tbody>
				<c:forEach items="${rekvizity}" var="rekvizity">
					<tr>
						<td>${rekvizity.unp}</td>
						<td>${rekvizity.address}</td>
						<td>${rekvizity.account}</td>
						
						
					    <sec:authorize access="hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')">
							<td><a href="<c:url value='/edit-debit-${rekvizity.id}' />" class="btn btn-success custom-width">edit</a></td>
				        </sec:authorize>
				        <sec:authorize access="hasRole('USER')">
							<td><a href="<c:url value='/delete-debit-${rekvizity.id}' />" class="btn btn-danger custom-width">delete</a></td>
        				</sec:authorize>
					
				</c:forEach>
	    		</tbody>
	    	</table>
		</div>
		<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 		<a href="<c:url value='/newphone-${ownerID}' />">Add New Phone</a> OR <a href="<c:url value='/list' />">List of Users</a>
		 	</div>
	 	</sec:authorize>
	 	
   	</div>
   	</div>
</body>
</html>
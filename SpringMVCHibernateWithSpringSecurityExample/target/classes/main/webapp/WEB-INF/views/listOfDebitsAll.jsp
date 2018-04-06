<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Список поступлений</title>
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
		  	Книга доходов пользователя ${user.firstName}<br>
		  	<center>	<a href="<c:url value='/downloadExcel-${user.id}' />" class="btn">Сохранить Форму 1</a> <a href="<c:url value='/downloadExcel2-${user.id}' />" class="btn">Сохранить Форму 2</a></center></center></div>
			<table class="table table-hover">
	    		<thead>
		      		<tr>
				        <th>Дата записи</th>
				        <th>Наименование документа, его номер и дата</th>
				        <th>Содержание операции</th>
				        <th>Выручка от реализации товаров, работ, услуг</th>
				        <th>В том числе НДС:</th>
				        
				        <th>Номер акта</th>
				        <th>Контрагент</th>
					</tr>
					<tr>
				        <th>1</th>
				        <th>2</th>
				        <th>3</th>
				        <th>4</th>
				        <th>5</th>
				        <th>6</th>
				        <th>7</th>
				        <th>8</th>
					</tr>
		    	</thead>
	    		<tbody>
				<c:forEach items="${debits}" var="debit">
					<tr>
						<td>${debit.date}</td>
						<td>${debit.document}</td>
						<td>${debit.description}</td>
						<td>${debit.incomeAmount}</td>
						<td>${debit.includingNDS}</td>
						
						<td>
						<c:forEach items="${acts}" var="act">
							<c:if test = "${act.actId == debit.actId}">
        					  Акт№ ${act.number} от ${act.date}
      						</c:if>
						</c:forEach>
						</td>
						<td>
						<c:forEach items="${contragents}" var="contragent">
							<c:if test = "${contragent.id == debit.contragentID}">
        					 	${contragent.name}
      						</c:if>
						</c:forEach>
						</td>
						
					    <sec:authorize access="hasRole('MANAGER') or hasRole('ADMIN') or hasRole('USER')">
							<td><a href="<c:url value='/edit-debit-${debit.id}' />" class="btn btn-success custom-width">Редактировать</a></td>
				        </sec:authorize>
				        <sec:authorize access="hasRole('USER')">
							<td><a href="<c:url value='/delete-debit-${debit.id}' />" class="btn btn-danger custom-width">Удалить</a></td>
        				</sec:authorize>
					</tr>
				</c:forEach>
	    		</tbody>
	    	</table>
	   
		
   	
		</div>
		
	<div class="panel panel-default">
	 <center>	<a href="<c:url value='/downloadExcel-${user.id}' />" class="btn">Сохранить Форму 1</a>  <a href="<c:url value='/downloadExcel2-${user.id}' />" class="btn">Сохранить Форму 2</a></center>
		<sec:authorize access="hasRole('ADMIN') or hasRole('USER')">
		 	<div class="well">
		 		<a href="<c:url value='/add-debit-${ownerID}' />">Добавить поступление</a> или <a href="<c:url value='personal-${ownerID}' />">Вернуться в кабинет >></a>
		 	</div>
	 	</sec:authorize>
		<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 		<a href="<c:url value='/newphone-${ownerID}' />">Add New Phone</a> OR <a href="<c:url value='/list' />">List of Users</a>
		 	</div>
	 	</sec:authorize>
		<sec:authorize access="hasRole('ADMIN')">
		 	<div class="well">
		 		<a href="<c:url value='/newphone-${ownerID}' />">Add New Phone</a> OR <a href="<c:url value='/list' />">List of Users</a>
		 	</div>
	 	</sec:authorize>
	 	
   	</div>
</body>
</html>
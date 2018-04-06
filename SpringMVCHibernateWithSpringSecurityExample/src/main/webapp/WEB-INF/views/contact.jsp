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
		<title>Наши контакты</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

</head>
<body>
	<div id="mainWrapper">
	<%@include file="header.jsp" %>	
		<div class="generic-container">
		
		<div class="panel panel-default" >
		<div>
		<center><h1>Наши контакты:</h1></center>
		<p></p>
		<br>
		<div style="float: left; margin: 0 30px;"><iframe src="https://www.google.com/maps/d/embed?mid=1R-KlMF2ouVwntbXEBRvGvkf88U5BnZ6F" width="400" height="300"></iframe></div>
		<div> 
		<h3>ООО "Фирма фирма"</h3>
		<p>УНП 65435487</p>
		<p>г. Минск, ул. Платонова, 20</p>
		<p>тел. +375 17 000 00 00</p>
		<p>тел. +375 29 000 00 00</p>
		<p>e-mail: ru@dfgjjkk.by</p>
		<p>skype: eeee_hhy</p>
		<a href="/Buh" >На главную</a>
		<br>
		<br>
		<br>
			<br>
				<br>
					<br>
		<p> </p>
		<p> </p>
		<p> </p>
		
		</div>
		
		
		</div>
	</div>
</div>
		
</div>
	
</body>
</html>
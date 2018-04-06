<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Бухгалтерия on-line для упрощенной системы учета</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
<title>Home page</title>
</head>
<body>
	<div id="mainWrapper">
	<%@include file="header.jsp" %>	
		<div class="generic-container">
		<div class="panel panel-default">
		<center><h1>Бухгалтерия on-line для УСН</h1></center>
		
		<br>
		<center><table>
		<tr>
		<td style="margin: 0 20px; text-align: center;"><center><img style="width:100px; height: 100px;" src="${pageContext.servletContext.contextPath}/static/images/domain-registration.png" alt="Регистрация"></center></td>
		<td style="margin: 0 20px; text-align: center;"><img style="width:100px; height: 100px;" src="${pageContext.servletContext.contextPath}/static/images/folder.png" alt="Регистрация"></td>
		<td style="margin: 0 20px; text-align: center;"><img style="width:100px; height: 100px;" src="${pageContext.servletContext.contextPath}/static/images/counting.png" alt="Регистрация"></td>
		<td style="margin: 0 20px; text-align: center;"><img style="width:100px; height: 100px;" src="${pageContext.servletContext.contextPath}/static/images/printer.png" alt="Регистрация"></td>
		</tr>
		<tr style="padding-top: 10px;">
			<td style="padding: 10px 20px; font-size: 16px; text-align: center;">Зарегистрируйтесь на сайте и заполните ваши реквизиты</td>
			<td style="padding: 10px 20px; font-size: 16px; text-align: center;">Внесите ваши данные по партнерам, договорам, доходам и расходам</td>
			<td style="padding: 10px 20px; font-size: 16px; text-align: center;">Программа сама разнесет данные по формам и рассчитает итоги</td>
			<td style="padding: 10px 20px; font-size: 16px; text-align: center;">Сохраните и распечатайте книги в формате Excel</td>
		</tr>
		
		</table></center>
		<br>
	
		
		
		</div>
		</div>
		<div class="generic-container">
		<div class="panel panel-default">
		<center><h2>Последние новости</h2></center>
		<hr/>
		<div style="padding: 0 20px;"><h3 style="padding: 0 0 20px;">Обновление форм учета</h3>
		<p style="font-size: 12px; font-style="italic;">30.12.2017</p>
		<p style="font-size: 14px;"> С 1 января 2018 года изменены формы книги учета для индивидуальных предпринимателей и организаций, применяющих упрощенную систему налогообложения.
		</p>
		
		</div>
		<br>
		<p></p>
		</div>
		</div>
	</div>

</body>
</html>
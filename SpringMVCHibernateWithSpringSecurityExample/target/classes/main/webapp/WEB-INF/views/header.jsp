<%@page import="com.websystique.springmvc.util.XMLParser"%>
<div class="generic-container">
		<%@include file="authheader.jsp" %>	
		<div class="panel panel-default">
		<div class="panel-heading">
		<center><a style="padding-right: 10px;" href="<c:url value="/" />">ГЛАВНАЯ</a>   <a href="<c:url value="/contact" />">КОНТАКТЫ</a></center>
		</div>
		
		<div class="panel-heading">
		<center>USD : <%=XMLParser.getCurrency("840") %> EUR : <%=XMLParser.getCurrency("978") %></center>
		</div>
		
		<div class="panel-heading" >
		<center><img style="width:100%; height: 300px;'" src="${pageContext.servletContext.contextPath}/static/images/money1.jpg" alt="Money"></center>
		</div>
		</div>
		</div>
		
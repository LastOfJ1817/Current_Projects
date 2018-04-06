<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Personal area</title>
		<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
		<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
		<link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
<title>Home page</title>
<script>
function addition() {
	var a = parseFloat(document.getElementById('incomeAmount').value);
	 var b =parseFloat(document.getElementById('otherAmount').value);
	 var c=a+b;
	 document.getElementById('totalAmount1').value = c;
	 
}

function func(){
	 var chbox;
	 chbox=document.getElementById('one');
	 var a = parseFloat(document.getElementById('incomeAmount').value);
	 
	 if (chbox.checked){
		 document.getElementById('NDSAmount').value = a*20/120;
	 } else {
		 document.getElementById('NDSAmount').value = 0;
	 }
}
	 
function func1(){
		 var contr;
		 contr=document.getElementById('contr').value;
		 var c = contr;
		 document.getElementById('123').value = c; 
}
</script>
</head>
<body>
	<div id="mainWrapper">
	<%@include file="header.jsp" %>	
		<div class="generic-container">
		
		<div class="panel panel-default" >
		<center><h1>Поступление</h1></center>
		<br>
		<form:form method="POST" modelAttribute="debit" class="form-horizontal">
			<c:choose>
				<c:when test="${edit}">
			<form:input type="hidden" path="id" id="id" />
			</c:when>

			</c:choose>
			
			<form:input type="hidden" path="ownerID" value="${ownerID}" id="ownerID"/>
			
			
			
	<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="date">Дата поступления</label>
					<div class="col-md-7">
					
						<form:input required='INPUT_DATE!' type="date" path="date" id="date" 
							class="form-control input-sm"  />
						
						<div class="has-error">
							<form:errors path="date" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			
	
	<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="document">Наименование и номер документа</label>
					<div class="col-md-7">
						<form:input required='INPUT_ВЩСГЬУТЕ!' type="text" path="document" id="document"
							class="form-control input-sm"  />
						<div class="has-error">
							<form:errors path="document" class="help-inline" />
						</div>
					</div>
				</div>
		</div>
		
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="description">Содержание операции</label>
					<div class="col-md-7">
						<form:input required='INPUT_ВЩСГЬУТЕ!' type="text" path="description" id="description"
							class="form-control input-sm"  />
						<div class="has-error">
							<form:errors path="description" class="help-inline" />
						</div>
					</div>
				</div>
		</div>
		
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="incomeAmount">Выручка от реализации товаров, работ, услуг. Всего:</label>
					<div class="col-md-7">
					
						<form:input type="number" step="0.01" path="incomeAmount" id="incomeAmount"
							class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="incomeAmount" class="help-inline" />
						</div>
					</div>
				</div>
		</div>
		<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="check">Работаю с НДС:</label>
					<div class="col-md-7">
						<input type="checkbox" id="one" onchange="func()">
						
					</div>
				</div>
		</div>
		
		<div class="row" >
				<div class="form-group col-md-12">
					
					<div class="col-md-7">
						<form:input  type="hidden" readonly="true"  path="includingNDS" itemValue="includingNDS" id="NDSAmount" 
							class="form-control input-sm"  />
						<div class="has-error">
							<form:errors path="includingNDS" class="help-inline" />
						</div>
					</div>
				</div>
		</div>
		
		<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="otherAmount">Внереализационные доходы:</label>
					<div class="col-md-7">
						<form:input required='INPUT_ВЩСГЬУТЕ!' type="number" step="0.01" path="otherAmount" id="otherAmount"
							class="form-control input-sm"  />
						<div class="has-error">
							<form:errors path="otherAmount" class="help-inline" />
						</div>
					</div>
				</div>
		
		</div>
				
		<div id="totalAmount" ></div>
		<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="contragentID">Контрагент:</label>
					<div class="col-md-7">
					
					<form:select path="contragentID" items="${contragents}" multiple="false" itemValue="id" itemLabel="name"  id="contr" class="form-control input-sm" />
						<div class="has-error">
							<form:errors path="contragentID" class="help-inline" />
						</div>
					</div>
				</div>
		</div>
		
	 
		
		<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="actID">АКТ:</label>
					<div class="col-md-7">
					<c:forEach items="${acts}" var="act">
							<c:if test = "${contragent.id == act.actId}">
        					   ${act.number}
      						</c:if>
						</c:forEach>
					
					<sf:select path="actId" multiple="true" class="form-control input-sm">
					<sf:option value="0" label="Акта пока нету" class="form-control input-sm"/>
					
					<sf:options items="${acts}"  itemLabel="number" itemValue="actId" class="form-control input-sm"/>
					
					</sf:select>
						<div class="has-error">
							<form:errors path="actId" class="help-inline" />
						</div>
					</div>
				</div>
		</div>
		
		
		
		
		<div class="row">
				<div class="form-group col-md-12">
					
					<div class="col-md-7">
					<form:input type="hidden" readonly="true" path="totalAmount" itemValue="totalAmount" id="totalAmount1" class="form-control input-sm"/>
						<!--  form:input required='INPUT_TOTAL!' type="number" step="0.01" path="totalAmount" id="totalAmount" 
							value="totalAmount" class="form-control input-sm"  /-->
						<div class="has-error">
							<form:errors path="totalAmount" class="help-inline" />
						</div>
					</div>
				</div>
		</div>
		
		
		<div class="row">
				<center><div class="form-actions">
					
					<input type="submit" value="Сохранить" onclick="addition(); func();" class="btn btn-primary btn-sm" /> или <a
								href="<c:url value='personal-${ownerID}' />">Отменить</a>
						
					
				</div></center>
			</div>
		
			<br>
		</form:form>
		
		</div>
		
		
	
	
		
		</div>
		</div>
	
</body>
</html>
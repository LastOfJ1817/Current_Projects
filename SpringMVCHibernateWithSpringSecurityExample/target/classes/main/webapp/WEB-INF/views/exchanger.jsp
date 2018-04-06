<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="panel panel-default">
		<center><h2>Конвертер валют</h2></center>
		
		<form:form method="POST" modelAttribute="currency" class="form-horizontal">
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="startCurrency">Start Currency</label>
					<div class="col-md-7">
						<form:input  type="text" path="startCurrency" id="startCurrency"
							class="form-control input-sm"  />
							<!--  form:select path="list" items="${currences}" multiple="true" 
							itemValue="currencyType" itemLabel="currencyType" class="form-control input-sm" /-->
						
						
						
							
				<c:forEach items="${currences}" var="currency">
						
						${currency.currencyType}
				</c:forEach>
				
				
							
						<div class="has-error">
						<div class="has-error">
							<form:errors path="startCurrency" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
			
			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-3 control-lable" for="startCurrency">Finish Currency</label>
					<div class="col-md-7">
						<form:input  type="text" path="finishCurrency" id="finishCurrency"
							class="form-control input-sm"  />
						<div class="has-error">
							<form:errors path="finishCurrency" class="help-inline" />
						</div>
					</div>
				</div>
			</div>
		</form:form>
		</div>
</body>
</html>
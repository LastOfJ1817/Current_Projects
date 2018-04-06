<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="hasRole('ADMIN') or hasRole('DBA')">
	<div class="authbar">
		<span>Добро пожаловать, <strong>${loggedinuser}</strong>!
		</span> <span class="floatRight"><a href="<c:url value="/logout" />">Logout</a> OR <a href="<c:url value="/list" />">List of Users</a></span>
	</div>
</sec:authorize>
<sec:authorize access="hasRole('USER')">
	<div class="authbar">
		<span>Добро пожаловать, <strong>${user.firstName}</strong>!
		</span> <span class="floatRight"><a href="<c:url value="/logout" />">Выход</a> : <a href="<c:url value="/personal-${user.id}" />">Личный кабинет</a></span>
	</div>
</sec:authorize>

<sec:authorize access="!hasRole('ADMIN') and !hasRole('USER') and !hasRole('DBA') and !hasRole('MANAGER')">
	<div class="authbar">
		<span>Добро пожаловать, <strong>Гость</strong>!
		</span> <span class="floatRight"><a href="<c:url value="/login" />">Вход</a> : 
			 <a href="<c:url value="/registration" />">Регистрация</a></span>
	</div>
</sec:authorize>





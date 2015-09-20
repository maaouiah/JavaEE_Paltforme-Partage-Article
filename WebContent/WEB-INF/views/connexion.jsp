<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../views/static/header.jsp" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.lang.Langue" var="lang"/>
	<div class="connexion col-xs-12 col-md-7" >
		<ol class="breadcrumb">
		  <li><a href="/"><fmt:message key="app.home"  bundle="${lang}" /></a></li>
		  <li class="active"><fmt:message key="login.title"  bundle="${lang}" /></li>
		</ol>
		<h1><fmt:message key="login.title"  bundle="${lang}" /></h1>
		<form action="<c:url value="/login"/>" method="post" >
			<c:if test="${not empty erreurs['compte']}">
				<span class="bg-danger">${erreurs['compte']}</span><br>
			</c:if>
		  <div class="form-group">
		    <label for="exampleInputEmail1"><fmt:message key="login.label.email"  bundle="${lang}" />: </label>
		    <input type="text" name="email" id="email" class="form-control"/>
			<c:if test="${not empty erreurs['email']}">
				<span class="bg-danger">${erreurs['email']}</span><br>
			</c:if>
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1"><fmt:message key="login.label.password"  bundle="${lang}" />: </label>
		    <input type="password" name="motdepasse" id="motdepasse" class="form-control"/>
			<c:if test="${not empty erreurs['motdepasse']}">
				<span class="bg-danger">${erreurs['motdepasse']}</span><br>
			</c:if>
		  </div>
		  <button type="submit" class="btn btn-default"><fmt:message key="login.button.submit"  bundle="${lang}" /></button>
		</form>
	</div>

<c:import url="../views/static/footer.jsp" />
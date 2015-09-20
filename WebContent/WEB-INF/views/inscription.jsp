<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../views/static/header.jsp" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.lang.Langue" var="lang"/>
	<div class="connexion col-xs-12 col-md-7" >
		<ol class="breadcrumb">
		  <li><a href="/"><fmt:message key="app.home"  bundle="${lang}" /></a></li>
		  <li class="active"><fmt:message key="register.title"  bundle="${lang}" /></a></li>
		</ol>
		<h1><fmt:message key="register.title"  bundle="${lang}" /></h1>

		<form action="<c:url value="inscription"/>"  method="post">
		
		  <div class="form-group">
		    <label><fmt:message key="register.label.nom"  bundle="${lang}" /></label>
		    <input type="text" name="nom" id="nom" class="form-control" />
			<c:if test="${not empty erreurs['nom']}">
				<span class="bg-danger">${erreurs['nom']}</span><br>
			</c:if>
		  </div>

		  <div class="form-group">
		    <label><fmt:message key="register.label.username"  bundle="${lang}" /></label>
		    <input type="text" name="pseudo" id="pseudo" class="form-control" />
			<c:if test="${not empty erreurs['pseudo']}">
				<span class="bg-danger">${erreurs['pseudo']}</span><br>
			</c:if>
		  </div>

		  <div class="form-group">
		    <label><fmt:message key="register.label.email"  bundle="${lang}" /></label>
		    <input type="text" name="email" id="email" class="form-control"/>
			<c:if test="${not empty erreurs['email']}">
				<span class="bg-danger">${erreurs['email']}</span><br>
			</c:if>
		  </div>

		  <div class="form-group">
		    <label><fmt:message key="register.label.password"  bundle="${lang}" /></label>
		    <input type="password" name="motdepasse" id="motdepasse" class="form-control"/>
			<c:if test="${not empty erreurs['email']}">
				<span class="bg-danger">${erreurs['motdepasse']}</span><br>
			</c:if>
		  </div>
		  <button type="submit" class="btn btn-default"><fmt:message key="register.button.submit"  bundle="${lang}" /></button>
		</form>
	</div>
<c:import url="../views/static/footer.jsp" />
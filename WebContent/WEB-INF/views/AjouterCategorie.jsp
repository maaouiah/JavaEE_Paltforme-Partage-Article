<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../views/static/header.jsp" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.lang.Langue" var="lang"/>
	<div>
		<h1><fmt:message key="cat.add"  bundle="${lang}" /></h1>

			<c:if test="${not empty erreurs['ajout']}">
				<div class="bg-danger">${erreurs['ajout']}</div>
			</c:if>
			<c:if test="${not empty succes }">
				<div class="bg-success">${succes}</div>
			</c:if>

		<form action="<c:url value="/addCat"/>" method="post">

		  <div class="form-group">
		    <label><fmt:message key="cat.label.add"  bundle="${lang}" /></label>
		    <input type="text" name="categorie" id="categorie" class="form-control" />
			<c:if test="${not empty erreurs['nom']}">
				<span class="bg-danger">${erreurs['nom']}</span><br>
			</c:if>
		  </div>
		<button type="submit" class="btn btn-success" ><fmt:message key="action.submit"  bundle="${lang}" /></button>

		</form>
	</div>
<c:import url="../views/static/footer.jsp" />
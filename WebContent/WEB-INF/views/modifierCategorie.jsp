<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../views/static/header.jsp" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.lang.Langue" var="lang"/>
	<div>
		<h1><fmt:message key="cat.update"  bundle="${lang}" /></h1>

			<c:if test="${not empty message }">
				<div class="bg-success">${message}</div>
			</c:if>
			<form action="<c:url value="/updateCat"/>" method="post">
				<div class="form-group">
				    <label><fmt:message key="cat.label.add"  bundle="${lang}" /></label>
				    <input type="text" name="categorie" id="categorie" class="form-control"  value="${empty categorie ? '' : categorie.nom }"  />
					<c:if test="${not empty erreurs['nom']}">
						<span class="bg-danger">${erreurs['nom']}</span><br>
					</c:if>
				  </div>
				<input type="hidden" value="${categorie.id }" name="id" id="id" />
				<button type="submit" class="btn btn-success"><fmt:message key="action.update"  bundle="${lang}" /></button>
			</form>
	</div>
<c:import url="../views/static/footer.jsp" />
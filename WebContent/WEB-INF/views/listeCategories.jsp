<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../views/static/header.jsp" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.lang.Langue" var="lang"/>
	<div>
		<h1><fmt:message key="cat.title.list"  bundle="${lang}" /></h1>
				
				<a href="<c:url value="/addCat"/>" class="btn btn-success">
					<span class="glyphicon glyphicon-plus"></span>
					<fmt:message key="cat.add"  bundle="${lang}" />
				</a>
				<br><br>
				<table class="table table-striped tableaustyle" >
				  <tr>
				    <th style="width:70%"><fmt:message key="cat.title"  bundle="${lang}" /></th>
				    <th></th> 
				    <th></th>
				  </tr>
				  <c:forEach items="${ listeCats }" var="unecategorie" varStatus="boucle">
						<tr>
						    <td> <c:out value="${unecategorie.nom}"></c:out></td>
						    <td> <span class="glyphicon glyphicon-pencil"></span><a href="<c:url value="/updateCat?id=${ unecategorie.id }"/>"><fmt:message key="action.update"  bundle="${lang}" /></a></td> 
						    <td> <span class="glyphicon glyphicon-remove"></span> <a href="<c:url value="deleteCat?id=${ unecategorie.id }"/>"> <fmt:message key="action.delete"  bundle="${lang}" /></a></td>
						 </tr>
				  </c:forEach>
				</table>
	</div>
<c:import url="../views/static/footer.jsp" />
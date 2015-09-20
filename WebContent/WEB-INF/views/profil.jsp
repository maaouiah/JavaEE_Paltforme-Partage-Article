<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="../views/static/header.jsp" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.lang.Langue" var="lang"/>
	<div >
		
		<div>
			<h2><c:out value="${ profil.nom }"></c:out></h2>
			<div class="col-xs-12 col-md-3">
				<img src="${pageContext.request.contextPath}/uploads/profil.png"  style="width:80px;" class="img-thumbnail"/>
			</div>
			<div class="col-xs-12 col-md-9">
				<div><strong><fmt:message key="register.label.username"  bundle="${lang}" /> : </strong> ${ profil.pseudo }</div>
				<div><strong><fmt:message key="register.label.nom"  bundle="${lang}" /> : </strong> ${ profil.nom }</div>
				<div><strong><fmt:message key="register.label.email"  bundle="${lang}" /> : </strong> ${ profil.email }</div>
			</div>
			
		</div>
		<br><br><br><br>
		<hr/>
		<div>

			 <table class="table table-striped tableaustyle" >
			 	<tr>
			 		<th><fmt:message key="app.allshare"  bundle="${lang}" /></th>
				    <th style="width:65%"></th>
				    <th></th> 
				 </tr>
			<c:forEach items="${ listeNews }" var="news" varStatus="boucle">
			<tr>
				<td>
					<c:if test="${not empty news.image }">
						<img src="${pageContext.request.contextPath}/uploads/${ news.image }"  style="width:90px;" class="img-thumbnail"/>
					</c:if>
				</td>
				<td>
					<h5 style="color:#4da7b7;"><c:out value="${news.titre}" ></c:out></h5>
					<c:set var="string1" value="${ news.contenu }"/>
					<c:set var="string2" value="${fn:substring( string1 , 0, 100 )} " />
					<c:set var="string3" value="${fn:escapeXml( string2 )} " />
					${ string3 }
				</td>
				<td>
					<a href="<c:url value="/singlenews?id=${news.id}" />" class="btn btn-danger navbar-right"><fmt:message key="news.readmore"  bundle="${lang}" /></a>
				</td>
			</tr>
			</c:forEach>
			</table>
		</div>
		<div class="col-xs-12 col-md-4">
		</div>
	</div>
<c:import url="../views/static/footer.jsp" />
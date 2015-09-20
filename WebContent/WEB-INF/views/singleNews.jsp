<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../views/static/header.jsp" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.lang.Langue" var="lang"/>
	<div class="row">
		<div class="col-xs-12 col-md-8">
			
			<h1>${news.titre}</h1>
			<hr/>
			<div class="row">
				<div class="col-xs-6 col-md-7">
					<c:forEach items="${ news.categories }" var="cat" varStatus="boucle2">
						<span class="badge">${cat.nom}</span>
					</c:forEach>
				</div>
				<div class="col-xs-6 col-md-5">
					<em>Ajouté par : ${ news.user.pseudo} </em>
				</div>
			</div>
			<br>
			<div>
					<c:if test="${not empty news.image }">
					<img  src="${pageContext.request.contextPath}/uploads/${ news.image }" width="70%"> 
					</c:if>
			</div>
			<div class="article">
				<p>
				${news.contenu}
				</p>
			</div>
			

		</div>
		<div class="col-xs-12 col-md-4">
			<h3>Catégories</h3>
			<ul class="list-group">
			<c:forEach items="${ listeCategories }" var="unecategorie" varStatus="boucle">
				<li class="list-group-item">
				<span class="badge">${unecategorie.news.size()}</span>
				<a href="<c:url value="/news/cat?id=${unecategorie.id}" />">${unecategorie.nom}</a>
				</li>
			</c:forEach>
			</ul>
		</div>
	</div>
<c:import url="../views/static/footer.jsp" />
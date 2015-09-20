<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="../views/static/header.jsp" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.lang.Langue" var="lang"/>
	<div>

		<c:if test="${not empty sessionScope.msgAll }">
			<div class="alert alert-success" role="alert" ><c:out value="${sessionScope.msgAll}" /></div>
			<c:remove var="msgAll" scope="session" />
		</c:if>
	</div>
	<div class="row">
		<div class="col-xs-12 col-md-8">
			<c:forEach items="${ listeNews }" var="news" varStatus="boucle">
					<c:if test="${ not empty news.image }" >
					<div class="row unarticle">
						<div class="col-xs-12 col-md-4">
							<img src="${pageContext.request.contextPath}/uploads/${ news.image }"  style="width:190px;" class="img-thumbnail"/>
						</div>
						<div class="col-xs-12 col-md-8">
							<h3>
								<a href="<c:url value="/singlenews?id=${news.id}" />">
									<c:out value="${news.titre}"></c:out>
								</a>
							</h3>
							<div class="row">
								<div class="col-xs-6 col-md-7">
									<c:forEach items="${ news.categories }" var="cat" varStatus="boucle2">
										<span class="badge">${cat.nom}</span>
									</c:forEach>
								</div>
								<div class="col-xs-6 col-md-5">
									<span class="text-warning" >Ajouté par : ${ news.user.pseudo} </span>
								</div>
							</div>
							<hr/>
							<p>
								<c:set var="string1" value="${ news.contenu }"  />
								<c:set var="string2" value="${fn:substring( string1 , 0, 200 )} " />
								<!--<c:set var="string3" value="${fn:escapeXml( string2 )} " />-->
								<!--<c:out value="${ string3 } ..." ></c:out>-->
								<c:out value="${string2}" escapeXml="true"/>
							</p>
						
							<div>
								<a href="<c:url value="/singlenews?id=${news.id}" />" class="btn btn-danger navbar-right">Lire la suite</a>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${ empty news.image }" >
					<div class="row unarticleless">
							<h4>
								<a href="<c:url value="/singlenews?id=${news.id}" />">
									<c:out value="${news.titre}"></c:out>
								</a>
							</h4>
							<div class="row">
									<c:forEach items="${ news.categories }" var="cat" varStatus="boucle2">
										<span class="badge">${cat.nom}</span>
									</c:forEach>
									<span class="text-warning" >Ajouté par : ${ news.user.pseudo} </span>
							</div>
							<br>
							<p>
								<c:set var="string1" value="${ news.contenu }"  />
								<c:set var="string2" value="${fn:substring( string1 , 0, 200 )} " />
								<!--<c:set var="string3" value="${fn:escapeXml( string2 )} " />-->
								<!--<c:out value="${ string3 } ..." ></c:out>-->
								<c:out value="${string2}" escapeXml="true"/>
							</p>
					</div>
				</c:if>
			</c:forEach>
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
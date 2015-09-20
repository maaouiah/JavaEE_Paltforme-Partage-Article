<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../views/static/header.jsp" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.lang.Langue" var="lang"/>
	<form action="<c:url value="/updateNews"/>" method="post" enctype="multipart/form-data"  >
	<div  class="col-xs-12 col-md-9"  >
		<h1><fmt:message key="news.update"  bundle="${lang}" /></h1>

			<c:if test="${not empty message }">
				<div class="bg-success">${message}</div>
			</c:if>
		

			<div class="form-group">
			    <label><fmt:message key="news.label.title"  bundle="${lang}" /></label>
			    <input type="text" name="titre" id="titre" class="form-control"  value="${ news.titre }"  />
				<c:if test="${not empty erreurs['nom']}">
					<span class="bg-danger">${erreurs['titre']}</span><br>
				</c:if>
			 </div>

			 <div class="form-group">
			    <label><fmt:message key="news.label.contenu"  bundle="${lang}" /></label>
			    <textarea class="form-control" rows="10" name="contenu" id="contenu"> ${ news.contenu }</textarea>
			 </div>
				<div class="row">
				  <div class="col-xs-12 col-md-6">
				  	<div class="form-group">
					    <label><fmt:message key="news.label.image"  bundle="${lang}" /></label>
					    <input type="file" name="image" id="image" class="form-control" />
						<c:if test="${not empty erreurs['nom']}">
							<span class="bg-danger">${erreurs['image']}</span><br>
						</c:if>
					 </div>
				  </div>
				  <div class="col-xs-12 col-md-6">
				  	<c:if test="${not empty news.image}">
				  		<img src="${pageContext.request.contextPath}/uploads/${ news.image }"  style="width:190px;" class="img-thumbnail"/>
					</c:if>
				  </div>
				</div>
				<input type="hidden" value="${news.id}" name="id" id="id" />
				<button type="submit" class="btn btn-success"><fmt:message key="action.update"  bundle="${lang}" /></button>
		
	</div>
	<div class="col-xs-12 col-md-3" >
		<br><br>
		<h5><fmt:message key="cat.title"  bundle="${lang}" /></h5>
				<div class="checkbox">
					<ul class="list-group">
						<c:forEach items="${ listeCategories }" var="unecategorie" varStatus="boucle">
							<c:set var="showOrNot" value="false" />
								<c:forEach items="${ news.categories }" var="catchoisie" varStatus="boucle2">
									<c:if test="${unecategorie.nom != 'unknown' }">
										<c:if test="${ catchoisie.nom == unecategorie.nom }">
											<c:set var="showOrNot" value="true" />
								                		<li class="list-group-item unikselectcat"  >&nbsp;&nbsp;&nbsp;&nbsp; <input type="checkbox"  name="categorie"  id="categorie" value="${ unecategorie.id }" checked >   <c:out value="${unecategorie.nom}"  ></c:out></li>
										</c:if>
									</c:if>
								</c:forEach>
									<c:if test="${unecategorie.nom != 'unknown' }">
										<c:if test="${ showOrNot == false }">
											<li class="list-group-item unikselectcat"  >&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"  name="categorie"  id="categorie" value="${ unecategorie.id }" ><c:out value="${unecategorie.nom}" ></c:out></li>
										</c:if>
									</c:if>
						</c:forEach>
					</ul>
				</div>	
		<div class="alert alert-warning">
			<fmt:message key="select.cats.for.news"  bundle="${lang}" />
			<br>
			<a href="<c:url value="addCat"/>" class="btn btn-danger"><fmt:message key="action.add"  bundle="${lang}" /></a>
		</div>
	</div>
	</form>
<c:import url="../views/static/footer.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../views/static/header.jsp" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.lang.Langue" var="lang"/>
	<form action="<c:url value="addNews"/>" method="post" enctype="multipart/form-data"  >
	<div class="col-xs-12 col-md-9" >
		<h1><fmt:message key="news.add"  bundle="${lang}" /></h1>

			<c:if test="${not empty message }">
				<div class="bg-success">${message}</div>
			</c:if>
		

			<div class="form-group">
			    <label><fmt:message key="news.label.title"  bundle="${lang}" /></label>
			    <input type="text" name="titre" id="titre" class="form-control" />
				<c:if test="${not empty erreurs['nom']}">
					<span class="bg-danger">${erreurs['titre']}</span><br>
				</c:if>
			 </div>

			 <div class="form-group">
			    <label><fmt:message key="news.label.contenu"  bundle="${lang}" /></label>
			    <textarea class="form-control" rows="9" name="contenu" id="contenu"></textarea>
			 </div>
			
			<hr/>
			<div class="form-group">
			    <label><fmt:message key="news.label.image"  bundle="${lang}" /></label>
			    <input type="file" name="image" id="image" class="form-control" />
				<c:if test="${not empty erreurs['image']}">
					<span class="bg-danger">${erreurs['image']}</span><br>
				</c:if>
			 </div>
			<button type="submit" class="btn btn-success" ><fmt:message key="action.add"  bundle="${lang}" /></button>
		
	</div>
	<div class="col-xs-12 col-md-3">
		<br><br>
		<h5><fmt:message key="cat.title"  bundle="${lang}" /></h5>
	
		 <div class="checkbox">
		 	<ul class="list-group">
				  <c:forEach items="${ listeCategories }" var="unecategorie" varStatus="boucle">
				  		<c:if test="${unecategorie.nom != 'unknown' }">
						<li class="list-group-item unikselectcat"  >&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox"  name="categorie"  id="categorie" value="${ unecategorie.id }"  >${unecategorie.nom}</li>
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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:import url="../views/static/header.jsp" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="com.lang.Langue" var="lang"/>
	<div>
		<div class="col-xs-12 col-md-12">
			<h1><fmt:message key="news.title.list"  bundle="${lang}" />
			
			
			
			</h1>
			<a href="<c:url value="/addNews"/>" class="btn btn-success ">
				<span class="glyphicon glyphicon-plus"></span>
				<fmt:message key="news.add"  bundle="${lang}" />
			</a>
			&nbsp;&nbsp;
			<a href="<c:url value="/categories"/>" class="btn btn-link navbar-right">
				<span class="glyphicon glyphicon-plus"></span>
				<fmt:message key="cat.title.list"  bundle="${lang}" />
			</a>
			
			<br><br>
			<table class="table table-striped tableaustyle" >
			 	<tr>
				    <th style="width:70%"><fmt:message key="news.title"  bundle="${lang}" /></th>
				    <th></th> 
				    <th></th>
				 </tr>
				<c:forEach items="${ listeNews }" var="news" varStatus="boucle">
					<tr>
					    <td> 
					    	<h5 style="color:#4da7b7;"><c:out value="${news.titre}" ></c:out></h5>
						<c:set var="string1" value="${ news.contenu }"/>
						<c:set var="string2" value="${fn:substring( string1 , 0, 200 )} " />
						<c:set var="string3" value="${fn:escapeXml( string2 )} " />
						${ string3 }
					    </td>
					    <td> <span class="glyphicon glyphicon-pencil"></span>
					    	<a href="<c:url value="/updateNews?id=${ news.id }"/>">
					    		<fmt:message key="action.update"  bundle="${lang}" />
					    	</a>
					    </td> 
					    <td> <span class="glyphicon glyphicon-remove"></span>
					    	<a href="<c:url value="deleteNews?id=${ news.id }"/>">
					    		<fmt:message key="action.delete"  bundle="${lang}" />
					    	</a>
					    </td>
					 </tr>
				</c:forEach>
			</table>
		</div>
	
	</div>
<c:import url="../views/static/footer.jsp" />
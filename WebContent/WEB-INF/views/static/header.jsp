<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />

<html lang="${language}" >
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>${ titre }</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
    <body>
    <fmt:setLocale value="${language}" />
    <fmt:setBundle basename="com.lang.Langue" var="lang"/>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <a class="navbar-brand" href="<c:url value="/index" />"><img src="${pageContext.request.contextPath}/uploads/logo.png" /></a>
        </div>
        <div>
        		
        </div>
            <ul class="nav navbar-nav navbar-right">
            	<c:if test="${empty sessionScope.user}">
                <li class="active"><a href="<c:url value="/login" />"><fmt:message key="app.connect"  bundle="${lang}" /> <span class="sr-only">(current)</span></a></li>
                <li><a href="<c:url value="inscription" />"><fmt:message key="app.register"  bundle="${lang}" /></a></li>
                </c:if>
                <c:if test="${not empty sessionScope.user}">
                <li style="padding-top:15px;"><fmt:message key="app.start"  bundle="${lang}" /> ${ sessionScope.user.nom } | </li>
                <li class="dropdown">
	                    <a  id="dLabel" data-target="#" class="dropdown-toggle" data-toggle="dropdown"  role="button" >
                                    <fmt:message key="app.account"  bundle="${lang}" />
                                    <span class="caret"></span>
                                </a>
    	                    <ul class="dropdown-menu" role="menu" >
    	                        
    	                        <li><a href="<c:url value="/mesArticles" />"><fmt:message key="app.allshare"  bundle="${lang}" /></a></li>
    	                        <li class="bg-danger" ><a href="<c:url value="/addNews" />"><fmt:message key="app.share"  bundle="${lang}" /></a></li>
                                <li><a href="<c:url value="/profil" />"><fmt:message key="app.profil"  bundle="${lang}" /></a></li>
    	                        <li class="divider"></li>
    	                        <li><a href="<c:url value="/logout" />"><fmt:message key="app.logout"  bundle="${lang}" /></a></li>
    	                    </ul>
    	                    
                    </li>
                </c:if>
                <li>
                	<form>
	                <select id="language" name="language" onchange="submit()">
	                   <option value="fr_FR" ${language == 'fr_FR' ? 'selected' : ''}>Français</option>
	                   <option value="en_EN" ${language == 'en_EN' ? 'selected' : ''}>Anglais</option>
	                </select>
		 </form>
                </li>
            </ul>
      </div>
    </nav>
    <div class="container pageme">
  
  
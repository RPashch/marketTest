<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Admin</title>
</head>
<body>
<h1>Welcome</h1>

<h3>Choose page</h3>
<br />
<h3><a href="<c:url value="/companies"/>">Companies</a></h3>
<br />
<h3><a href="<c:url value="/products"/>">Products</a></h3>
<br />
<br />
<a href="<c:url value="/welcome"/>">Back to Welcome page</a>
<br />
<br />
<hr/>
<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="post" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Admin Page - ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout (click)</a>
        </h2>
    </c:if>
</div>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Welcome</title>
</head>
<body>
<h1>Welcome to On-Market</h1>

<p>
    There is a shop that propose You<br/>
    different products from different manufactures.<br/>
</p>

<h3><a href="<c:url value="/catalog"/>">User mode</a></h3>
<hr/>
<h3><a href="<c:url value="/admin"/>">Admin mode</a></h3>

<div class="container">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout (click)</a>
        </h2>
    </c:if>
</div>
</body>
</html>

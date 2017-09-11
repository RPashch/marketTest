<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="" >--%>

    <title>Companies</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h1>Companies</h1>

<br/>
<a href="<c:url value="/admin"/>">Back to Admin page</a>
<br/>
<br/>
<br/>

<c:if test="${!empty listCompanies}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Company Name</th>
            <th width="120">Company Info</th>
            <th width="120">Company Address</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listCompanies}" var="company">
            <tr>
                <td>${company.id}</td>
                <td><a href="<c:url value='/company_info/${company.id}' />"
                       target="_self">${company.name}</a></td>
                <td>${company.description}</td>
                <td>${company.address}</td>
                <td><a href="<c:url value='/edit_company/${company.id}' />">Edit</a></td>
                <td><a href="<c:url value='/remove_company/${company.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add company</h1>

<c:url var="addCompanyAction" value="/save_company"/>

<form:form action="${addCompanyAction}" commandName="company" method="post" acceptCharset="utf-8">
    <table>
        <c:if test="${!empty company.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="false"/>
                    <%--<form:hidden path="id"/>--%>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Company Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
            <td>
                <form:errors path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="description">
                    <spring:message text="Company Info"/>
                </form:label>
            </td>
            <td>
                <form:input path="description"/>
            </td>
            <td>
                <form:errors path="description"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="address">
                    <spring:message text="Company address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address"/>
            </td>
            <td>
                <form:errors path="address"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty company.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Company"/>"/>
                </c:if>
                <c:if test="${empty company.name}">
                    <input type="submit"
                           value="<spring:message text="Add Company"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

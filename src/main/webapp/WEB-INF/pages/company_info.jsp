<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />

    <title>Company info</title>

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
<h1>Company info</h1>

<br/>
<br/>
<table class="tg">
    <tr>
        <th width="80">ID</th>
        <th width="120">Company Name</th>
        <th width="120">Company Info</th>
        <th width="120">Company Address</th>
        <th width="120">All Products</th>
    </tr>
    <tr>
        <td>${company.id}</td>
        <td>${company.name}</td>
        <td>${company.description}</td>
        <td>${company.address}</td>
        <td><a href="<c:url value='/company_info/${company.id}/all' />">Product List</a></td>
    </tr>
</table>
<br />
<br />
<br />
<c:if test="${!empty allProducts}">
    <table class="tg">
        <caption>Product List</caption>
        <tr>
            <th width="80">ID</th>
            <th width="120">Product name</th>
            <th width="120">Producer</th>
            <th width="120">Price</th>
            <th width="120">Description</th>
        </tr>
        <c:forEach items="${allProducts}" var="product">
            <tr>
                <td>${product.id}</td>
                <td><a href="<c:url value='/product_data/${product.id}' />" target="_self">${product.name}</a></td>
                <td>${product.producer.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>

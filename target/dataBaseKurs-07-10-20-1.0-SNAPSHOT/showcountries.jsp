<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 07.10.2020
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/base.css" media="all">
    <title>Countries</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>id</th><th>Name</th><th>Short</th><th>Vendors</th>
        </tr>
        </thead>
        <jsp:useBean id="countryBean" scope="request" type="beans.CountryBean"/>
        <c:forEach items="${countryBean.countries}" var="c">
            <tr>
                <td>${c.id}</td><td>${c.name}</td><td>${c.shortName}</td><td><a href="http://localhost:8081/dataBaseKurs_07_10_20_war_exploded/vendors?id=${c.id}">To Vendor</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 11.10.2020
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/base.css" media="all">
    <title>Vendors</title>
</head>
<body>
    <table>
        <thead>
        <tr>
            <th>id</th><th>Name</th>
        </tr>
        </thead>
        <jsp:useBean id="vendorBean" scope="request" type="beans.VendorBean"/>
        <c:forEach items="${vendorBean.vendors}" var="c">
            <tr>
                <td>${c.id}</td><td>${c.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 07.10.2020
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries</title>
</head>
<body>
    <table>
    <jsp:useBean id="countryBean" scope="request" type="beans.CountryBean"/>
    <c:forEach items="${countryBean.countries}" var="c">
        <tr>
            <td>${c.id}</td><td>${c.name}</td><td>${c.shortName}</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>

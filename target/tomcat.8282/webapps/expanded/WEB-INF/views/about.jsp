<%-- 
    Document   : about
    Created on : Jun 14, 2020, 2:36:34 PM
    Author     : Prasbin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background: red;color: yellow">
        <h1>${name} Project About Us!</h1>
        <ul>
            <c:forEach var="color" items="${colors}">
                <li>${color}</li>
            </c:forEach>
        </ul>
        <h1>Published on ${date}</h1>
    </body>
</html>

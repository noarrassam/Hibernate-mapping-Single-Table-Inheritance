<%-- 
    Document   : Person
    Created on : 20-Apr-2021, 7:45:17 PM
    Author     : noorr
--%>
<%@page import="hiber.Person"%>
<%@page import="hiber.Employee"%>
<%@page import="hiber.Student"%>
<%@page import="java.util.List"%>
<%@page import="hiber.PersonHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <td><a href="index.jsp">Person Info</a></td>
            <td><a href="${pageContext.request.contextPath}/AllPerson"">All People</a></td>            
        </table>
        <br />
        <h3>List of People</h3>
        <br />
        <table border="1">
            <th>ID</th>
            <th>Person Type</th>
            <th>Name</th>
            <th>Address</th>
            <th>Email</th>
            <th>Phone</th>
                <c:forEach items="${requestScope.list}" var="pers">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/GetPerson?id=${pers.id}">${pers.id}</a></td>
                    <td>${pers.getDiscrimativeTYpe()}</td>
                    <td>${pers.name}</td>
                    <td>${pers.address}</td>
                    <td>${pers.email}</td>
                    <td>${pers.phone}</td>
                </tr>
            </c:forEach>                 
        </table>
    </body>
</html>

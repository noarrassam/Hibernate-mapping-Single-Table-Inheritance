<%-- 
    Document   : index
    Created on : 18-Apr-2021, 11:43:56 AM
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

        <title>JSP </title>

    </head>

    <body>

        <h1>Person Info.</h1>
    <body>

        <table border="1">
            <td><a href="index.jsp">Person Info</a></td>
            <td><a href="${pageContext.request.contextPath}/AllPerson">All People</a></td>            
        </table>
        <br />
        <h2>Employee Form</h2>
        <form action="${pageContext.request.contextPath}/EmployeeServ" method="POST">
            <table>
                <tr>
                    <td>ID:</td>
                    <td><input type="number" name="id" value="${person.id}"/></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="${person.name}"/></td>
                </tr>
                <tr>
                    <td>Email Address:</td>
                    <td><input type="text" name="email" value="${person.email}"/></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" value="${person.address}" /></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input type="text" name="phone" value="${person.phone}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="Submit" name="operation" value="Add" />
                        <input type="Submit" name="operation" value="Edit" />
                        <input type="Submit" name="operation" value="Delete" />
                        <input type="Submit" name="operation" value="Search" />
                    </td>
                </tr>                
            </table>
        </form>

        <h2>Student Form</h2>
        <form action="${pageContext.request.contextPath}/StudentServ" method="POST">
            <table>
                <tr>
                    <td>ID:</td>
                    <td><input type="number" name="id" value="${stud.id}"/></td>
                </tr>
                <tr>
                    <td>Name:</td>
                    <td><input type="text" name="name" value="${stud.name}"/></td>
                </tr>
                <tr>
                    <td>Email Address:</td>
                    <td><input type="text" name="email" value="${stud.email}"/></td>
                </tr>
                <tr>
                    <td>Address:</td>
                    <td><input type="text" name="address" value="${stud.address}" /></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input type="text" name="phone" value="${stud.phone}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="Submit" name="operation" value="Add" />
                        <input type="Submit" name="operation" value="Edit" />
                        <input type="Submit" name="operation" value="Delete" />
                        <input type="Submit" name="operation" value="Search" />
                    </td>
                </tr>                
            </table>
        </form>           
    </body>
</html>
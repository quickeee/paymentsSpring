<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sam
  Date: 21.06.2015
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="include/include.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
<root version="2.0" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns="http://www.w3.org/1999/xhtml">
    <output omit-xml-declaration="true"/>
    <directive.page pageEncoding="UTF-8" contentType="text/html; UTF-8"/>
    <spring:url var="authUrl" value="/j_spring_security_check"/>
    <form method="post" class="signin" action="${authUrl}">
        <fieldset>
            <table cellspacing="0">
                <tr>
                    <th>
                        <label for="username">Username</label>
                    </th>
                    <td><input id="username" name="j_username" type="text"></td>
                </tr>
                <tr><th><label for="password">Password</label> </th>
                <td><input id="password" name="j_password" type="password"/></td></tr>
            </table>
            <button type="submit" class="btn btn-primary">Login</button>
            <button type="reset" class="btn btn-primary">Reset</button>
            <input id="remember_me" name="_spring_security_remember_me" type="checkbox"/>
            <label for="remember_me" class="inline">Remember me</label>

        </fieldset>
    </form>
</root>
</body>
</html>

<%@ page language="java"%>
<%@ include file="/WEB-INF/jsp/pages/include/include.jsp" %>
<html>  
  <head>  
      
    <title>
    <tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="left">
    <tr>
        <td colspan="2" align="center">
            <tiles:insertAttribute name="header"></tiles:insertAttribute>
        </td>
    </tr>
    <tr>
        <td>
            <tiles:insertAttribute name="menu"></tiles:insertAttribute>
        </td>
        <td>
            <tiles:insertAttribute name="body"></tiles:insertAttribute>
        </td>
    </tr>
    <tr>
        <td colspan="2"  align="center">
            <tiles:insertAttribute name="footer"></tiles:insertAttribute>
        </td>
    </tr>
</table>
</body>  
</html><%@ page language="java" contentType="text/html; charset=ISO-8859-1"  
    pageEncoding="ISO-8859-1"%>  
  
<html>  
  <head>  
      
    <title>
    <tiles:insertAttribute name="title" ignore="true"></tiles:insertAttribute>
</title>
</head>
<body>
<table border="1" cellpadding="2" cellspacing="2" align="left">
    <tr>
        <td colspan="2" align="center">
            <tiles:insertAttribute name="header"></tiles:insertAttribute>
        </td>
    </tr>
    <tr>
        <td>
            <tiles:insertAttribute name="menu"></tiles:insertAttribute>
        </td>
        <td>
            <tiles:insertAttribute name="body"></tiles:insertAttribute>
        </td>
    </tr>
    <tr>
        <td colspan="2"  align="center">
            <tiles:insertAttribute name="footer"></tiles:insertAttribute>
        </td>
    </tr>
</table>
</body>  
</html>
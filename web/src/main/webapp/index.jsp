<%@ include file="/pages/include/include.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="/pages/include/welcomeHeader.jsp" %>
<%@ include file="/pages/include/linkMainPage.jsp" %>
<form action="/PaymentControl" method="get">
    <table>
        <tr>
            <td>
                <%--<a href="pages/createClient.jsp"><fmt:message key="index.title.create.client"/></a>--%>
            </td>
        </tr>
        <tr>
            <td>
                <a href="PaymentControl?page=list_clients"><fmt:message key="index.title.list.clients"/></a>
            </td>
        </tr>
    </table>
</body>
</html>

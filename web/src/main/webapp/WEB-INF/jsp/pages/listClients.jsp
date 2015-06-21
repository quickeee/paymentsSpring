<%@ include file="/pages/include/include.jsp" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="/pages/include/welcomeHeader.jsp" %>
<fieldset>
    <legend><fmt:message key="list.client.title.group"/></legend>
    <table>
        <thead>
        <th><fmt:message key="list.client.title.id"/></th>
        <th><fmt:message key="list.client.title.firstname"/></th>
        <th><fmt:message key="list.client.title.lastname"/></th>
        <th><fmt:message key="list.client.title.role"/></th>
        <th><fmt:message key="list.client.title.bankAccountID"/></th>
        </thead>
        <c:forEach var="client" items="${clients}">
            <tr>
                <td><a href="/PaymentControl?page=control_client&login=${client.login}">${client.login}</a></td>
                <td>${client.firstName}</td>
                <td>${client.lastName}</td>
                <td>${client.role}</td>
                <td>${client.bankAccountID} </td>
            </tr>
        </c:forEach></table>
</fieldset>
</body>
</html>
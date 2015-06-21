<%@ include file="/pages/include/include.jsp" %>
<html>
<head>
    <title><fmt:message key="create.client.title.page"/></title>
</head>
<body>
<fieldset>
    <legend><fmt:message key="create.client.title.group"/></legend>
    <form action="/PaymentControl" method="get">
        <input type="hidden" name="page" value="CREATE_CLIENT">
        <table width="400" align="justify">
            <tr align="right">
                <td>
                    <fmt:message key="create.client.title.caption.login"/><input type="text" name="login">
                </td>
            </tr>
            <tr align="right">
                <td>
                    <fmt:message key="create.client.title.caption.pass"/><input type="password" name="password">
                </td>
            </tr>
            <tr align="right">
                <td>
                    <fmt:message key="create.client.title.caption.firstname"/><input type="text" name="firstName">
                </td>
            </tr>
            <tr align="right">
                <td>
                    <fmt:message key="create.client.title.caption.lastname"/><input type="text" name="lastName">
                </td>
            </tr>
            <tr align="right">
                <td colspan="4">
                    <input type="submit" value=<fmt:message key="create.client.title.button.create"/>>
                </td>
            </tr>
        </table>
    </form>
</fieldset>

</body>
</html>
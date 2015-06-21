<%@ include file="/pages/include/include.jsp" %>
<html>
<head>
    <title><fmt:message key="login.title.username"/></title>
</head>
<body>
<fieldset>
    <legend><fmt:message key="login.title.username"/></legend>
    <form action="/PaymentControl" method="post">
        <input type="hidden" name="page" value="login_user">
        <table>
            <tr>
                <td>
                    <div><input type="text" name="login" value=""/><fmt:message key="login.title.username"/></div>
                    <br>
                    <div><input type="password" name="password" value=""/><fmt:message key="login.title.password"/>
                    </div>
                    <br>
                    <div><input type="submit" value=<fmt:message key="login.title.button.login"/>></div>
                </td>
            </tr>
            <tr>
                <td>
                    <a href="createClient.jsp"><fmt:message key="login.title.create.client"/></a>
                </td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>

<%@ include file="WEB-INF/jsp/pages/include/include.jsp"%>
<html>
<head>
    <title></title>
</head>
<body>
<%@ include file="WEB-INF/jsp/pages/include/welcomeHeader.jsp" %>
<%@ include file="WEB-INF/jsp/pages/include/linkMainPage.jsp" %>
<form action="" method="get">
    <table>
        <tr>
            <td>
                <%--<a href="pages/createClient.jsp"><fmt:message key="index.title.create.client"/></a>--%>
            </td>
        </tr>
        <tr>
            <td>
                <a href="/listClient.do"><fmt:message key="index.title.list.clients"/></a>
            </td>
        </tr>
    </table>
    </form>
</body>
</html>

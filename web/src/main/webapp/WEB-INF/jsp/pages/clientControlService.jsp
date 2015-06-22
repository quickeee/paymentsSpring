<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="include/include.jsp" %>
<html>
<head>
    <title></title>
    <style type="text/css">
        table {
            border: solid;
        }

        td, th {
            border-top: 2px double #ccc;
            border-left: 2px double #ccc;
            border-bottom: 2px double #ccc;
            border-right: 2px double #ccc;

        }
    </style>
</head>
<body>
<%@ include file="include/welcomeHeader.jsp" %>
<fieldset>
    <legend><fmt:message key="client.control.service.controlClientTitle"/> <b><%=username%>
    </b></legend>
    <table valign="top" align="justify">
        <tr>
            <td width="70%" valign="top" align="justify">
                <table width="100%">
                    <thead>
                    <th><fmt:message key="client.control.service.userInfo"/></th>
                    </thead>
                    <tr>
                        <td><fmt:message key="client.control.service.userInfo.login"/></td>
                        <td><fmt:message key="client.control.service.userInfo.firstName"/></td>
                        <td><fmt:message key="client.control.service.userInfo.lastName"/></td>
                        <td><fmt:message key="client.control.service.userInfo.bankAccountID"/></td>
                    </tr>
                    <tr>
                        <td>
                            ${clientBean.login}
                        </td>
                        <td>
                            ${clientBean.firstName}
                        </td>
                        <td>
                            ${clientBean.lastName}
                        </td>
                        <td>
                            ${clientBean.bankAccountID}
                        </td>
                    </tr>
                </table>
                <br>
                <table width="100%">
                    <thead>
                    <th colspan="5"><fmt:message key="client.control.service.bankInfo"/></th>
                    </thead>
                    <tr>
                        <td><fmt:message key="client.control.service.bankInfo.bankAccountID"/></td>
                        <td><fmt:message key="client.control.service.bankInfo.sum"/></td>
                        <td><fmt:message key="client.control.service.bankInfo.blocked"/></td>
                        <td><fmt:message key="client.control.service.bankInfo.creditCardID"/></td>
                    </tr>
                    <tr>
                        <td>
                            ${clientBean.bankAccountID}
                        </td>
                        <td>
                            ${clientBean.sum}
                        </td>
                         <td>
                            ${clientBean.blocked}
                        </td>
                        <td>
                            ${clientBean.creditCardID}
                        </td>
                    </tr>
                </table>
            </td>
            <td width="30%" valign="top" align="justify">
                <table width="100%">
                    <thead>
                    <th colspan="3"><fmt:message key="client.control.service.orderList"/></th>
                    </thead>

                    <tr>
                        <td><b><fmt:message key="client.control.service.orderList.id"/></b></td>
                        <td><b><fmt:message key="client.control.service.orderList.sum"/></b></td>
                        <td><b><fmt:message key="client.control.service.orderList.paid"/></b></td>

                    </tr>

                    <c:forEach var="order" items="${clientBean.orderList}">
                        <tr>
                            <td>
                                    ${order.id}
                            </td>
                            <td>
                                    ${order.sum}
                            </td>
                            <td>
                                    ${order.paid}
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </td>
        </tr>
        <tr>
            <td valign="top" align="justify">
                <table width="100%">
                    <thead>
                    <th colspan="2"><fmt:message key="client.control.service.availableEvents"/></th>
                    </thead>
                    <tr>
                        <td>
                            <a href="/blockBankAccount.do?bankAccountID=${clientBean.bankAccountID}&blocked=${!clientBean.blocked}"><c:choose><c:when
                                    test="${clientBean.blocked}"><fmt:message
                                    key="client.control.service.enableEvents.unblock"/></c:when><c:otherwise><fmt:message
                                    key="client.control.service.enableEvents.block"/></c:otherwise></c:choose></a>
                        </td>
                        <td>
                            <form action="/addOrder.do" method="get">
                                <%--<input type="hidden" name="page" value="CREATE_ORDER">--%>
                                <%--<input type="hidden" name="login" value="${client.login}">--%>
                                <input type="hidden" name="bankAccountID" value="${clientBean.bankAccountID}">
                                <table width="100%">
                                    <tr>
                                        <td><fmt:message key="client.control.service.enableEvents.createOrder"/>
                                        <td>
                                            <label for="sum"><fmt:message
                                                    key="client.control.service.enableEvents.createOrder.sum"/></label>

                                            <input type="number" id="sum" name="sum" value="0"/>
                                        </td>
                                        <td align="right" colspan="2">
                                            <input type="submit" value=<fmt:message
                                                    key="client.control.service.enableEvents.createOrder.create"/>>
                                        </td>
                                    </tr>

                                </table>

                            </form>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</fieldset>

</body>
</html>

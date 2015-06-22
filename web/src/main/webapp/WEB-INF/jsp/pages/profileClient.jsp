<%@ include file="include/include.jsp" %>
<html>
<head>
    <title></title>
    <style type="text/css">
        table {
            border: solid;
            /*border-collapse: collapse;*/
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
<%@ include file="include/linkMainPage.jsp" %>
<fieldset>
    <legend><fmt:message key="info.client.title.group"/> <b><%=username%>
    </b></legend>
    <table width="800">
        <thead>
        <th><fmt:message key="info.client.title.id"/></th>
        <th><fmt:message key="info.client.title.firstname"/></th>
        <th><fmt:message key="info.client.title.lastname"/></th>
        <th><fmt:message key="info.client.title.bankAccountID"/></th>
        </thead>

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
    <table width="800" , align="justify">
        <thead>
        <th><fmt:message key="create.client.title.caption.bankAccountID"/></th>
        <th><fmt:message key="create.client.title.caption.sum"/></th>
        <th><fmt:message key="create.client.title.caption.blocked"/></th>
        <th><fmt:message key="create.client.title.caption.creditCardID"/></th>
        </thead>
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
    <br>
    <table width="800" , align="justify">
        <thead>
        <th>ID</th>
        <th>sum</th>
        <th>paid</th>
        </thead>
        <c:forEach var="order" items="${clientBean.orderList}">
            <tr>
                <td>
                        ${order.id}
                </td>
                <td>
                        ${order.sum}
                </td>
                <td>

                    <c:if test="${order.paid}">
                        paid
                    </c:if>
                    <c:if test="${!order.paid}">
                        <a href="/payOrder.do?bankAccountID=${clientBean.bankAccountID}&id=${order.id}">Pay</a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <table width="800" , align="justify">
        <thead>
        <th><fmt:message key="create.client.title.caption.available.actions"/></th>
        </thead>
        <tr>
            <td>
                <a href="/blockBankAccount.do?bankAccountID=${clientBean.bankAccountID}&blocked=true"><fmt:message
                        key="create.client.title.caption.available.actions.block"/></a>
            </td>
        </tr>
        <tr>
            <td>
                <form action="/transferMoney.do" method="get">
                    <%--<a href="/PaymentControl?page=TRANSFER_MONEY&id=${client.bankAccountID}"><fmt:message--%>
                    <%--key="create.client.title.caption.available.actions.transfer"/></a>--%>
                    <%--<input type="hidden" name="page" value="TRANSFER_MONEY">--%>
                    <input type="hidden" name="id" value="${clientBean.bankAccountID}">
                    <table width="70%">
                        <tr>
                            <th colspan="2"><fmt:message
                                    key="create.client.title.caption.available.actions.transfer"/></th>
                        </tr>

                        <tr>
                            <td>
                                <label for="IDList"><fmt:message
                                        key="create.client.title.caption.available.actions.transfer.dstAccountID"/></label>
                                <br>
                                <input name="bankAccountTransferID" list="IDList">
                                <datalist id="IDList">
                                    <c:forEach var="bankAccountID" items="${bankAccountIDTransferList}">
                                        <option>${bankAccountID}</option>
                                    </c:forEach>
                                </datalist>
                            </td>
                            <td>
                                <label for="transfSum"><fmt:message
                                        key="create.client.title.caption.available.actions.transfer.sum"/></label>
                                <br>
                                <input type="number" id="transfSum" name="bankAccountTransferSum"
                                       max=${clientBean.sum} value="0"/>
                            </td>
                        </tr>
                        <tfoot>
                        <tr>
                            <td align="right" colspan="2">
                                <input type="submit" value=<fmt:message
                                        key="create.client.title.caption.available.actions.transfer"/>>
                            </td>
                        </tr>
                        </tfoot>

                    </table>

                </form>
            </td>
        </tr>
    </table>
</fieldset>

</body>
</html>

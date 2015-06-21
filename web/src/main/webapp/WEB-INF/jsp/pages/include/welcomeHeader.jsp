<p>Welcome, <%=username%></p>
<%@ page language="java" %>
<%
    String profile="";
    String root = "Guest";
    String logout = "logout";
    int role = 0;
    if (session.getAttribute("role") != null) {
        role = (Integer) session.getAttribute("role");
    }
    if (role == 1){
        profile = "<a href=\"/PaymentControl?page=PROFILE_CLIENT\">profile</a>";
        root = "Client";
        logout = "<a href=\"/PaymentControl?page=LOGOUT_USER\">logout</a>";
    }else{
        if (role == 0) {
            logout = "<a href=\"/PaymentControl?page=LOGOUT_USER\">logout</a>";
            profile = "<a href=\"PaymentControl?page=list_clients\">client list</a>";
            root = "Admin";
        } else{
            logout = "<a href=\"/pages/createClient.jsp\">registration</a>";
            root = "Guest";
        }
    }
%>

<table align="right">
    <tr bgcolor="white">
        <td>
            Profile detail, <%=profile%>
        </td>
        <td>
            Role, <%=root%>
        </td>
        <td>
            <%=logout%>
        </td>
    </tr>
</table>

package by.academy.it.navigation.commands;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.academy.it.resources.constant.Constants.*;

public class LogoutUserCommand implements Command {
    @Override
    public String execCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute(PARAM_SESSION_USER_LAST_NAME) != null) {
            session.removeAttribute(PARAM_SESSION_USER_LAST_NAME);
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PAGE_MAIN);
        requestDispatcher.forward(request, response);
        return PAGE_LOGIN;
    }
}

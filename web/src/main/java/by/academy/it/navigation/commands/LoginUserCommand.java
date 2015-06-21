package by.academy.it.navigation.commands;

//import by.academy.it.pvt.news.entity.Author;
//import by.pvt.news.service.AuthorService;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.Client;
import by.academy.it.service.impl.ClientServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static by.academy.it.resources.constant.Constants.*;

public class LoginUserCommand implements Command {
    @Override
    public String execCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        if (session == null || session.getAttribute(PARAM_SESSION_USER_LAST_NAME) == null) {
            String uriPath = request.getRequestURI().substring(request.getContextPath().length());

//            if(PAGE_LOGIN.equals(uriPath)){
//                session.setAttribute(PARAM_SESSION_USER_LAST_NAME, );
//                filterChain.doFilter(servletRequest, servletResponse);
//            }

            String login = request.getParameter(PARAM_CLIENT_LOGIN);
            String pass = request.getParameter(PARAM_CLIENT_PASSWORD);

            ClientServiceImpl clientService = new ClientServiceImpl();

            try {
                if (clientService.login(login, pass)) {
                    Client client = clientService.getClientByLogin(login);
                    session.setAttribute(PARAM_SESSION_USER_LAST_NAME, client.getLastName());
                    session.setAttribute(PARAM_SESSION_USER_LOGIN, client.getLogin());

                    session.setAttribute(PARAM_SESSION_ROLE_USER, client.getRole());


//                session.setAttribute(PARAM_CLIENT_BANK_ACCOUNT_ID, client.getBankAccountID());
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher(PAGE_MAIN);
                    requestDispatcher.forward(request, response);
                    return PAGE_MAIN;
                }
            } catch (DaoException e) {

                e.printStackTrace();

            }
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PAGE_LOGIN);
            requestDispatcher.forward(request, response);
            return PAGE_LOGIN;
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PAGE_MAIN);
        requestDispatcher.forward(request, response);
        return PAGE_MAIN;
    }
}

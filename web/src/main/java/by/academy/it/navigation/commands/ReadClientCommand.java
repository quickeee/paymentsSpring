package by.academy.it.navigation.commands;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.Client;
import by.academy.it.service.impl.ClientServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.academy.it.resources.constant.Constants.*;

/**
 * Created by Sam on 04.05.2015.
 */
public class ReadClientCommand implements Command {
    @Override
    public String execCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String login = request.getParameter(PARAM_CLIENT_LOGIN);
            ClientServiceImpl clientService = new ClientServiceImpl();
            Client client = clientService.getClientByLogin(login);

            request.setAttribute(PARAM_CLIENT_ITEM, client);

        }catch (DaoException e){
            e.printStackTrace();
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(PAGE_CLIENT_INFO);
        requestDispatcher.forward(request, response);

        return PAGE_CLIENT_INFO;
    }
}

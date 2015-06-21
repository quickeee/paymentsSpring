
package by.academy.it.controller;
/*
import by.academy.it.navigation.CommandFactory;
import by.academy.it.navigation.commands.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.academy.it.resources.constant.Constants.PARAM_PAGE;

public class PaymentController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performAction(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        performAction(request, response);
    }

    private void performAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = request.getParameter(PARAM_PAGE);
        if (page != null) {
            Command command = CommandFactory.getCommand(page);
            String nextPage = command.execCommand(request, response);
//            RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
//            requestDispatcher.forward(request, response);
        } else {
            throw new IllegalArgumentException("Param page is empty!");
        }
    }

}
*/

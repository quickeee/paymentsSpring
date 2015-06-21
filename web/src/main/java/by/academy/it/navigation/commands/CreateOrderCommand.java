package by.academy.it.navigation.commands;

import by.academy.it.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.academy.it.resources.constant.Constants.*;

public class CreateOrderCommand implements Command {
    @Override
    public String execCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bankAccountID = Integer.parseInt(request.getParameter(PARAM_ORDER_BANK_ACCOUNT_ID));
        double sum = Double.parseDouble(request.getParameter(PARAM_ORDER_SUM));

        OrderServiceImpl orderService = new OrderServiceImpl();
        int orderID = orderService.createOrder(bankAccountID, sum);

        if (orderID != INVALID_PARAM) {

            try {
//                RequestDispatcher requestDispatcher = request.getRequestDispatcher(PAGE_CONTROL_SERVICE_CLIENT);
                String login = request.getParameter(PARAM_CLIENT_LOGIN);
                String httpURL ="/PaymentControl?page=control_client&login=" + login;
                response.sendRedirect(httpURL);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return PAGE_MAIN;
    }
}

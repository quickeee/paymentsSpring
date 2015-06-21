package by.academy.it.navigation.commands;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.BankAccount;
import by.academy.it.entity.Client;
import by.academy.it.entity.Order;
import by.academy.it.service.impl.BankAccountServiceImpl;
import by.academy.it.service.impl.ClientServiceImpl;
import by.academy.it.service.impl.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.academy.it.resources.constant.Constants.*;

public class ControlClientCommand implements Command {
    @Override
    public String execCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter(PARAM_CLIENT_LOGIN);
        ClientServiceImpl clientService = new ClientServiceImpl();

        try {
            Client client = clientService.getClientByLogin(login);

            BankAccountServiceImpl bankAccountService = new BankAccountServiceImpl();

            BankAccount bankAccount = bankAccountService.getBankAccount(client.getBankAccountID());

            OrderServiceImpl orderService = new OrderServiceImpl();
            List<Order> orderList = orderService.getOrderListByBankAccount(bankAccount.getId());


            request.setAttribute(PARAM_CLIENT_ITEM, client);
            request.setAttribute(PARAM_BANK_ACCOUNT_ITEM, bankAccount);
            request.setAttribute(PARAM_ORDER_LIST, orderList);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PAGE_CONTROL_SERVICE_CLIENT);
            requestDispatcher.forward(request, response);
//                response.sendRedirect(PAGE_LIST_CLIENTS);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return PAGE_MAIN;
    }
}

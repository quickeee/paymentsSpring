package by.academy.it.navigation.commands;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.Client;
import by.academy.it.service.impl.BankAccountServiceImpl;
import by.academy.it.service.impl.ClientServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.academy.it.resources.constant.Constants.*;


public class BlockCreditCardCommand implements Command {
    @Override
    public String execCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session != null && session.getAttribute(PARAM_SESSION_USER_LAST_NAME) != null) {
            int role = (Integer) session.getAttribute(PARAM_SESSION_ROLE_USER);
//            String login = (String)session.getAttribute(PARAM_SESSION_USER_LOGIN);
//            ClientService clientService = new ClientService();
//            Client client = clientService.getClient(login);
            BankAccountServiceImpl bankAccountService = new BankAccountServiceImpl();
            int bankAccountID = Integer.parseInt(request.getParameter(PARAM_CLIENT_BANK_ACCOUNT_ID));
            boolean blockCreditCard = Boolean.parseBoolean(request.getParameter(PARAM_BANK_ACCOUNT_BLOCKED));


            ClientServiceImpl clientService = new ClientServiceImpl();
            Client client = null;
            try {
                client = clientService.getClientByBankAccountID(bankAccountID);

                bankAccountService.blockBankAccount(client.getBankAccountID(), blockCreditCard);
            } catch (DaoException e) {
                e.printStackTrace();
            }

            RequestDispatcher requestDispatcher = null;
            if (role == ROLE_ADMINISTRATOR){
                requestDispatcher = request.getRequestDispatcher("/PaymentControl?page=control_client&login=" + client.getLogin());
            }else{
                requestDispatcher = request.getRequestDispatcher("/PaymentControl?page=PROFILE_CLIENT");
            }
            request.setAttribute(PARAM_CLIENT_ITEM, client);
            requestDispatcher.forward(request, response);
        }
        return PAGE_CLIENT_INFO;
    }
}

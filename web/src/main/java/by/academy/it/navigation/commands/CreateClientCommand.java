package by.academy.it.navigation.commands;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.Client;
import by.academy.it.service.impl.BankAccountServiceImpl;
import by.academy.it.service.impl.ClientServiceImpl;
import by.academy.it.service.impl.CreditCardServiceImpl;
import by.academy.it.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import static by.academy.it.resources.constant.Constants.*;

public class CreateClientCommand implements Command {
    private Transaction transaction = null;

    @Override
    public String execCommand(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            Session utilSession = HibernateUtil.getHibernateUtil().getSession();
            transaction = utilSession.beginTransaction();
            String login = request.getParameter(PARAM_CLIENT_LOGIN);
            String password = request.getParameter(PARAM_CLIENT_PASSWORD);
            String firstName = request.getParameter(PARAM_CLIENT_FIRST_NAME);
            String lastName = request.getParameter(PARAM_CLIENT_LAST_NAME);

            if (isValidParams(login, password, firstName, lastName)) {
                CreditCardServiceImpl creditCardService = new CreditCardServiceImpl();
                int creditCardID = creditCardService.create();

//        int creditCardID = Integer.parseInt(request.getParameter(PARAM_BANK_ACCOUNT_CREDIT_CARD_ID));

//                if (creditCardID != INVALID_PARAM) {

                BankAccountServiceImpl bankAccountService = new BankAccountServiceImpl();
                int bankAccountID = bankAccountService.create(false, 0, creditCardID);
//                if (bankAccountID != INVALID_PARAM) {
                ClientServiceImpl clientService = new ClientServiceImpl();
                int clientID = clientService.create(login, password, firstName, lastName, bankAccountID);

//                    if (clientID == INVALID_PARAM) {
//                        bankAccountService.deleteBankAccount(bankAccountID);
//                        creditCardService.delete(creditCardID);
//                    }

                List<Client> clients = clientService.getAll();
                request.setAttribute(PARAM_CLIENTS, clients);
//                } else {
//                    creditCardService.delete(creditCardID);
//                }
//                }
            }
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        try {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher(PAGE_LIST_CLIENTS);
            requestDispatcher.forward(request, response);
            response.sendRedirect(PAGE_LIST_CLIENTS);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PAGE_MAIN;
    }

    private boolean isValidParams(String login, String pass, String firstName, String lastName) {
        return login != null && pass != null && firstName != null && lastName != null;
    }

}

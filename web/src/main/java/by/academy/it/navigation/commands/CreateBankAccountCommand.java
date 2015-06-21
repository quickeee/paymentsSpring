package by.academy.it.navigation.commands;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.service.impl.BankAccountServiceImpl;
import by.academy.it.service.impl.CreditCardServiceImpl;
import by.academy.it.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static by.academy.it.resources.constant.Constants.*;

/**
 * Created by Sam on 06.05.2015.
 */
public class CreateBankAccountCommand implements Command {

    private Transaction transaction = null;

    @Override
    public String execCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            Session utilSession = HibernateUtil.getHibernateUtil().getSession();
            transaction = utilSession.beginTransaction();


            CreditCardServiceImpl creditCardService = new CreditCardServiceImpl();
            int creditCardID = creditCardService.create();

//        int creditCardID = Integer.parseInt(request.getParameter(PARAM_BANK_ACCOUNT_CREDIT_CARD_ID));

//            if (creditCardID != INVALID_PARAM) {

            BankAccountServiceImpl bankAccountService = new BankAccountServiceImpl();
//                int bankAccountID =
            bankAccountService.create(false, 0, creditCardID);
//                if (bankAccountID == INVALID_PARAM) {
//                    creditCardService.delete(creditCardID);
//                }
//            }
        } catch (DaoException e) {
            transaction.rollback();
            e.printStackTrace();
        }
        response.sendRedirect(PAGE_LIST_CLIENTS);
        return PAGE_MAIN;
    }
}

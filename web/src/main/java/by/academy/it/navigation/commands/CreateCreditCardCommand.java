package by.academy.it.navigation.commands;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.service.impl.CreditCardServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static by.academy.it.resources.constant.Constants.*;

public class CreateCreditCardCommand implements Command{
    @Override
    public String execCommand(HttpServletRequest request, HttpServletResponse response) {
//        int creditCardPinCode = Integer.parseInt(request.getParameter(PARAM_CREDIT_CARD_PIN_CODE));

        try {
            CreditCardServiceImpl creditCardService = new CreditCardServiceImpl();
            int creditCardID = creditCardService.create();
        }catch (DaoException e){
            e.printStackTrace();
        }
        return PAGE_MAIN;
    }
}

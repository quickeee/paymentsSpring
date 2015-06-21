package by.academy.it.dao;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.CreditCard;

/**
 * Created by Sam on 03.05.2015.
 */
public interface ICreditCardDao extends Dao<CreditCard>{
    int create(CreditCard creditCard) throws DaoException;
//    void delete(int creditCardID);
    CreditCard getCreditCardByBankAccountID(int bankAccountID) throws DaoException;
}

package by.academy.it.service;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.BankAccount;
import by.academy.it.entity.Order;

import java.util.List;

/**
 * Created by sam on 19.06.2015.
 */
public interface IBankAccountService {
    int addBankAccount(boolean blocked, double sum, int creditCardID);

    BankAccount getBankAccount(int bankAccountID);

    void blockBankAccount(int bankAccountID, boolean isBlock);

    void transferMoney(int dstBankAccountID, int srcBankAccountID, double transferSum);

//    void payOrder(Order order);

    void payOrder(int bankAccountID, int orderID);

    List<Integer> getBankAccountIDList();

    List<BankAccount> getAll();
}

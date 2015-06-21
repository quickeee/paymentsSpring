package by.academy.it.dao;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.BankAccount;
import by.academy.it.entity.Order;

import java.util.List;

public interface IBankAccountDao extends Dao<BankAccount> {
    int create(BankAccount bankAccount) throws DaoException;
//    BankAccount read(int bankAccountID);
//    void update(BankAccount bankAccount);
//    void delete(int bankAccountID);
    void blockCreditCard(int bankAccountID, boolean isBlock) throws DaoException;
    void transferMoney(int bankAccountID, double transferSum) throws DaoException;
    List<Integer> getBankAccountIDList() throws DaoException;
//    List<BankAccount> getAll();
    void payOrder(Order order) throws DaoException;
}






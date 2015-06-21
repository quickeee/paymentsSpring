package by.academy.it.dao;

import by.academy.it.dao.exceptions.DaoException;

public interface IUserDao {

    boolean loginUser(String login, String password) throws DaoException;
    boolean logoutUser();
//    void blockCreditCard(int bankAccountID, boolean isBlock);
}

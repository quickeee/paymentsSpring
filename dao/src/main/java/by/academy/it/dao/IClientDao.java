package by.academy.it.dao;

import by.academy.it.dao.exceptions.DaoException;
import  by.academy.it.entity.*;

import java.util.List;

public interface IClientDao extends IUserDao, Dao<Client> {
    int create(Client client) throws DaoException;
//    Client read(String login);
    Client getClientByBankAccountID(int bankAccountID) throws DaoException;
    Client getClientByLogin(String login) throws DaoException;
//    void update(Client client);
//    void delete(String login);
//    boolean payOrder(int orderID);

//    List<Client> getAll();
}

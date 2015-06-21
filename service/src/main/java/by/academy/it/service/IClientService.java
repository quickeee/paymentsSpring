package by.academy.it.service;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.Client;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sam on 19.06.2015.
 */

public interface IClientService {

    int addClient(String login, String password, String firstName, String lastName);

    Client getClientByLogin(String login);

    Client getClientByBankAccountID(int bankAccountID);

//    boolean login(String login, String password);

    List<Client> getAll();
}

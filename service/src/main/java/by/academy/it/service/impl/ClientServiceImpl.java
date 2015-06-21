package by.academy.it.service.impl;

//import by.academy.it.dao.impl.ClientDao;
import by.academy.it.dao.IBankAccountDao;
import by.academy.it.dao.IClientDao;
//import by.academy.it.dao.impl.JDBCClientDAOImpl;
import by.academy.it.dao.ICreditCardDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.BankAccount;
import by.academy.it.entity.Client;
import by.academy.it.entity.CreditCard;
import by.academy.it.entity.UserRole;
import by.academy.it.service.IClientService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    private static Logger logger = Logger.getLogger(ClientServiceImpl.class);

    @Autowired
    private IBankAccountDao bankAccountDAO;// = new BankAccountDao();

    @Autowired
    private IClientDao clientDAO;// = new ClientDao();

    @Autowired
    private ICreditCardDao creditCardDao;// = new BankAccountDao();

    @Autowired
    TransactionTemplate transactionTemplate;

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int addClient(final String login, final String password, final String firstName, final String lastName  ) {

        getTransactionTemplate().execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {

                try {
                    int creditCardID = creditCardDao.create(new CreditCard());
                    logger.info("addClient 1/3(+)");
                    int bankAccountID = bankAccountDAO.create(new BankAccount(0, false, creditCardID));
                    logger.info("addClient 2/3(+)");
                    int clientID = clientDAO.create(new Client(login, password, firstName, lastName, UserRole.CLIENT, bankAccountID));
                    logger.info("addClient 3/3(+)");
                    return clientID;
                } catch (DaoException e) {
                    logger.error("Error addClient");
                    e.printStackTrace();
                }
                return null;
            }
        });

        return 0;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Client getClientByLogin(String login) {
        try {
            Client client = clientDAO.getClientByLogin(login);
            logger.info("getClientByLogin (+)");
            return client;
        } catch (DaoException e) {
            logger.error("Error getClientByLogin");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Client getClientByBankAccountID(int bankAccountID) {
        try {
            Client client = clientDAO.getClientByBankAccountID(bankAccountID);
            logger.info("getClientByBankAccountID (+)");
            return client;
        } catch (DaoException e) {
            logger.error("Error getClientByBankAccountID");
            e.printStackTrace();
        }
        return null;
    }

/*    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public boolean login(String login, String password) {
        try {
            boolean isLogin = clientDAO.loginUser(login, password);
            logger.info("login (+)");
            return isLogin;
        } catch (DaoException e) {
            logger.error("Error login");
            e.printStackTrace();
        }
        return false;
    }*/


  /*  public void deleteClient(String login){
        clientDAO.delete(login);
    }*/

    @Override
    public List<Client> getAll() {
        try {
            List<Client> clientList = clientDAO.getAll();
            logger.info("getAll (+)");
            return clientList;
        } catch (DaoException e) {
            logger.error("Error getAll");
            e.printStackTrace();
        }
        return null;
    }

}

package by.academy.it.service.impl;

import by.academy.it.dao.IOrderDao;
import by.academy.it.dao.impl.BankAccountDao;
import by.academy.it.dao.IBankAccountDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.BankAccount;
import by.academy.it.entity.Order;
import by.academy.it.service.IBankAccountService;
import by.academy.it.service.IOrderService;
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
public class BankAccountServiceImpl implements IBankAccountService {

    private static Logger logger = Logger.getLogger(BankAccountServiceImpl.class);

    @Autowired
    private IBankAccountDao bankAccountDAO;// = new BankAccountDao();

    @Autowired
    private IOrderDao orderDao;

//    @Autowired
    TransactionTemplate transactionTemplate;

    public TransactionTemplate getTransactionTemplate() {
        return transactionTemplate;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int addBankAccount(boolean blocked, double sum, int creditCardID) {
        try {
            int bankAccountID = bankAccountDAO.create(new BankAccount(sum, blocked, creditCardID));
            logger.info("addBankAccount (+)");
            return bankAccountID;
        } catch (DaoException e) {
            logger.error("Error addBankAccount");
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public BankAccount getBankAccount(int bankAccountID) {
        try {
            BankAccount bankAccount = bankAccountDAO.get(bankAccountID);
            logger.info("getBankAccount (+)");
            return bankAccount;
        } catch (DaoException e) {
            logger.error("Error getBankAccount");
            e.printStackTrace();
        }
        return null;
    }

/*    public void deleteBankAccount(int bankAccountID){
       bankAccountDAO.delete(bankAccountID);
    }*/

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void blockBankAccount(int bankAccountID, boolean isBlock) {
        try {
            bankAccountDAO.blockCreditCard(bankAccountID, isBlock);
            logger.info("blockBankAccount (+)");
        } catch (DaoException e) {
            logger.error("Error blockBankAccount");
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void transferMoney(final int dstBankAccountID, final int srcBankAccountID, final double transferSum) {
        getTransactionTemplate().execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try {
                    bankAccountDAO.transferMoney(srcBankAccountID, -transferSum);
                    logger.info("transferMoney 1/2(+)");
                    bankAccountDAO.transferMoney(dstBankAccountID, transferSum);
                    logger.info("transferMoney 2/2(+)");
                } catch (DaoException e) {
                    logger.error("Error transferMoney transaction");
                    e.printStackTrace();
                }
                return null;
            }
        });
//                bankAccountDAO.transferMoney(dstBankAccountID, srcBankAccountID, transferSum);
    }

/*
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void payOrder(Order order) {
        bankAccountDAO.payOrder(order);
    }
*/

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void payOrder(final int bankAccountID, final int orderID) {
        getTransactionTemplate().execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try {
                    Order order = orderDao.get(orderID);
                    if (order != null) {
                        if (order.getBankAccount().getId() == bankAccountID) {
                            bankAccountDAO.payOrder(order);
                            logger.info("payOrder 1/2(+)");
                            orderDao.setOrderPay(orderID, true);
                            logger.info("payOrder 1/2(+)");
                        }
                    }
                } catch (DaoException e) {
                    logger.error("Error payOrder transaction ");
                    e.printStackTrace();
                }
                return null;
            }
        });
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Integer> getBankAccountIDList() {
        try {
            List<Integer> bankAccountIDList = bankAccountDAO.getBankAccountIDList();
            logger.info("getBankAccountIDList(+)");
            return bankAccountIDList;
        } catch (DaoException e) {
            logger.error("Error getBankAccountIDList");
            e.printStackTrace();
        }
        return null;

    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<BankAccount> getAll() {
        try {
            List<BankAccount> bankAccountList = bankAccountDAO.getAll();
            logger.info("getAll(+)");
            return bankAccountList;
        } catch (DaoException e) {
            logger.error("Error getAll");
            e.printStackTrace();
        }
        return null;

    }
}

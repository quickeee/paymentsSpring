package by.academy.it.service.impl;

import by.academy.it.dao.impl.BankAccountDao;
import by.academy.it.dao.IBankAccountDao;
import by.academy.it.dao.IOrderDao;
import by.academy.it.dao.impl.OrderDao;
//import by.academy.it.dao.impl.JDBCOrderDAOImpl;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.BankAccount;
import by.academy.it.entity.Order;
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

/**
 * Created by Sam on 15.05.2015.
 */
@Service
public class OrderServiceImpl implements IOrderService {

    private static Logger logger = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    private IOrderDao orderDAO;// = new OrderDao();

    @Autowired
    private IBankAccountDao bankAccountDao;// = new BankAccountDao();

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
    public int addOrder(final int bankAccountID, final double sum) {
        getTransactionTemplate().execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                try {
                    if (sum <= 0) {
                        String error = "Transfer sum < 0";
                        logger.error("Transfer sum < 0");
                        throw new DaoException(new Exception(error));
                    }

                    BankAccount bankAccount = bankAccountDao.get(bankAccountID);
                    logger.info("addOrder.bankAccountDao.get (+)");
                    Order order = new Order(sum, false);
                    logger.info("addOrder.new Order (+)");
                    order.setBankAccount(bankAccount);
                    logger.info("addOrder.setBankAccount (+)");
                    orderDAO.saveOrUpdate(order);
                    logger.info("addOrder.saveOrUpdate (+)");

                    bankAccount.getOrderList().add(order);
                    logger.info("addOrder.getOrderList().add() (+)");
                    bankAccountDao.saveOrUpdate(bankAccount);
                    logger.info("addOrder.saveOrUpdate (+)");
                    return order.getId();
                } catch (DaoException e) {
                    e.printStackTrace();
                }
                return null;
            }
        });

        return 0;
    }
//    public void deleteOrder(int orderID) {
//        orderDAO.deleteOrder(orderID);
//    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public Order getOrder(int orderID) {
        try {
            Order order = orderDAO.get(orderID);
            logger.info("getOrder (+)");
            return order;
        } catch (DaoException e) {
            logger.error("Error getOrder");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Order> getOrderList() {
        try {
            List<Order> orderList = orderDAO.getAll();
            logger.info("getOrderList (+)");
            return orderList;
        } catch (DaoException e) {
            logger.error("Error getOrderList");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.REQUIRED)
    public List<Order> getOrderListByBankAccount(int bankAccountID) {
        try {
            List<Order> orderList = orderDAO.getOrderListByBankAccount(bankAccountID);
            logger.info("getOrderListByBankAccount (+)");
            return orderList;
        } catch (DaoException e) {
            logger.error("Error getOrderListByBankAccount");
            e.printStackTrace();
        }
        return null;
    }

   /* @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void setOrderPay(int orderID, boolean isPaid) throws DaoException {
        orderDAO.setOrderPay(orderID, isPaid);
    }*/

}

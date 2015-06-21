package by.academy.it.dao;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.Order;

import java.util.List;

/**
 * Created by Sam on 15.05.2015.
 */
public interface IOrderDao extends Dao<Order>{
//    int createOrder(Order order);
//    Order getOrder(int orderID);
//    void deleteOrder(int orderID);
//    List<Order> getOrderList();
    List<Order> getOrderListByBankAccount(int bankAccountID) throws DaoException;
    void setOrderPay(int orderID, boolean isPaid) throws DaoException;

}

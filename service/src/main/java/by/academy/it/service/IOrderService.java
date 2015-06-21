package by.academy.it.service;

import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.Order;

import java.util.List;

/**
 * Created by sam on 19.06.2015.
 */
public interface IOrderService {
    int addOrder(int bankAccountID, double sum);

    Order getOrder(int orderID);

    List<Order> getOrderList();

    List<Order> getOrderListByBankAccount(int bankAccountID);

//    void setOrderPay(int orderID, boolean isPaid) throws DaoException;
}

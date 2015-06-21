package by.academy.it.dao.impl;

import by.academy.it.dao.BaseDao;
import by.academy.it.dao.IOrderDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.Order;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

@Repository
public class OrderDao extends BaseDao<Order> implements IOrderDao {


    @Override
    public List<Order> getOrderListByBankAccount(int bankAccountID) throws DaoException {
        List list = Collections.emptyList();
        try {
            Criteria criteria = currentSession().createCriteria(Order.class);
            criteria.add(Restrictions.eq("bankAccount.id", bankAccountID));
            list = criteria.list();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return list;
    }

    @Override
    public void setOrderPay(int orderID, boolean isPaid) throws DaoException {
        try {
            Order order = (Order) currentSession().get(Order.class, orderID);
            order.setPaid(isPaid);
            currentSession().flush();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    private Class getPersistentClass() {
        return (Class<Order>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}

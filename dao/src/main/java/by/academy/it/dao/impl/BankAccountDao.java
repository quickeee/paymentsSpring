package by.academy.it.dao.impl;

import by.academy.it.dao.BaseDao;
import by.academy.it.dao.IBankAccountDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.BankAccount;
import by.academy.it.entity.Order;
//import by.academy.it.utils.DBUtils;
//import by.academy.it.utils.HibernateUtil;
import by.academy.it.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by sam on 18.06.2015.
 */
@Repository
public class BankAccountDao extends BaseDao<BankAccount> implements IBankAccountDao {

    @Override
    public int create(BankAccount bankAccount) throws DaoException {
        try {
            saveOrUpdate(bankAccount);

        }catch (DaoException e){
            e.printStackTrace();
            throw e;
        }
        return bankAccount.getId();
   }

    @Override
    public void blockCreditCard(int bankAccountID, boolean isBlock) throws DaoException {
        try {
            Session session = HibernateUtil.getHibernateUtil().getSession();
            BankAccount bankAccount = (BankAccount) session.get(BankAccount.class, bankAccountID);
            bankAccount.setBlocked(isBlock);
            session.flush();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void transferMoney(int bankAccountID, double transferSum) throws DaoException {
        try {
            Session session = HibernateUtil.getHibernateUtil().getSession();
            BankAccount bankAccount = (BankAccount) session.get(BankAccount.class, bankAccountID);
            double sum = bankAccount.getSum();
            bankAccount.setSum(sum + transferSum);
            session.flush();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

 /*   @Override
    public void transferMoney(int dstBankAccountID, int srcBankAccountID, double transferSum) throws DaoException {
            transferMoney(srcBankAccountID, -transferSum);
            transferMoney(dstBankAccountID, transferSum);
    }*/

    @Override
    public List<Integer> getBankAccountIDList() throws DaoException {
        List list = Collections.emptyList();
        try {
            String hql = "select B.id from by.academy.it.entity.BankAccount B";
            Session session = HibernateUtil.getHibernateUtil().getSession();
            Query query = session.createQuery(hql);
             list = query.list();
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return list;
    }

    @Override
    public void payOrder(Order order) throws DaoException {
        try {
            transferMoney(order.getBankAccount().getId(), -order.getSum());
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }


    private Class getPersistentClass() {
        return (Class<BankAccount>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}

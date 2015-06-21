package by.academy.it.dao.impl;

import by.academy.it.dao.BaseDao;
import by.academy.it.dao.IClientDao;
import by.academy.it.dao.IUserDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.Client;
//import by.academy.it.utils.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;

/**
 * Created by sam on 18.06.2015.
 */
@Repository
public class ClientDao extends BaseDao<Client> implements IClientDao, IUserDao {

    @Override
    public int create(Client client) throws DaoException {
        try {
            saveOrUpdate(client);

        }catch (DaoException e){
            e.printStackTrace();
            throw e;
        }
        return client.getId();

    }

    @Override
    public Client getClientByBankAccountID(int bankAccountID) throws DaoException {
        try {
            String hql = "select C from by.academy.it.entity.Client C where C.bankAccountID=:bankAccountID";
            Query query = currentSession().createQuery(hql);
            query.setParameter("bankAccountID", bankAccountID);
            List result = query.list();
            for (Object client : result) {
                return (Client) client;
            }
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    public Client getClientByLogin(String login) throws DaoException {
        try {
            String hql = "select C from by.academy.it.entity.Client C where C.login=:login";
            Query query = currentSession().createQuery(hql);
            query.setParameter("login", login);
            List result = query.list();
            for (Object client : result) {
                return (Client) client;
            }
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    public boolean loginUser(String login, String password) throws DaoException {
        try {
            Criteria criteria = currentSession().createCriteria(Client.class);
            criteria.add(Restrictions.eq("login", login));
            List list = criteria.list();
            String resievedPass = ((Client) list.get(0)).getPassword();
            return password.equals(resievedPass);
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean logoutUser() {
        return false;
    }

    private Class getPersistentClass() {
        return (Class<Client>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}

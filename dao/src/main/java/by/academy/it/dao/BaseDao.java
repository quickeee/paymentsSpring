package by.academy.it.dao;


import by.academy.it.dao.exceptions.DaoException;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.Order;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;


@Repository
public class BaseDao<T> implements Dao<T> {
    private static Logger log = Logger.getLogger(BaseDao.class);

    @Autowired
    protected SessionFactory sessionFactory;
//    private Transaction transaction = null;

    public BaseDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public BaseDao() {
    }

    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(T t) throws DaoException {
        try {
            currentSession().save(t);
            log.info("save(t):" + t);
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    public void saveOrUpdate(T t) throws DaoException {
        try {
            currentSession().saveOrUpdate(t);
            log.info("saveOrUpdate(t):" + t);
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
    }

    public T get(Serializable id) throws DaoException {
        log.info("Get class by id:" + id);
        T t = null;
        try {
            t = (T) currentSession().get(getPersistentClass(), id);
            log.info("get clazz:" + t);
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    public List<T> getAll() throws DaoException {
        List<T> list = Collections.emptyList();
        try {
            Criteria criteria = currentSession().createCriteria(getPersistentClass());
            criteria.addOrder(Order.desc("id"));
            list = (List<T>) criteria.list();
            log.info("getAll, size=" + list.size());
        } catch (HibernateException e) {
            log.error("Error get " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return list;
    }

    public T load(Serializable id) throws DaoException {
        log.info("Load class by id:" + id);
        T t = null;
        try {
            t = (T) currentSession().load(getPersistentClass(), id);
            log.info("load() clazz:" + t);
        } catch (HibernateException e) {
            log.error("Error load() " + getPersistentClass() + " in Dao" + e);
            throw new DaoException(e);
        }
        return t;
    }

    public void delete(T t) throws DaoException {
        try {
            currentSession().delete(t);
            log.info("Delete:" + t);
        } catch (HibernateException e) {
            log.error("Error save or update PERSON in Dao" + e);
            throw new DaoException(e);
        }
    }

    public static <T> T initializeAndUnproxy(T entity) {
        if (entity == null) {
            throw new NullPointerException("Entity passed for initialization is null");
        }
        Hibernate.initialize(entity);
        if (entity instanceof HibernateProxy) {
            entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();
        }
        return entity;
    }

    private Class getPersistentClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}

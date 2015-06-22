package by.academy.it.dao.impl;

import by.academy.it.dao.BaseDao;
import by.academy.it.dao.ICreditCardDao;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.CreditCard;
import by.academy.it.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;


@Repository
public class CreditCardDao extends BaseDao<CreditCard> implements ICreditCardDao {

    @Override
    public int create(CreditCard creditCard) throws DaoException {
        try {
            saveOrUpdate(creditCard);

        }catch (DaoException e){
            e.printStackTrace();
            throw e;
        }
        return creditCard.getId();
    }

    @Override
    public CreditCard getCreditCardByBankAccountID(int bankAccountID) throws DaoException {
        try {
            String hql = "select C from by.academy.it.entity.CreditCard C,by.academy.it.entity.BankAccount B where B.id=:bankAccountID and B.creditCardID=:C.id";
            Session session = HibernateUtil.getHibernateUtil().getSession();
            Query query = session.createQuery(hql);
            query.setParameter("bankAccountID", bankAccountID);
            List result = query.list();
            for (Object creditCard : result) {
                return (CreditCard) creditCard;
            }
        } catch (HibernateException e) {
            throw new DaoException(e);
        }
        return null;
    }

    private Class getPersistentClass() {
        return (Class<CreditCard>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}

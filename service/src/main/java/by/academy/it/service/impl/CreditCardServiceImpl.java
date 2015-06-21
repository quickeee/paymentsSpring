package by.academy.it.service.impl;

import by.academy.it.dao.impl.CreditCardDao;
import by.academy.it.dao.ICreditCardDao;
//import by.academy.it.dao.impl.JDBCCreditCardDAOImpl;
import by.academy.it.dao.exceptions.DaoException;
import by.academy.it.entity.CreditCard;
import by.academy.it.service.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditCardServiceImpl implements ICreditCardService {

/*    @Autowired
    private ICreditCardDao creditCardDao = new CreditCardDao();

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public int create() throws DaoException {
        return creditCardDao.create(new CreditCard());
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void delete(int creditCardID) throws DaoException {
        CreditCard creditCard = creditCardDao.get(creditCardID);
        if (creditCard != null) {
            creditCardDao.delete(creditCard);
        }
    }*/
}

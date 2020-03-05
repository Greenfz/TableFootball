package pl.fifi.players.repository.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


abstract class DaoBase<T extends Serializable> {

    @PersistenceContext
    protected Session session;
    private Transaction transaction;
    private Class<T> entity;


    public T findOne(String id) {
        return getSession().get(entity, id);
    }

    public List findAll(String id) {
        return getSession().createQuery("from " + entity.getName()).list();
    }

    public T save(T t) {
        session = getSession();
        transaction = session.beginTransaction();
        session.saveOrUpdate(t);
        transaction.commit();
        return t;
    }


    public DaoBase() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        entity = (Class) pt.getActualTypeArguments()[0];
    }

    private Session getSession() {
        if (session == null) {
            session = SessionFactoryProxy.getSessionFactory().openSession();
        }
        return session;
    }


}

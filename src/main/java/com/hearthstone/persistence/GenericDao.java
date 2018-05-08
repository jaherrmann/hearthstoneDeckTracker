package com.hearthstone.persistence;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * This is the generic dao for this project. It will generically insert values
 * @author jeff
 * @param <T>
 */
public class GenericDao<T> {
    private Class<T> type;
    Logger logger =  Logger.getLogger(this.getClass());

    /**
     * No-argument constructor
     */
    public GenericDao() {

    }

    /**
     * This will instantiate the type that the generic dao takes
     * @param type type
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Get the session
     * @return session the session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }

    /**
     * This will get an object by id
     * @param id id
     * @param <T> the type
     * @return entity
     */
    public <T>T getByID(int id) {
        Session session = getSession();
        T entity = (T)session.get( type, id );
        session.close();
        return entity;
    }

    /**
     * This will delete an entity
     * @param entity the entity
     */
    public void delete( T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * This will get all entities
     * @return entity
     */
    public List<T> getAll() {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery( type );
        Root<T> root = query.from( type );
        List<T> entity = session.createQuery( query ).getResultList();

        logger.debug("The list of entity type " + entity);
        session.close();

        return entity;
    }

    /**
     * This will add an entity
     * @param entity entity
     * @return id the id
     */
    public int add(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (Integer)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * This will update an entity
     * @param entity entity
     */
    public void update(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }
}

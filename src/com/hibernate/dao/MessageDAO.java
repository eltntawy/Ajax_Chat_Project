package com.hibernate.dao;

import com.hibernate.pojo.Message;
import com.hibernate.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by eltntawy on 27/03/15.
 */
public class MessageDAO {

    private static SessionFactory sessionFactory;

    protected MessageDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public static SessionFactory getSessionFactory(SessionFactory sessionFactory) {
        return sessionFactory;
    }


    public static  boolean saveMessage(Message message) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            session.persist(message);

            session.getTransaction().commit();
            return true;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            ex.printStackTrace();
            return false;
        }
    }
}

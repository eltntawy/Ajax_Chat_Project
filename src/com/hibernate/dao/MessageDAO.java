package com.hibernate.dao;

import com.hibernate.pojo.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

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
            session.close();
            ex.printStackTrace();
            return false;
        }
    }

    public static List<Message> loadAllMessage() {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            List<Message> messages = session.createCriteria(Message.class).list();

            session.getTransaction().commit();
            return messages;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            session.close();
            ex.printStackTrace();
            return null;
        }
    }
}

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
    private static Session session;


    protected MessageDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        session = sessionFactory.openSession();
    }


    public static SessionFactory getSessionFactory(SessionFactory sessionFactory) {
        return sessionFactory;
    }


    public static  boolean saveMessage(Message message) {

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

    public static List<Message> loadAllMessage() {

        try {
            session.beginTransaction();

            List<Message> messages = session.createCriteria(Message.class).list();

            session.getTransaction().commit();
            return messages;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();

            ex.printStackTrace();
            return null;
        }
    }
}

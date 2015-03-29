package com.hibernate.dao;

import com.hibernate.pojo.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;
import java.util.List;

/**
 * Created by eltntawy on 27/03/15.
 */
public class MessageDAO {

    protected MessageDAO() {
    }


    public static SessionFactory getSessionFactory(SessionFactory sessionFactory) {
        return sessionFactory;
    }


    public static  boolean saveMessage(Message message) {

        Session session = com.hibernate.SessionFactory.getAjaxSession();
        Transaction trx = null;
        try {

            synchronized (MessageDAO.class) {
                trx = session.getTransaction().isParticipating() ? session.getTransaction() : session.beginTransaction();

                session.persist(message);


                if (!trx.isActive()) trx.commit();
            }

            return true;
        } catch (HibernateException ex) {
            trx.rollback();

            ex.printStackTrace();
            return false;
        }
    }

    public static List<Message> loadAllMessage() {

        Session session = com.hibernate.SessionFactory.getAjaxSession();
        Transaction trx = null;
        try {

            synchronized (MessageDAO.class) {
                trx = session.getTransaction().isParticipating() ? session.getTransaction() : session.beginTransaction();

                List<Message> messages = session.createCriteria(Message.class).list();

                if (!trx.isActive()) trx.commit();
                return messages;
            }

        } catch (HibernateException ex) {
            if (trx != null) trx.rollback();

            ex.printStackTrace();
            return null;
        }
    }
}

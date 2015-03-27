package com.hibernate.dao;

import com.hibernate.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import java.util.List;

/**
 * Created by eltntawy on 27/03/15.
 */
public class UserDAO {

    private static SessionFactory sessionFactory;

    protected UserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory(SessionFactory sessionFactory) {
        return sessionFactory;
    }


    public static boolean saveNewUser(User user) {
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            session.persist(user);

            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }
    }

    public static boolean authenticateUser(User user) {

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            User authenticatedUser  = (User) session.createCriteria(User.class).add(Example.create(user)).uniqueResult();

            user.setFullName(authenticatedUser.getFullName());
            user.setId(authenticatedUser.getId());
            user.setEmail(authenticatedUser.getEmail());
            user.setMessagesForFromUser(authenticatedUser.getMessagesForFromUser());
            user.setMessagesForToUser(authenticatedUser.getMessagesForToUser());
            session.getTransaction().commit();
            session.close();

            if(authenticatedUser != null) {
                return true;
            } else {
                return false;
            }

        } catch (HibernateException ex) {
            session.getTransaction().rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }

    }

}
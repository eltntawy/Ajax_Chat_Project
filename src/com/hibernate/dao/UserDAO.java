package com.hibernate.dao;

import com.hibernate.pojo.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by eltntawy on 27/03/15.
 */
public class UserDAO {

    private static SessionFactory sessionFactory;
    private static Session session ;
    protected UserDAO(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
        session = sessionFactory.openSession();
    }

    public SessionFactory getSessionFactory(SessionFactory sessionFactory) {
        return sessionFactory;
    }


    public static boolean saveNewUser(User user) {


        try {
            session.beginTransaction();

            session.persist(user);

            session.getTransaction().commit();

            return true;
        } catch (HibernateException ex) {
            session.getTransaction().rollback();

            ex.printStackTrace();
            return false;
        }
    }

    public static User authenticateUser(User user) {


        try {
            session.beginTransaction();

            User authenticatedUser  = (User) session.createCriteria(User.class).add(Example.create(user)).uniqueResult();

            session.getTransaction().commit();


            return authenticatedUser;

        } catch (HibernateException ex) {
            session.getTransaction().rollback();

            ex.printStackTrace();
            return null;
        }

    }


    public static boolean isAvailableEmail(String email) {
        try {
            session.beginTransaction();

            List<User> authenticatedUser  = session.createCriteria(User.class).add(Restrictions.eq("email",email)).list();

            session.getTransaction().commit();

            return authenticatedUser != null && authenticatedUser.size()==0;

        } catch (HibernateException ex) {
            session.getTransaction().rollback();

            ex.printStackTrace();
            return false;
        }
    }

}
